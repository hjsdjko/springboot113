package com.cl.dao;

import com.cl.entity.NianjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NianjiView;


/**
 * 年级
 * 
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface NianjiDao extends BaseMapper<NianjiEntity> {
	
	List<NianjiView> selectListView(@Param("ew") Wrapper<NianjiEntity> wrapper);

	List<NianjiView> selectListView(Pagination page,@Param("ew") Wrapper<NianjiEntity> wrapper);
	
	NianjiView selectView(@Param("ew") Wrapper<NianjiEntity> wrapper);
	

}
