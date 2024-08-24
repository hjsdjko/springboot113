package com.cl.entity.view;

import com.cl.entity.XiaoduanjibenxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 校端基本信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@TableName("xiaoduanjibenxinxi")
public class XiaoduanjibenxinxiView  extends XiaoduanjibenxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoduanjibenxinxiView(){
	}
 
 	public XiaoduanjibenxinxiView(XiaoduanjibenxinxiEntity xiaoduanjibenxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoduanjibenxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
