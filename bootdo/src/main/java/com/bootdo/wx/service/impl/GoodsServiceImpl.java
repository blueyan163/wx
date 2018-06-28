package com.bootdo.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.wx.dao.GoodsDao;
import com.bootdo.wx.domain.GoodsDO;
import com.bootdo.wx.service.GoodsService;



@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public GoodsDO get(Long gid){
		return goodsDao.get(gid);
	}
	
	@Override
	public List<GoodsDO> list(Map<String, Object> map){
		return goodsDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return goodsDao.count(map);
	}
	
	@Override
	public int save(GoodsDO goods){
		return goodsDao.save(goods);
	}
	
	@Override
	public int update(GoodsDO goods){
		return goodsDao.update(goods);
	}
	
	@Override
	public int remove(Long gid){
		return goodsDao.remove(gid);
	}
	
	@Override
	public int batchRemove(Long[] gids){
		return goodsDao.batchRemove(gids);
	}
	
}
