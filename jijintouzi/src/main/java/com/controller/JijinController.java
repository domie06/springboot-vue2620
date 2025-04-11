
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.JijinEntity;
import com.entity.JijinjingliEntity;
import com.entity.JingzhiEntity;
import com.entity.view.JijinView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import com.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * 基金
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jijin")
public class JijinController {
    private static final Logger logger = LoggerFactory.getLogger(JijinController.class);

    @Autowired
    private JijinService jijinService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JijinjingliService jijinjingliService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private JingzhiService jingzhiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("jijinDeleteStart",1);params.put("jijinDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jijinService.queryPage(params);

        //字典表数据转换
        List<JijinView> list =(List<JijinView>)page.getList();
        for(JijinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JijinEntity jijin = jijinService.selectById(id);
        if(jijin !=null){
            //entity转view
            JijinView view = new JijinView();
            BeanUtils.copyProperties( jijin , view );//把实体数据重构到view中

                //级联表
                JijinjingliEntity jijinjingli = jijinjingliService.selectById(jijin.getJijinjingliId());
                if(jijinjingli != null){
                    BeanUtils.copyProperties( jijinjingli , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJijinjingliId(jijinjingli.getId());
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
    public R save(@RequestBody JijinEntity jijin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jijin:{}",this.getClass().getName(),jijin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JijinEntity> queryWrapper = new EntityWrapper<JijinEntity>()
            .eq("jijinjingli_id", jijin.getJijinjingliId())
            .eq("jijin_uuid_number", jijin.getJijinUuidNumber())
            .eq("jijin_name", jijin.getJijinName())
            .eq("jijin_types", jijin.getJijinTypes())
            .eq("jijin_fengxian_types", jijin.getJijinFengxianTypes())
            .eq("jijin_clicknum", jijin.getJijinClicknum())
            .eq("jijin_tuijian_types", jijin.getJijinTuijianTypes())
            .eq("shangxia_types", jijin.getShangxiaTypes())
            .eq("jijin_delete", jijin.getJijinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijinEntity jijinEntity = jijinService.selectOne(queryWrapper);
        if(jijinEntity==null){
            Date date = new Date();

            jijin.setJijinClicknum(1);
            jijin.setShangxiaTypes(1);
            jijin.setJijinDelete(1);
            jijin.setInsertTime(date);
            jijin.setCreateTime(date);
            jijinService.insert(jijin);

            //设置基金默认净值为1
            JingzhiEntity jingzhiEntity = new JingzhiEntity();
            jingzhiEntity.setCreateTime(date);
            jingzhiEntity.setInsertTime(date);
            jingzhiEntity.setJijinId(jijin.getId());
            jingzhiEntity.setJingzhiMoney(1.0);
            jingzhiService.insert(jingzhiEntity);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JijinEntity jijin, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jijin:{}",this.getClass().getName(),jijin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JijinEntity> queryWrapper = new EntityWrapper<JijinEntity>()
            .notIn("id",jijin.getId())
            .andNew()
            .eq("jijinjingli_id", jijin.getJijinjingliId())
            .eq("jijin_uuid_number", jijin.getJijinUuidNumber())
            .eq("jijin_name", jijin.getJijinName())
            .eq("jijin_types", jijin.getJijinTypes())
            .eq("jijin_fengxian_types", jijin.getJijinFengxianTypes())
            .eq("jijin_clicknum", jijin.getJijinClicknum())
            .eq("jijin_tuijian_types", jijin.getJijinTuijianTypes())
            .eq("shangxia_types", jijin.getShangxiaTypes())
            .eq("jijin_delete", jijin.getJijinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijinEntity jijinEntity = jijinService.selectOne(queryWrapper);
        if("".equals(jijin.getJijinPhoto()) || "null".equals(jijin.getJijinPhoto())){
                jijin.setJijinPhoto(null);
        }
        if(jijinEntity==null){
            jijinService.updateById(jijin);//根据id更新
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
        ArrayList<JijinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JijinEntity jijinEntity = new JijinEntity();
            jijinEntity.setId(id);
            jijinEntity.setJijinDelete(2);
            list.add(jijinEntity);
        }
        if(list != null && list.size() >0){
            jijinService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<JijinEntity> jijinList = new ArrayList<>();//上传的东西
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
                            JijinEntity jijinEntity = new JijinEntity();
//                            jijinEntity.setJijinjingliId(Integer.valueOf(data.get(0)));   //基金经理 要改的
//                            jijinEntity.setJijinUuidNumber(data.get(0));                    //基金代码 要改的
//                            jijinEntity.setJijinName(data.get(0));                    //基金名称 要改的
//                            jijinEntity.setJijinPhoto("");//照片
//                            jijinEntity.setJijinTypes(Integer.valueOf(data.get(0)));   //基金类型 要改的
//                            jijinEntity.setJijinFengxianTypes(Integer.valueOf(data.get(0)));   //基金风险类型 要改的
//                            jijinEntity.setJijinClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            jijinEntity.setJijinTuijianTypes(Integer.valueOf(data.get(0)));   //首页推荐 要改的
//                            jijinEntity.setJijinContent("");//照片
//                            jijinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jijinEntity.setJijinDelete(1);//逻辑删除字段
//                            jijinEntity.setInsertTime(date);//时间
//                            jijinEntity.setCreateTime(date);//时间
                            jijinList.add(jijinEntity);


                            //把要查询是否重复的字段放入map中
                                //基金代码
                                if(seachFields.containsKey("jijinUuidNumber")){
                                    List<String> jijinUuidNumber = seachFields.get("jijinUuidNumber");
                                    jijinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jijinUuidNumber = new ArrayList<>();
                                    jijinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jijinUuidNumber",jijinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //基金代码
                        List<JijinEntity> jijinEntities_jijinUuidNumber = jijinService.selectList(new EntityWrapper<JijinEntity>().in("jijin_uuid_number", seachFields.get("jijinUuidNumber")).eq("jijin_delete", 1));
                        if(jijinEntities_jijinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JijinEntity s:jijinEntities_jijinUuidNumber){
                                repeatFields.add(s.getJijinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [基金代码] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jijinService.insertBatch(jijinList);
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
        PageUtils page = jijinService.queryPage(params);

        //字典表数据转换
        List<JijinView> list =(List<JijinView>)page.getList();
        for(JijinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JijinEntity jijin = jijinService.selectById(id);
        if(jijin !=null){

            //点击数量加1
            jijin.setJijinClicknum(jijin.getJijinClicknum()+1);
            jijinService.updateById(jijin);

            //entity转view
            JijinView view = new JijinView();
            BeanUtils.copyProperties( jijin , view );//把实体数据重构到view中

            Wrapper<JingzhiEntity> eq= new EntityWrapper<JingzhiEntity>()
                    .eq("jijin_id", jijin.getId())
                    .orderBy("insert_time",false)
                    ;
            List<JingzhiEntity> eqJingzhis = jingzhiService.selectList(eq);//查出当前基金所有净值
            List<JingzhiEntity> jingzhiList = new ArrayList<>();
            if(eqJingzhis != null && eqJingzhis.size()>0){
                if(eqJingzhis.size()>30){
                    jingzhiList = eqJingzhis.subList(0,30);//超过三十条 只取三十条
                }else{
                    jingzhiList = eqJingzhis;
                }
                Collections.reverse(jingzhiList);//之前是倒序，在反过来成正序
            }

            view.setJingzhiList(jingzhiList);

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
    public R add(@RequestBody JijinEntity jijin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jijin:{}",this.getClass().getName(),jijin.toString());
        Wrapper<JijinEntity> queryWrapper = new EntityWrapper<JijinEntity>()
            .eq("jijinjingli_id", jijin.getJijinjingliId())
            .eq("jijin_uuid_number", jijin.getJijinUuidNumber())
            .eq("jijin_name", jijin.getJijinName())
            .eq("jijin_types", jijin.getJijinTypes())
            .eq("jijin_fengxian_types", jijin.getJijinFengxianTypes())
            .eq("jijin_clicknum", jijin.getJijinClicknum())
            .eq("jijin_tuijian_types", jijin.getJijinTuijianTypes())
            .eq("shangxia_types", jijin.getShangxiaTypes())
            .eq("jijin_delete", jijin.getJijinDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijinEntity jijinEntity = jijinService.selectOne(queryWrapper);
        if(jijinEntity==null){
            jijin.setJijinDelete(1);
            jijin.setInsertTime(new Date());
            jijin.setCreateTime(new Date());
        jijinService.insert(jijin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
