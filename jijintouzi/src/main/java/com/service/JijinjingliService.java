package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.JijinjingliEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 基金经理 服务类
 */
public interface JijinjingliService extends IService<JijinjingliEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}