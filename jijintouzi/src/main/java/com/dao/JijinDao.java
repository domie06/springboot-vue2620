package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.JijinEntity;
import com.entity.view.JijinView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基金 Dao 接口
 *
 * @author 
 */
public interface JijinDao extends BaseMapper<JijinEntity> {

   List<JijinView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
