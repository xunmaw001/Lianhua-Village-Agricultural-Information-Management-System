package com.dao;

import com.entity.JishuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JishuView;

/**
 * 农业技术 Dao 接口
 *
 * @author 
 */
public interface JishuDao extends BaseMapper<JishuEntity> {

   List<JishuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
