package com.cl.dao;

import com.cl.entity.KechengzuoyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengzuoyeView;


/**
 * 课程作业
 * 
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface KechengzuoyeDao extends BaseMapper<KechengzuoyeEntity> {
	
	List<KechengzuoyeView> selectListView(@Param("ew") Wrapper<KechengzuoyeEntity> wrapper);

	List<KechengzuoyeView> selectListView(Pagination page,@Param("ew") Wrapper<KechengzuoyeEntity> wrapper);
	
	KechengzuoyeView selectView(@Param("ew") Wrapper<KechengzuoyeEntity> wrapper);
	

}
