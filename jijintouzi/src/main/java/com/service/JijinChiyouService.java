package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JijinChiyouEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 持有基金 服务类
 */
public interface JijinChiyouService extends IService<JijinChiyouEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}