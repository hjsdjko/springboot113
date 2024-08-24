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

import com.cl.entity.KejianziyuanEntity;
import com.cl.entity.view.KejianziyuanView;

import com.cl.service.KejianziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 课件资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-03 15:12:05
 */
@RestController
@RequestMapping("/kejianziyuan")
public class KejianziyuanController {
    @Autowired
    private KejianziyuanService kejianziyuanService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KejianziyuanEntity kejianziyuan,
		HttpServletRequest request){
        EntityWrapper<KejianziyuanEntity> ew = new EntityWrapper<KejianziyuanEntity>();

		PageUtils page = kejianziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kejianziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KejianziyuanEntity kejianziyuan, 
		HttpServletRequest request){
        EntityWrapper<KejianziyuanEntity> ew = new EntityWrapper<KejianziyuanEntity>();

		PageUtils page = kejianziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kejianziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KejianziyuanEntity kejianziyuan){
       	EntityWrapper<KejianziyuanEntity> ew = new EntityWrapper<KejianziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kejianziyuan, "kejianziyuan")); 
        return R.ok().put("data", kejianziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KejianziyuanEntity kejianziyuan){
        EntityWrapper< KejianziyuanEntity> ew = new EntityWrapper< KejianziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kejianziyuan, "kejianziyuan")); 
		KejianziyuanView kejianziyuanView =  kejianziyuanService.selectView(ew);
		return R.ok("查询课件资源成功").put("data", kejianziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KejianziyuanEntity kejianziyuan = kejianziyuanService.selectById(id);
		kejianziyuan.setClicktime(new Date());
		kejianziyuanService.updateById(kejianziyuan);
		kejianziyuan = kejianziyuanService.selectView(new EntityWrapper<KejianziyuanEntity>().eq("id", id));
        return R.ok().put("data", kejianziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KejianziyuanEntity kejianziyuan = kejianziyuanService.selectById(id);
		kejianziyuan.setClicktime(new Date());
		kejianziyuanService.updateById(kejianziyuan);
		kejianziyuan = kejianziyuanService.selectView(new EntityWrapper<KejianziyuanEntity>().eq("id", id));
        return R.ok().put("data", kejianziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KejianziyuanEntity kejianziyuan, HttpServletRequest request){
    	kejianziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kejianziyuan);
        kejianziyuanService.insert(kejianziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KejianziyuanEntity kejianziyuan, HttpServletRequest request){
    	kejianziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kejianziyuan);
        kejianziyuanService.insert(kejianziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KejianziyuanEntity kejianziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kejianziyuan);
        kejianziyuanService.updateById(kejianziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kejianziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,KejianziyuanEntity kejianziyuan, HttpServletRequest request,String pre){
        EntityWrapper<KejianziyuanEntity> ew = new EntityWrapper<KejianziyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = kejianziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kejianziyuan), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 按收藏推荐
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,KejianziyuanEntity kejianziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "kejianmingcheng";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "kejianziyuan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<KejianziyuanEntity> kejianziyuanList = new ArrayList<KejianziyuanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                kejianziyuanList.addAll(kejianziyuanService.selectList(new EntityWrapper<KejianziyuanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<KejianziyuanEntity> ew = new EntityWrapper<KejianziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = kejianziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kejianziyuan), params), params));
        List<KejianziyuanEntity> pageList = (List<KejianziyuanEntity>)page.getList();
        if(kejianziyuanList.size()<limit) {
            int toAddNum = (limit-kejianziyuanList.size())<=pageList.size()?(limit-kejianziyuanList.size()):pageList.size();
            for(KejianziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(KejianziyuanEntity o2 : kejianziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    kejianziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(kejianziyuanList.size()>limit) {
            kejianziyuanList = kejianziyuanList.subList(0, limit);
        }
        page.setList(kejianziyuanList);
        return R.ok().put("data", page);
    }







}
