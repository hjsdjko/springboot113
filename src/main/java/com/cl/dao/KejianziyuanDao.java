package com.cl.dao;

import com.cl.entity.KejianziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KejianziyuanView;


/**
 * 课件资源
 * 
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface KejianziyuanDao extends BaseMapper<KejianziyuanEntity> {
	
	List<KejianziyuanView> selectListView(@Param("ew") Wrapper<KejianziyuanEntity> wrapper);

	List<KejianziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<KejianziyuanEntity> wrapper);
	
	KejianziyuanView selectView(@Param("ew") Wrapper<KejianziyuanEntity> wrapper);
	

}
