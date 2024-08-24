package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 课件资源
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@TableName("kejianziyuan")
public class KejianziyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KejianziyuanEntity() {
		
	}
	
	public KejianziyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 课件名称
	 */
					
	private String kejianmingcheng;
	
	/**
	 * 课件封面
	 */
					
	private String kejianfengmian;
	
	/**
	 * 课件简介
	 */
					
	private String kejianjianjie;
	
	/**
	 * 课件附件
	 */
					
	private String kejianfujian;
	
	/**
	 * 课件视频
	 */
					
	private String kejianshipin;
	
	/**
	 * 年级教材
	 */
					
	private String nianji;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：课件名称
	 */
	public void setKejianmingcheng(String kejianmingcheng) {
		this.kejianmingcheng = kejianmingcheng;
	}
	/**
	 * 获取：课件名称
	 */
	public String getKejianmingcheng() {
		return kejianmingcheng;
	}
	/**
	 * 设置：课件封面
	 */
	public void setKejianfengmian(String kejianfengmian) {
		this.kejianfengmian = kejianfengmian;
	}
	/**
	 * 获取：课件封面
	 */
	public String getKejianfengmian() {
		return kejianfengmian;
	}
	/**
	 * 设置：课件简介
	 */
	public void setKejianjianjie(String kejianjianjie) {
		this.kejianjianjie = kejianjianjie;
	}
	/**
	 * 获取：课件简介
	 */
	public String getKejianjianjie() {
		return kejianjianjie;
	}
	/**
	 * 设置：课件附件
	 */
	public void setKejianfujian(String kejianfujian) {
		this.kejianfujian = kejianfujian;
	}
	/**
	 * 获取：课件附件
	 */
	public String getKejianfujian() {
		return kejianfujian;
	}
	/**
	 * 设置：课件视频
	 */
	public void setKejianshipin(String kejianshipin) {
		this.kejianshipin = kejianshipin;
	}
	/**
	 * 获取：课件视频
	 */
	public String getKejianshipin() {
		return kejianshipin;
	}
	/**
	 * 设置：年级教材
	 */
	public void setNianji(String nianji) {
		this.nianji = nianji;
	}
	/**
	 * 获取：年级教材
	 */
	public String getNianji() {
		return nianji;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}

}
