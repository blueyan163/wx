package com.bootdo.wx.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("/wx/test")
public class testController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping()
	@RequiresPermissions("wx:test:test")
	String Goods(){
	    return "wx/test/test";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("wx:test:test")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsDO> goodsList = goodsService.list(query);
		int total = goodsService.count(query);
		PageUtils pageUtils = new PageUtils(goodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("wx:test:add")
	String add(){
	    return "wx/test/add";
	}

	@GetMapping("/edit/{gid}")
	@RequiresPermissions("wx:test:edit")
	String edit(@PathVariable("gid") Long gid,Model model){
		GoodsDO test = goodsService.get(gid);
		model.addAttribute("test", test);
	    return "wx/test/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("wx:test:add")
	public R save( GoodsDO test){
		if(goodsService.save(test)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("wx:test:edit")
	public R update( GoodsDO test){
		goodsService.update(test);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("wx:test:remove")
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
	@RequiresPermissions("wx:test:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] gids){
		goodsService.batchRemove(gids);
		return R.ok();
	}
	
	@RequestMapping(value="/buttonTest2")
    public void buttonTest(String username, String password, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       
        System.out.println("username="+username+" ,password="+password);
        
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        out.write("进入后台");
        out.flush(); 
    }
	
}
