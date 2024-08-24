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

import com.cl.entity.KechengzuoyeEntity;
import com.cl.entity.view.KechengzuoyeView;

import com.cl.service.KechengzuoyeService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程作业
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@RestController
@RequestMapping("/kechengzuoye")
public class KechengzuoyeController {
    @Autowired
    private KechengzuoyeService kechengzuoyeService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengzuoyeEntity kechengzuoye,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			kechengzuoye.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			kechengzuoye.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KechengzuoyeEntity> ew = new EntityWrapper<KechengzuoyeEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = kechengzuoyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengzuoye), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengzuoyeEntity kechengzuoye, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date fabushijianend,
		HttpServletRequest request){
        EntityWrapper<KechengzuoyeEntity> ew = new EntityWrapper<KechengzuoyeEntity>();
                if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
                if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);

		PageUtils page = kechengzuoyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengzuoye), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengzuoyeEntity kechengzuoye){
       	EntityWrapper<KechengzuoyeEntity> ew = new EntityWrapper<KechengzuoyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengzuoye, "kechengzuoye")); 
        return R.ok().put("data", kechengzuoyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengzuoyeEntity kechengzuoye){
        EntityWrapper< KechengzuoyeEntity> ew = new EntityWrapper< KechengzuoyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengzuoye, "kechengzuoye")); 
		KechengzuoyeView kechengzuoyeView =  kechengzuoyeService.selectView(ew);
		return R.ok("查询课程作业成功").put("data", kechengzuoyeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengzuoyeEntity kechengzuoye = kechengzuoyeService.selectById(id);
		kechengzuoye = kechengzuoyeService.selectView(new EntityWrapper<KechengzuoyeEntity>().eq("id", id));
        return R.ok().put("data", kechengzuoye);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengzuoyeEntity kechengzuoye = kechengzuoyeService.selectById(id);
		kechengzuoye = kechengzuoyeService.selectView(new EntityWrapper<KechengzuoyeEntity>().eq("id", id));
        return R.ok().put("data", kechengzuoye);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KechengzuoyeEntity kechengzuoye, HttpServletRequest request){
    	kechengzuoye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengzuoye);
        kechengzuoyeService.insert(kechengzuoye);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KechengzuoyeEntity kechengzuoye, HttpServletRequest request){
    	kechengzuoye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengzuoye);
        kechengzuoyeService.insert(kechengzuoye);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KechengzuoyeEntity kechengzuoye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengzuoye);
        kechengzuoyeService.updateById(kechengzuoye);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kechengzuoyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
