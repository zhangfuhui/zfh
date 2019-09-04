package com.bawei.service;

import java.util.List;
import java.util.Map;

import com.bawei.entity.Dianying;
import com.bawei.entity.Fenlei;

public interface DianService {

	public List<Dianying> findAll(Map<String, Object> map);

	public List<Fenlei> findfenlei();

	public int insertDiany(Dianying d);

	public void insertZhong(Map<String, Object> map);

	public void deleteduo(int parseInt);

	public Dianying selectOne(int id);

	public void updateOne(Dianying d);

	public void deleteOne(Integer id);
	
}
