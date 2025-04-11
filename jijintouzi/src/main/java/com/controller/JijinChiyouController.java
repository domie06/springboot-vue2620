










package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 持有基金
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jijinChiyou")
public class JijinChiyouController {
    private static final Logger logger = LoggerFactory.getLogger(JijinChiyouController.class);

    @Autowired
    private JijinChiyouService jijinChiyouService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JijinService jijinService;// 基金
    @Autowired
    private JingzhiService jingzhiService;//净值
    @Autowired
    private JiaoyijiluService jiaoyijiluService; //记录
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jijinChiyouService.queryPage(params);

        //字典表数据转换
        List<JijinChiyouView> list =(List<JijinChiyouView>)page.getList();


        List<Integer> jijinIds= new ArrayList<>();//基金的id列表
        for(JijinChiyouView c:list){
            Integer jijinId = c.getJijinId();
            jijinIds.add(jijinId);
        }
        //查询出所有的净值列表
        List<JingzhiEntity> jijinJingzhiList = jingzhiService.selectList(new EntityWrapper<JingzhiEntity>().in("jijin_id", jijinIds));
        Map<Integer, List<String>> map = new HashMap<>();
        try {
            for(JingzhiEntity c:jijinJingzhiList){
                Integer jijinId = c.getJijinId();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                if(map.containsKey(jijinId)){
                    List<String> strings = map.get(jijinId);
                    Date oldDate = sdf.parse(strings.get(0));
                    Date newDate = c.getInsertTime();
                    if(oldDate.getTime() < newDate.getTime()){
                        strings = new ArrayList<>();
                        strings.add(sdf.format(c.getInsertTime()));
                        strings.add(c.getJingzhiMoney().toString());
                        map.put(jijinId,strings);
                    }

                }else{
                    List<String> strings = new ArrayList<>();
                    strings.add(sdf.format(c.getInsertTime()));
                    strings.add(c.getJingzhiMoney().toString());
                    map.put(jijinId,strings);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }


        for(JijinChiyouView c:list){
            List<String> strings = map.get(c.getJijinId());
            c.setZuixinjingzhiriqi(strings.get(0));
            c.setZuixinjingzhi(Double.parseDouble(strings.get(1)));
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }



    /**
     * 基金卖出
     */
    @RequestMapping("/maichu")
    public R maichu(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("maichu方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if(!"用户".equals(role))
            return R.error(511,"只有用户才能卖出基金");

        //request.getSession().getAttribute("userId")
        Integer maichuId = Integer.valueOf(String.valueOf(params.get("maichuId")));
        Integer maiFenshu = Integer.valueOf(String.valueOf(params.get("maiFenshu")));

        JijinChiyouEntity jijinChiyouEntity = jijinChiyouService.selectById(maichuId);
        if(jijinChiyouEntity != null){
            if((jijinChiyouEntity.getFenshu()-maiFenshu<0)){
                return R.error(511,"卖出份数不能大于持有份数");
            }
            Integer jijinId = jijinChiyouEntity.getJijinId();
            JijinEntity jijinEntity = jijinService.selectById(jijinId);
            if(jijinEntity == null){
                return R.error(511,"查不到基金");
            }
            List<JingzhiEntity> jingzhiEntities = jingzhiService.selectList(new EntityWrapper<JingzhiEntity>().eq("jijin_id", jijinEntity.getId()).orderBy("insert_time", false));
            if(jingzhiEntities == null || jingzhiEntities.size() < 1 ){
                return R.error(511,"查不到基金的净值情况");
            }
            JingzhiEntity jingzhiEntity = jingzhiEntities.get(0);
            Double jingzhiMoney = jingzhiEntity.getJingzhiMoney();

            double sumMoney = new BigDecimal(jingzhiMoney).multiply(new BigDecimal(maiFenshu)).doubleValue();


            /**
             * 持有基金
             */
            jijinChiyouEntity.setFenshu(jijinChiyouEntity.getFenshu()-maiFenshu);//现有份数 - 卖出份数
            jijinChiyouEntity.setSellSumMoney(jijinChiyouEntity.getSellSumMoney() + sumMoney);//当前总卖出 + 这次总卖出

            /**
             * 用户
             */
            YonghuEntity yonghuEntity = yonghuService.selectById(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            if(yonghuEntity == null){
                return R.error(511,"查不到当前登录用户");
            }else if(!yonghuEntity.getId().equals(jijinChiyouEntity.getYonghuId())){
                return R.error(511,"当前登录用户不是基金持有用户");
            }
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + sumMoney);

            /**
             * 基金记录
             */
            JiaoyijiluEntity jiaoyijiluEntity = new JiaoyijiluEntity();
            jiaoyijiluEntity.setJiaoyijiluTypes(2);
            jiaoyijiluEntity.setInsertTime(new Date());
            jiaoyijiluEntity.setCreateTime(new Date());
            jiaoyijiluEntity.setJijinId(jijinChiyouEntity.getJijinId());
            jiaoyijiluEntity.setJiaoyijiluSumMoney(sumMoney);
            jiaoyijiluEntity.setJiaoyijiluFenshu(maiFenshu);
            jiaoyijiluEntity.setYonghuId(yonghuEntity.getId());


            jiaoyijiluService.insert(jiaoyijiluEntity);
            yonghuService.updateById(yonghuEntity);
            jijinChiyouService.updateById(jijinChiyouEntity);

        }else{
            return R.error(511,"查不到当前用户持有的基金");
        }

        return R.ok();
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JijinChiyouEntity jijinChiyou = jijinChiyouService.selectById(id);
        if(jijinChiyou !=null){
            //entity转view
            JijinChiyouView view = new JijinChiyouView();
            BeanUtils.copyProperties( jijinChiyou , view );//把实体数据重构到view中

                //级联表
                JijinEntity jijin = jijinService.selectById(jijinChiyou.getJijinId());
                if(jijin != null){
                    BeanUtils.copyProperties( jijin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJijinId(jijin.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(jijinChiyou.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JijinChiyouEntity jijinChiyou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jijinChiyou:{}",this.getClass().getName(),jijinChiyou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            jijinChiyou.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        Wrapper<JijinChiyouEntity> queryWrapper = new EntityWrapper<JijinChiyouEntity>()
            .eq("jijin_id", jijinChiyou.getJijinId())
            .eq("yonghu_id", jijinChiyou.getYonghuId())
            .eq("fenshu", jijinChiyou.getFenshu())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijinChiyouEntity jijinChiyouEntity = jijinChiyouService.selectOne(queryWrapper);
        if(jijinChiyouEntity==null){
            jijinChiyou.setInsertTime(new Date());
            jijinChiyou.setCreateTime(new Date());
            jijinChiyouService.insert(jijinChiyou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JijinChiyouEntity jijinChiyou, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jijinChiyou:{}",this.getClass().getName(),jijinChiyou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            jijinChiyou.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JijinChiyouEntity> queryWrapper = new EntityWrapper<JijinChiyouEntity>()
            .notIn("id",jijinChiyou.getId())
            .andNew()
            .eq("jijin_id", jijinChiyou.getJijinId())
            .eq("yonghu_id", jijinChiyou.getYonghuId())
            .eq("fenshu", jijinChiyou.getFenshu())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijinChiyouEntity jijinChiyouEntity = jijinChiyouService.selectOne(queryWrapper);
        if(jijinChiyouEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jijinChiyou.set
            //  }
            jijinChiyouService.updateById(jijinChiyou);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jijinChiyouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<JijinChiyouEntity> jijinChiyouList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JijinChiyouEntity jijinChiyouEntity = new JijinChiyouEntity();
//                            jijinChiyouEntity.setJijinId(Integer.valueOf(data.get(0)));   //基金 要改的
//                            jijinChiyouEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jijinChiyouEntity.setFenshu(Integer.valueOf(data.get(0)));   //持有份数 要改的
//                            jijinChiyouEntity.setBuySumMoney(data.get(0));                    //总购买金额 要改的
//                            jijinChiyouEntity.setSellSumMoney(data.get(0));                    //总卖出金额 要改的
//                            jijinChiyouEntity.setInsertTime(date);//时间
//                            jijinChiyouEntity.setCreateTime(date);//时间
                            jijinChiyouList.add(jijinChiyouEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jijinChiyouService.insertBatch(jijinChiyouList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = jijinChiyouService.queryPage(params);

        //字典表数据转换
        List<JijinChiyouView> list =(List<JijinChiyouView>)page.getList();
        for(JijinChiyouView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JijinChiyouEntity jijinChiyou = jijinChiyouService.selectById(id);
            if(jijinChiyou !=null){


                //entity转view
                JijinChiyouView view = new JijinChiyouView();
                BeanUtils.copyProperties( jijinChiyou , view );//把实体数据重构到view中

                //级联表
                    JijinEntity jijin = jijinService.selectById(jijinChiyou.getJijinId());
                if(jijin != null){
                    BeanUtils.copyProperties( jijin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJijinId(jijin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jijinChiyou.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JijinChiyouEntity jijinChiyou, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jijinChiyou:{}",this.getClass().getName(),jijinChiyou.toString());

        Date date = new Date();
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if(!"用户".equals(role))
            return R.error(511,"您没有支付权限");

        /**
         * 计算购买花费总金额
         */
        BigDecimal jingzhiMoney;
        List<JingzhiEntity> jingzhiEntities = jingzhiService.selectList(new EntityWrapper<JingzhiEntity>().eq("jijin_id", jijinChiyou.getJijinId()).orderBy("insert_time", false));
        if(jingzhiEntities != null && jingzhiEntities.size() > 0){
            JingzhiEntity jingzhiEntity = jingzhiEntities.get(0);
            if(jingzhiEntity != null){
                jingzhiMoney = new BigDecimal(jingzhiEntity.getJingzhiMoney());
            }else{
                return R.error(511,"查不到要购买的基金的净值");
            }
        }else{
            return R.error(511,"查不到要购买的基金的净值列表");
        }
        Double buySumMoney = jingzhiMoney.multiply(new BigDecimal(jijinChiyou.getFenshu())).doubleValue();//购买总花费金额


        /**
         * 扣减余额
         */
        Integer userId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        Double balance = yonghuEntity.getNewMoney() - buySumMoney;
        if(balance < 0.0){
            return R.error(511,"当次购买金额大于您的余额，请去充值");
        }
        yonghuEntity.setNewMoney(balance);
        yonghuService.updateById(yonghuEntity);

        /**
         * 更新当前持有基金
         */
        JijinChiyouEntity jijinChiyouEntity = jijinChiyouService.selectOne(new EntityWrapper<JijinChiyouEntity>().eq("yonghu_id", userId).eq("jijin_id", jijinChiyou.getJijinId()));
        if(jijinChiyouEntity == null){//第一次购买
            jijinChiyou.setBuySumMoney(buySumMoney);
            jijinChiyou.setSellSumMoney(0.0);
            jijinChiyou.setInsertTime(date);
            jijinChiyou.setCreateTime(date);
            jijinChiyou.setYonghuId(userId);
            jijinChiyouService.insert(jijinChiyou);

        }else{//之后购买
            jijinChiyouEntity.setFenshu(jijinChiyou.getFenshu()+jijinChiyouEntity.getFenshu());
            jijinChiyouEntity.setBuySumMoney(jijinChiyouEntity.getBuySumMoney() + buySumMoney);
            jijinChiyouService.updateById(jijinChiyouEntity);
        }

        /**
         * 添加购买记录
         */
        JiaoyijiluEntity jiaoyijiluEntity = new JiaoyijiluEntity();
        jiaoyijiluEntity.setCreateTime(date);
        jiaoyijiluEntity.setInsertTime(date);
        jiaoyijiluEntity.setJiaoyijiluFenshu(jijinChiyou.getFenshu());
        jiaoyijiluEntity.setYonghuId(userId);
        jiaoyijiluEntity.setJiaoyijiluSumMoney(buySumMoney);
        jiaoyijiluEntity.setJijinId(jijinChiyou.getJijinId());
        jiaoyijiluEntity.setJiaoyijiluTypes(1);
        jiaoyijiluService.insert(jiaoyijiluEntity);


        return R.ok();

    }



}
