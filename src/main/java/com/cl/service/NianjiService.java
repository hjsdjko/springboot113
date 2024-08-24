package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.NianjiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.NianjiView;


/**
 * 年级
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface NianjiService extends IService<NianjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NianjiView> selectListView(Wrapper<NianjiEntity> wrapper);
   	
   	NianjiView selectView(@Param("ew") Wrapper<NianjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NianjiEntity> wrapper);
   	

}

