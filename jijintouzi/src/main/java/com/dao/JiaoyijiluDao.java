package com.dao;

import com.entity.JiaoyijiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoyijiluView;

/**
 * 交易记录 Dao 接口
 *
 * @author 
 */
public interface JiaoyijiluDao extends BaseMapper<JiaoyijiluEntity> {

   List<JiaoyijiluView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
