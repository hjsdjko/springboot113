package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XiaoduanjibenxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XiaoduanjibenxinxiView;


/**
 * 校端基本信息
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
public interface XiaoduanjibenxinxiService extends IService<XiaoduanjibenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoduanjibenxinxiView> selectListView(Wrapper<XiaoduanjibenxinxiEntity> wrapper);
   	
   	XiaoduanjibenxinxiView selectView(@Param("ew") Wrapper<XiaoduanjibenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoduanjibenxinxiEntity> wrapper);
   	

}

