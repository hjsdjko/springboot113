package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XiaoduanjibenxinxiEntity;
import com.cl.entity.view.XiaoduanjibenxinxiView;

import com.cl.service.XiaoduanjibenxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 校端基本信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@RestController
@RequestMapping("/xiaoduanjibenxinxi")
public class XiaoduanjibenxinxiController {
    @Autowired
    private XiaoduanjibenxinxiService xiaoduanjibenxinxiService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiaoduanjibenxinxiEntity xiaoduanjibenxinxi,
		HttpServletRequest request){
        EntityWrapper<XiaoduanjibenxinxiEntity> ew = new EntityWrapper<XiaoduanjibenxinxiEntity>();

		PageUtils page = xiaoduanjibenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoduanjibenxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XiaoduanjibenxinxiEntity xiaoduanjibenxinxi, 
		HttpServletRequest request){
        EntityWrapper<XiaoduanjibenxinxiEntity> ew = new EntityWrapper<XiaoduanjibenxinxiEntity>();

		PageUtils page = xiaoduanjibenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiaoduanjibenxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiaoduanjibenxinxiEntity xiaoduanjibenxinxi){
       	EntityWrapper<XiaoduanjibenxinxiEntity> ew = new EntityWrapper<XiaoduanjibenxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiaoduanjibenxinxi, "xiaoduanjibenxinxi")); 
        return R.ok().put("data", xiaoduanjibenxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiaoduanjibenxinxiEntity xiaoduanjibenxinxi){
        EntityWrapper< XiaoduanjibenxinxiEntity> ew = new EntityWrapper< XiaoduanjibenxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiaoduanjibenxinxi, "xiaoduanjibenxinxi")); 
		XiaoduanjibenxinxiView xiaoduanjibenxinxiView =  xiaoduanjibenxinxiService.selectView(ew);
		return R.ok("查询校端基本信息成功").put("data", xiaoduanjibenxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiaoduanjibenxinxiEntity xiaoduanjibenxinxi = xiaoduanjibenxinxiService.selectById(id);
		xiaoduanjibenxinxi = xiaoduanjibenxinxiService.selectView(new EntityWrapper<XiaoduanjibenxinxiEntity>().eq("id", id));
        return R.ok().put("data", xiaoduanjibenxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiaoduanjibenxinxiEntity xiaoduanjibenxinxi = xiaoduanjibenxinxiService.selectById(id);
		xiaoduanjibenxinxi = xiaoduanjibenxinxiService.selectView(new EntityWrapper<XiaoduanjibenxinxiEntity>().eq("id", id));
        return R.ok().put("data", xiaoduanjibenxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiaoduanjibenxinxiEntity xiaoduanjibenxinxi, HttpServletRequest request){
    	xiaoduanjibenxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoduanjibenxinxi);
        xiaoduanjibenxinxiService.insert(xiaoduanjibenxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiaoduanjibenxinxiEntity xiaoduanjibenxinxi, HttpServletRequest request){
    	xiaoduanjibenxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xiaoduanjibenxinxi);
        xiaoduanjibenxinxiService.insert(xiaoduanjibenxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiaoduanjibenxinxiEntity xiaoduanjibenxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiaoduanjibenxinxi);
        xiaoduanjibenxinxiService.updateById(xiaoduanjibenxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiaoduanjibenxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
