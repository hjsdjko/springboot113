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
 * 校端基本信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@TableName("xiaoduanjibenxinxi")
public class XiaoduanjibenxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XiaoduanjibenxinxiEntity() {
		
	}
	
	public XiaoduanjibenxinxiEntity(T t) {
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
	 * 学校名称
	 */
					
	private String xuexiaomingcheng;
	
	/**
	 * 学校图片
	 */
					
	private String xuexiaotupian;
	
	/**
	 * 学校地址
	 */
					
	private String xuexiaodizhi;
	
	/**
	 * 学校类型
	 */
					
	private String xuexiaoleixing;
	
	/**
	 * 学校简介
	 */
					
	private String xuexiaojianjie;
	
	/**
	 * 校长
	 */
					
	private String xiaozhang;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 师生人数
	 */
					
	private String shishengrenshu;
	
	/**
	 * 所属地区
	 */
					
	private String suoshudiqu;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：学校名称
	 */
	public void setXuexiaomingcheng(String xuexiaomingcheng) {
		this.xuexiaomingcheng = xuexiaomingcheng;
	}
	/**
	 * 获取：学校名称
	 */
	public String getXuexiaomingcheng() {
		return xuexiaomingcheng;
	}
	/**
	 * 设置：学校图片
	 */
	public void setXuexiaotupian(String xuexiaotupian) {
		this.xuexiaotupian = xuexiaotupian;
	}
	/**
	 * 获取：学校图片
	 */
	public String getXuexiaotupian() {
		return xuexiaotupian;
	}
	/**
	 * 设置：学校地址
	 */
	public void setXuexiaodizhi(String xuexiaodizhi) {
		this.xuexiaodizhi = xuexiaodizhi;
	}
	/**
	 * 获取：学校地址
	 */
	public String getXuexiaodizhi() {
		return xuexiaodizhi;
	}
	/**
	 * 设置：学校类型
	 */
	public void setXuexiaoleixing(String xuexiaoleixing) {
		this.xuexiaoleixing = xuexiaoleixing;
	}
	/**
	 * 获取：学校类型
	 */
	public String getXuexiaoleixing() {
		return xuexiaoleixing;
	}
	/**
	 * 设置：学校简介
	 */
	public void setXuexiaojianjie(String xuexiaojianjie) {
		this.xuexiaojianjie = xuexiaojianjie;
	}
	/**
	 * 获取：学校简介
	 */
	public String getXuexiaojianjie() {
		return xuexiaojianjie;
	}
	/**
	 * 设置：校长
	 */
	public void setXiaozhang(String xiaozhang) {
		this.xiaozhang = xiaozhang;
	}
	/**
	 * 获取：校长
	 */
	public String getXiaozhang() {
		return xiaozhang;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：师生人数
	 */
	public void setShishengrenshu(String shishengrenshu) {
		this.shishengrenshu = shishengrenshu;
	}
	/**
	 * 获取：师生人数
	 */
	public String getShishengrenshu() {
		return shishengrenshu;
	}
	/**
	 * 设置：所属地区
	 */
	public void setSuoshudiqu(String suoshudiqu) {
		this.suoshudiqu = suoshudiqu;
	}
	/**
	 * 获取：所属地区
	 */
	public String getSuoshudiqu() {
		return suoshudiqu;
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

}
