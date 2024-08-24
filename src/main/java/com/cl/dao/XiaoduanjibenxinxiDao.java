package com.cl.dao;

import com.cl.entity.XiaoduanjibenxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoduanjibenxinxiView;


/**
 * 校端基本信息
 * 
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface XiaoduanjibenxinxiDao extends BaseMapper<XiaoduanjibenxinxiEntity> {
	
	List<XiaoduanjibenxinxiView> selectListView(@Param("ew") Wrapper<XiaoduanjibenxinxiEntity> wrapper);

	List<XiaoduanjibenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XiaoduanjibenxinxiEntity> wrapper);
	
	XiaoduanjibenxinxiView selectView(@Param("ew") Wrapper<XiaoduanjibenxinxiEntity> wrapper);
	

}
