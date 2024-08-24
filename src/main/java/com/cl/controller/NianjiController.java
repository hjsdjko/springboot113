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

import com.cl.entity.NianjiEntity;
import com.cl.entity.view.NianjiView;

import com.cl.service.NianjiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 年级
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@RestController
@RequestMapping("/nianji")
public class NianjiController {
    @Autowired
    private NianjiService nianjiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NianjiEntity nianji,
		HttpServletRequest request){
        EntityWrapper<NianjiEntity> ew = new EntityWrapper<NianjiEntity>();

		PageUtils page = nianjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nianji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NianjiEntity nianji, 
		HttpServletRequest request){
        EntityWrapper<NianjiEntity> ew = new EntityWrapper<NianjiEntity>();

		PageUtils page = nianjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nianji), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NianjiEntity nianji){
       	EntityWrapper<NianjiEntity> ew = new EntityWrapper<NianjiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nianji, "nianji")); 
        return R.ok().put("data", nianjiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NianjiEntity nianji){
        EntityWrapper< NianjiEntity> ew = new EntityWrapper< NianjiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nianji, "nianji")); 
		NianjiView nianjiView =  nianjiService.selectView(ew);
		return R.ok("查询年级成功").put("data", nianjiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NianjiEntity nianji = nianjiService.selectById(id);
		nianji = nianjiService.selectView(new EntityWrapper<NianjiEntity>().eq("id", id));
        return R.ok().put("data", nianji);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NianjiEntity nianji = nianjiService.selectById(id);
		nianji = nianjiService.selectView(new EntityWrapper<NianjiEntity>().eq("id", id));
        return R.ok().put("data", nianji);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NianjiEntity nianji, HttpServletRequest request){
    	nianji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nianji);
        nianjiService.insert(nianji);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NianjiEntity nianji, HttpServletRequest request){
    	nianji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nianji);
        nianjiService.insert(nianji);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NianjiEntity nianji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nianji);
        nianjiService.updateById(nianji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nianjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
