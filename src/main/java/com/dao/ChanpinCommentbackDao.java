package com.dao;

import com.entity.ChanpinCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinCommentbackView;

/**
 * 农产品评价 Dao 接口
 *
 * @author 
 */
public interface ChanpinCommentbackDao extends BaseMapper<ChanpinCommentbackEntity> {

   List<ChanpinCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
