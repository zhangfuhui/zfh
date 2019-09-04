package com.bawei.entity;


public class Fenlei implements java.io.Serializable {

	//columns START
	private Integer id;
	private String fname;
	//columns END
	public Fenlei(){
	}
	public Fenlei(Integer id,String fname){
		this.id=id;		this.fname=fname;	}

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}

	public void setFname(String fname){
		this.fname=fname;
	}
	public String getFname(){
		return fname;
	}
}

