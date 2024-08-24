package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengzuoyeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengzuoyeView;


/**
 * 课程作业
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface KechengzuoyeService extends IService<KechengzuoyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengzuoyeView> selectListView(Wrapper<KechengzuoyeEntity> wrapper);
   	
   	KechengzuoyeView selectView(@Param("ew") Wrapper<KechengzuoyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengzuoyeEntity> wrapper);
   	

}

