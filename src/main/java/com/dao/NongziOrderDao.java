package com.dao;

import com.entity.NongziOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongziOrderView;

/**
 * 农资订单 Dao 接口
 *
 * @author 
 */
public interface NongziOrderDao extends BaseMapper<NongziOrderEntity> {

   List<NongziOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
