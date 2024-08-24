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


import com.cl.dao.ZuoyejinduDao;
import com.cl.entity.ZuoyejinduEntity;
import com.cl.service.ZuoyejinduService;
import com.cl.entity.view.ZuoyejinduView;

@Service("zuoyejinduService")
public class ZuoyejinduServiceImpl extends ServiceImpl<ZuoyejinduDao, ZuoyejinduEntity> implements ZuoyejinduService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuoyejinduEntity> page = this.selectPage(
                new Query<ZuoyejinduEntity>(params).getPage(),
                new EntityWrapper<ZuoyejinduEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuoyejinduEntity> wrapper) {
		  Page<ZuoyejinduView> page =new Query<ZuoyejinduView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZuoyejinduView> selectListView(Wrapper<ZuoyejinduEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuoyejinduView selectView(Wrapper<ZuoyejinduEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
