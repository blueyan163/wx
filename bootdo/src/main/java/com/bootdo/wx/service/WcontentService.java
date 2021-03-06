package com.bootdo.wx.service;

import com.bootdo.wx.domain.WcontentDO;

import java.util.List;
import java.util.Map;

/**
 * 文章内容
 * 
 * @author yanwen
 * @email blueyan163@163.com
 * @date 2018-06-27 15:50:19
 */
public interface WcontentService {
	
	WcontentDO get(Long cid);
	
	List<WcontentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WcontentDO wcontent);
	
	int update(WcontentDO wcontent);
	
	int remove(Long cid);
	
	int batchRemove(Long[] cids);
}
