package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KejianziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KejianziyuanView;


/**
 * 课件资源
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface KejianziyuanService extends IService<KejianziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KejianziyuanView> selectListView(Wrapper<KejianziyuanEntity> wrapper);
   	
   	KejianziyuanView selectView(@Param("ew") Wrapper<KejianziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KejianziyuanEntity> wrapper);
   	

}

