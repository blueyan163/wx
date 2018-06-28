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

import com.bootdo.wx.domain.WcontentDO;
import com.bootdo.wx.service.WcontentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 文章内容
 * 
 * @author yanwen
 * @email blueyan163@163.com
 * @date 2018-06-27 15:50:19
 */
 
@Controller
@RequestMapping("/wx/wcontent")
public class WcontentController {
	@Autowired
	private WcontentService wcontentService;
	
	@GetMapping()
	@RequiresPermissions("wx:wcontent:wcontent")
	String Wcontent(){
	    return "wx/wcontent/wcontent";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wx:wcontent:wcontent")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WcontentDO> wcontentList = wcontentService.list(query);
		int total = wcontentService.count(query);
		PageUtils pageUtils = new PageUtils(wcontentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wx:wcontent:add")
	String add(){
	    return "wx/wcontent/add";
	}

	@GetMapping("/edit/{cid}")
	@RequiresPermissions("wx:wcontent:edit")
	String edit(@PathVariable("cid") Long cid,Model model){
		WcontentDO wcontent = wcontentService.get(cid);
		model.addAttribute("wcontent", wcontent);
	    return "wx/wcontent/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wx:wcontent:add")
	public R save( WcontentDO wcontent){
		if(wcontentService.save(wcontent)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wx:wcontent:edit")
	public R update( WcontentDO wcontent){
		wcontentService.update(wcontent);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wx:wcontent:remove")
	public R remove( Long cid){
		if(wcontentService.remove(cid)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("wx:wcontent:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] cids){
		wcontentService.batchRemove(cids);
		return R.ok();
	}
	
}
