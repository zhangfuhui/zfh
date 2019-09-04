package com.bawei.mapper;

import java.util.List;
import java.util.Map;

import com.bawei.entity.Dianying;
import com.bawei.entity.Fenlei;

public interface DianDao {

	public List<Dianying> findAll(Map<String, Object> map);

	public List<Fenlei> findfenlei();

	public int insertDiany(Dianying d);

	public void insertZhong(Map<String, Object> map);

	public int selectOne(String string);

	public void deleteduo(int parseInt);

	public void deletezhong(int parseInt);

	public Dianying selectOneee(int id);

	public void updateOne(Dianying d);

	public void deleteOne(Integer id);
	
}
