package com.dao;

import com.entity.ChanpinOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinOrderView;

/**
 * 农产品订单 Dao 接口
 *
 * @author 
 */
public interface ChanpinOrderDao extends BaseMapper<ChanpinOrderEntity> {

   List<ChanpinOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
