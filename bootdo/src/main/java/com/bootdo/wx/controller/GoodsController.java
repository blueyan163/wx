package com.bootdo.wx.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.wx.domain.GoodsDO;
import com.bootdo.wx.service.GoodsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 宝贝描述
 * 
 * @author yanwen
 * @email blueyan163@163.com
 * @date 2018-06-27 17:22:41
 */
 
@Controller
@RequestMapping("/wx/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping()
	@RequiresPermissions("wx:goods:goods")
	String Goods(){
	    return "wx/goods/goods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wx:goods:goods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsDO> goodsList = goodsService.list(query);
		int total = goodsService.count(query);
		PageUtils pageUtils = new PageUtils(goodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wx:goods:add")
	String add(){
	    return "wx/goods/add";
	}

	@GetMapping("/edit/{gid}")
	@RequiresPermissions("wx:goods:edit")
	String edit(@PathVariable("gid") Long gid,Model model){
		GoodsDO goods = goodsService.get(gid);
		model.addAttribute("goods", goods);
	    return "wx/goods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wx:goods:add")
	public R save( GoodsDO goods){
		if(goodsService.save(goods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wx:goods:edit")
	public R update( GoodsDO goods){
		goodsService.update(goods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wx:goods:remove")
	public R remove( Long gid){
		if(goodsService.remove(gid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wx:goods:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] gids){
		goodsService.batchRemove(gids);
		return R.ok();
	}
	
}
