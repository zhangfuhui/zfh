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
		Map<String,Object> map = new HashMap<String, Object>();//��ȡmap����
		map.put("dname", dname);
		PageHelper pageHelper = new PageHelper();
		pageHelper.startPage(pageNum, 3);//��ҳ
		List<Dianying> list = ser.findAll(map);
		PageInfo<Dianying> page = new PageInfo<Dianying>(list);
		model.addAttribute("page", page);//�����ݴ���������
		model.addAttribute("page", page);//�����ݴ���������
		model.addAttribute("page", page);//�����ݴ���������
		return "list";//���ص�ҳ��
	}
	
	@RequestMapping("findfenlei")
	@ResponseBody
	public List<Fenlei> findfenlei(){
		List<Fenlei> list = ser.findfenlei();//��ѯ���еķ���
		return list;//���ػ�ȡ������
	}
	
	@RequestMapping("insertOne")
	@ResponseBody
	public boolean insertOne(Dianying d){
		String fname = d.getFname();//��ȡ����
		String[] split = fname.split(",");//����ַ���
		int did = ser.insertDiany(d);//��Ӳ���ȡid
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("did", did);//��ȡ����
		for (String string : split) {//ѭ������
			map.put("fid", Integer.parseInt(string));//���뼯��
			ser.insertZhong(map);//������ӽ����ϴ���ȥ
		}
		return true;//����
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
		Dianying d = ser.selectOne(id);//��ȡҪ�޸ĵ�����
		map.put("d", d);
		return map;//���ؼ���
	}
	
	@RequestMapping("updateOne")
	@ResponseBody
	public boolean updateOne(Dianying d){
		ser.updateOne(d);//�޸�����
		ser.deleteOne(d.getId());//ɾ������Ӱ����������
		String fname = d.getFname();
		String[] split = fname.split(",");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("did", d.getId());
		for (String string : split) {
			map.put("fid", Integer.parseInt(string));
			ser.insertZhong(map);//�������
		}
		return true;
	}
	
}
