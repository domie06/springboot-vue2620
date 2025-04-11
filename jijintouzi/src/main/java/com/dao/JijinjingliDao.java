package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.JijinjingliEntity;
import com.entity.view.JijinjingliView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基金经理 Dao 接口
 *
 * @author 
 */
public interface JijinjingliDao extends BaseMapper<JijinjingliEntity> {

   List<JijinjingliView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
