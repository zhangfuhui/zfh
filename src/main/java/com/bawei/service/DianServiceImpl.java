package com.bawei.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.entity.Dianying;
import com.bawei.entity.Fenlei;
import com.bawei.mapper.DianDao;

@Service
public class DianServiceImpl implements DianService{

	@Resource
	private DianDao dao;
	
	public List<Dianying> findAll(Map<String, Object> map) {
		return dao.findAll(map);
	}

	public List<Fenlei> findfenlei() {
		return dao.findfenlei();
	}

	public int insertDiany(Dianying d) {
		dao.insertDiany(d);
		int did = dao.selectOne(d.getDname());
		return did;
	}

	public void insertZhong(Map<String, Object> map) {
		dao.insertZhong(map);
	}

	public void deleteduo(int parseInt) {
		dao.deleteduo(parseInt);
		dao.deletezhong(parseInt);
	}

	public Dianying selectOne(int id) {
		return dao.selectOneee(id);
	}

	public void updateOne(Dianying d) {
		dao.updateOne(d);
	}

	public void deleteOne(Integer id) {
		dao.deleteOne(id);
	}
	
}
