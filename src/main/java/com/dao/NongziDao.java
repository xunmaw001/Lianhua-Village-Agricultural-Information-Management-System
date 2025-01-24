package com.dao;

import com.entity.NongziEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NongziView;

/**
 * 农资 Dao 接口
 *
 * @author 
 */
public interface NongziDao extends BaseMapper<NongziEntity> {

   List<NongziView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
