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

import com.cl.entity.ZuoyejinduEntity;
import com.cl.entity.view.ZuoyejinduView;

import com.cl.service.ZuoyejinduService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 作业进度
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@RestController
@RequestMapping("/zuoyejindu")
public class ZuoyejinduController {
    @Autowired
    private ZuoyejinduService zuoyejinduService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoyejinduEntity zuoyejindu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zuoyejindu.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			zuoyejindu.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoyejinduEntity> ew = new EntityWrapper<ZuoyejinduEntity>();

		PageUtils page = zuoyejinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyejindu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoyejinduEntity zuoyejindu, 
		HttpServletRequest request){
        EntityWrapper<ZuoyejinduEntity> ew = new EntityWrapper<ZuoyejinduEntity>();

		PageUtils page = zuoyejinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyejindu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoyejinduEntity zuoyejindu){
       	EntityWrapper<ZuoyejinduEntity> ew = new EntityWrapper<ZuoyejinduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyejindu, "zuoyejindu")); 
        return R.ok().put("data", zuoyejinduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoyejinduEntity zuoyejindu){
        EntityWrapper< ZuoyejinduEntity> ew = new EntityWrapper< ZuoyejinduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyejindu, "zuoyejindu")); 
		ZuoyejinduView zuoyejinduView =  zuoyejinduService.selectView(ew);
		return R.ok("查询作业进度成功").put("data", zuoyejinduView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoyejinduEntity zuoyejindu = zuoyejinduService.selectById(id);
		zuoyejindu = zuoyejinduService.selectView(new EntityWrapper<ZuoyejinduEntity>().eq("id", id));
        return R.ok().put("data", zuoyejindu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoyejinduEntity zuoyejindu = zuoyejinduService.selectById(id);
		zuoyejindu = zuoyejinduService.selectView(new EntityWrapper<ZuoyejinduEntity>().eq("id", id));
        return R.ok().put("data", zuoyejindu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuoyejinduEntity zuoyejindu, HttpServletRequest request){
    	zuoyejindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyejindu);
        zuoyejinduService.insert(zuoyejindu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyejinduEntity zuoyejindu, HttpServletRequest request){
    	zuoyejindu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyejindu);
        zuoyejinduService.insert(zuoyejindu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuoyejinduEntity zuoyejindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyejindu);
        zuoyejinduService.updateById(zuoyejindu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuoyejinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
