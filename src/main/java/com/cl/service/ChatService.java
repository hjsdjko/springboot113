package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChatEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChatView;


/**
 * 交流互动
 *
 * @author 
 * @email 
 * @date 2024-04-03 15:12:06
 */
public interface ChatService extends IService<ChatEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChatView> selectListView(Wrapper<ChatEntity> wrapper);
   	
   	ChatView selectView(@Param("ew") Wrapper<ChatEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChatEntity> wrapper);
   	

}

