package com.dao;

import com.entity.JijinChiyouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JijinChiyouView;

/**
 * 持有基金 Dao 接口
 *
 * @author 
 */
public interface JijinChiyouDao extends BaseMapper<JijinChiyouEntity> {

   List<JijinChiyouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
