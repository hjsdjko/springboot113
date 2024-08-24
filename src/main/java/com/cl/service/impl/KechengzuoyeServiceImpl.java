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


import com.cl.dao.KechengzuoyeDao;
import com.cl.entity.KechengzuoyeEntity;
import com.cl.service.KechengzuoyeService;
import com.cl.entity.view.KechengzuoyeView;

@Service("kechengzuoyeService")
public class KechengzuoyeServiceImpl extends ServiceImpl<KechengzuoyeDao, KechengzuoyeEntity> implements KechengzuoyeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengzuoyeEntity> page = this.selectPage(
                new Query<KechengzuoyeEntity>(params).getPage(),
                new EntityWrapper<KechengzuoyeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengzuoyeEntity> wrapper) {
		  Page<KechengzuoyeView> page =new Query<KechengzuoyeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengzuoyeView> selectListView(Wrapper<KechengzuoyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengzuoyeView selectView(Wrapper<KechengzuoyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
