package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.JijinEntity;
import com.utils.PageUtils;

import java.util.Map;

/**
 * 基金 服务类
 */
public interface JijinService extends IService<JijinEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}