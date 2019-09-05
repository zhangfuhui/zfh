package com.bawei.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.entity.Dianying;
import com.bawei.entity.Fenlei;
import com.bawei.service.DianService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class DianController {
	
	@Resource
	private DianService ser;
	
	@RequestMapping("list")
	public String FindAll(Model model,@RequestParam(required=false,defaultValue="1")int pageNum,String dname){
		Map<String,Object> map = new HashMap<String, Object>();//获取map集合
		map.put("dname", dname);
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum, 3);//分页
		List<Dianying> list = ser.findAll(map);
		PageInfo<Dianying> page = new PageInfo<Dianying>(list);
		model.addAttribute("page", page);//将数据存入作用域
		model.addAttribute("page", page);//将数据存入作用域
		model.addAttribute("page", page);//将数据存入作用域
		return "list";//返回到页面
	}
	
	@RequestMapping("findfenlei")
	@ResponseBody
	public List<Fenlei> findfenlei(){
		List<Fenlei> list = ser.findfenlei();//查询所有的分类
		return list;//返回获取的数据
	}
	
	@RequestMapping("insertOne")
	@ResponseBody
	public boolean insertOne(Dianying d){
		String fname = d.getFname();//获取集合
		String[] split = fname.split(",");//拆分字符串
		int did = ser.insertDiany(d);//添加并获取id
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("did", did);//存取集合
		for (String string : split) {//循环遍历
			map.put("fid", Integer.parseInt(string));//存入集合
			ser.insertZhong(map);//进行添加将集合传过去
		}
		return true;//返回
	}
	
	@RequestMapping("deleteduo")
	@ResponseBody
	public boolean deleteduo(String a){
		String[] split = a.split(",");
		for (String string : split) {
			ser.deleteduo(Integer.parseInt(string));
		}
		return true;
	}
	
	@RequestMapping("updateselect")
	@ResponseBody
	public Map<String, Object> updateselect(int id){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Fenlei> list = ser.findfenlei();
		map.put("list", list);
		Dianying d = ser.selectOne(id);//获取要修改的数据
		map.put("d", d);
		return map;//返回集合
	}
	
	@RequestMapping("updateOne")
	@ResponseBody
	public boolean updateOne(Dianying d){
		ser.updateOne(d);//修改数据
		ser.deleteOne(d.getId());//删除本电影的所有类型
		String fname = d.getFname();
		String[] split = fname.split(",");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("did", d.getId());
		for (String string : split) {
			map.put("fid", Integer.parseInt(string));
			ser.insertZhong(map);//添加类型
		}
		return true;
	}
	
}
