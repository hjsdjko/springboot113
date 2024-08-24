package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengxinxiView;


/**
 * 课程信息
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface KechengxinxiService extends IService<KechengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengxinxiView> selectListView(Wrapper<KechengxinxiEntity> wrapper);
   	
   	KechengxinxiView selectView(@Param("ew") Wrapper<KechengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengxinxiEntity> wrapper);
   	

}

