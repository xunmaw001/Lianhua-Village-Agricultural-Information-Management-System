package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.NongziDao;
import com.entity.NongziEntity;
import com.service.NongziService;
import com.entity.view.NongziView;

/**
 * 农资 服务实现类
 */
@Service("nongziService")
@Transactional
public class NongziServiceImpl extends ServiceImpl<NongziDao, NongziEntity> implements NongziService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<NongziView> page =new Query<NongziView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
