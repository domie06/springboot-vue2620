package com.dao;

import com.entity.JijinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JijinCollectionView;

/**
 * 基金自选 Dao 接口
 *
 * @author 
 */
public interface JijinCollectionDao extends BaseMapper<JijinCollectionEntity> {

   List<JijinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
