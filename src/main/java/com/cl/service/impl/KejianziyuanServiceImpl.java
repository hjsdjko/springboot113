package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.KejianziyuanDao;
import com.cl.entity.KejianziyuanEntity;
import com.cl.service.KejianziyuanService;
import com.cl.entity.view.KejianziyuanView;

@Service("kejianziyuanService")
public class KejianziyuanServiceImpl extends ServiceImpl<KejianziyuanDao, KejianziyuanEntity> implements KejianziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KejianziyuanEntity> page = this.selectPage(
                new Query<KejianziyuanEntity>(params).getPage(),
                new EntityWrapper<KejianziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KejianziyuanEntity> wrapper) {
		  Page<KejianziyuanView> page =new Query<KejianziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KejianziyuanView> selectListView(Wrapper<KejianziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KejianziyuanView selectView(Wrapper<KejianziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
