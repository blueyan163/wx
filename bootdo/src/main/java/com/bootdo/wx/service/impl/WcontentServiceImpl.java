package com.bootdo.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wx.dao.WcontentDao;
import com.bootdo.wx.domain.WcontentDO;
import com.bootdo.wx.service.WcontentService;



@Service
public class WcontentServiceImpl implements WcontentService {
	@Autowired
	private WcontentDao wcontentDao;
	
	@Override
	public WcontentDO get(Long cid){
		return wcontentDao.get(cid);
	}
	
	@Override
	public List<WcontentDO> list(Map<String, Object> map){
		return wcontentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wcontentDao.count(map);
	}
	
	@Override
	public int save(WcontentDO wcontent){
		return wcontentDao.save(wcontent);
	}
	
	@Override
	public int update(WcontentDO wcontent){
		return wcontentDao.update(wcontent);
	}
	
	@Override
	public int remove(Long cid){
		return wcontentDao.remove(cid);
	}
	
	@Override
	public int batchRemove(Long[] cids){
		return wcontentDao.batchRemove(cids);
	}
	
}
