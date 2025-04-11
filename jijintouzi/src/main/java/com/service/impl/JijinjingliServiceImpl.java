package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.JijinjingliDao;
import com.entity.JijinjingliEntity;
import com.entity.view.JijinjingliView;
import com.service.JijinjingliService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 基金经理 服务实现类
 */
@Service("jijinjingliService")
@Transactional
public class JijinjingliServiceImpl extends ServiceImpl<JijinjingliDao, JijinjingliEntity> implements JijinjingliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JijinjingliView> page =new Query<JijinjingliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
