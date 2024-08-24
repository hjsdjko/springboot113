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


import com.cl.dao.NianjiDao;
import com.cl.entity.NianjiEntity;
import com.cl.service.NianjiService;
import com.cl.entity.view.NianjiView;

@Service("nianjiService")
public class NianjiServiceImpl extends ServiceImpl<NianjiDao, NianjiEntity> implements NianjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NianjiEntity> page = this.selectPage(
                new Query<NianjiEntity>(params).getPage(),
                new EntityWrapper<NianjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NianjiEntity> wrapper) {
		  Page<NianjiView> page =new Query<NianjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<NianjiView> selectListView(Wrapper<NianjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NianjiView selectView(Wrapper<NianjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
