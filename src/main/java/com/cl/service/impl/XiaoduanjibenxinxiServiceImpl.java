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


import com.cl.dao.XiaoduanjibenxinxiDao;
import com.cl.entity.XiaoduanjibenxinxiEntity;
import com.cl.service.XiaoduanjibenxinxiService;
import com.cl.entity.view.XiaoduanjibenxinxiView;

@Service("xiaoduanjibenxinxiService")
public class XiaoduanjibenxinxiServiceImpl extends ServiceImpl<XiaoduanjibenxinxiDao, XiaoduanjibenxinxiEntity> implements XiaoduanjibenxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoduanjibenxinxiEntity> page = this.selectPage(
                new Query<XiaoduanjibenxinxiEntity>(params).getPage(),
                new EntityWrapper<XiaoduanjibenxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoduanjibenxinxiEntity> wrapper) {
		  Page<XiaoduanjibenxinxiView> page =new Query<XiaoduanjibenxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XiaoduanjibenxinxiView> selectListView(Wrapper<XiaoduanjibenxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoduanjibenxinxiView selectView(Wrapper<XiaoduanjibenxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
