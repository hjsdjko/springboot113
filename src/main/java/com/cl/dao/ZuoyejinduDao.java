package com.cl.dao;

import com.cl.entity.ZuoyejinduEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoyejinduView;


/**
 * 作业进度
 * 
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface ZuoyejinduDao extends BaseMapper<ZuoyejinduEntity> {
	
	List<ZuoyejinduView> selectListView(@Param("ew") Wrapper<ZuoyejinduEntity> wrapper);

	List<ZuoyejinduView> selectListView(Pagination page,@Param("ew") Wrapper<ZuoyejinduEntity> wrapper);
	
	ZuoyejinduView selectView(@Param("ew") Wrapper<ZuoyejinduEntity> wrapper);
	

}
