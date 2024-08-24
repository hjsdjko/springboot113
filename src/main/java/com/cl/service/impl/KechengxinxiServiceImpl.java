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


import com.cl.dao.KechengxinxiDao;
import com.cl.entity.KechengxinxiEntity;
import com.cl.service.KechengxinxiService;
import com.cl.entity.view.KechengxinxiView;

@Service("kechengxinxiService")
public class KechengxinxiServiceImpl extends ServiceImpl<KechengxinxiDao, KechengxinxiEntity> implements KechengxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengxinxiEntity> page = this.selectPage(
                new Query<KechengxinxiEntity>(params).getPage(),
                new EntityWrapper<KechengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengxinxiEntity> wrapper) {
		  Page<KechengxinxiView> page =new Query<KechengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengxinxiView> selectListView(Wrapper<KechengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengxinxiView selectView(Wrapper<KechengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
