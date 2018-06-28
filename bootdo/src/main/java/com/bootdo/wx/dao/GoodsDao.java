package com.bootdo.wx.dao;

import com.bootdo.wx.domain.GoodsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 宝贝描述
 * @author yanwen
 * @email blueyan163@163.com
 * @date 2018-06-27 17:22:41
 */
@Mapper
public interface GoodsDao {

	GoodsDO get(Long gid);
	
	List<GoodsDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(GoodsDO goods);
	
	int update(GoodsDO goods);
	
	int remove(Long gid);
	
	int batchRemove(Long[] gids);
}
