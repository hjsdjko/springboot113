package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZuoyejinduEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoyejinduView;


/**
 * 作业进度
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface ZuoyejinduService extends IService<ZuoyejinduEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuoyejinduView> selectListView(Wrapper<ZuoyejinduEntity> wrapper);
   	
   	ZuoyejinduView selectView(@Param("ew") Wrapper<ZuoyejinduEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuoyejinduEntity> wrapper);
   	

}

