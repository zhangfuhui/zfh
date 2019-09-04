package com.bawei.entity;


public class Dianying implements java.io.Serializable {

	//columns START
	private Integer id;
	private String dname;
	private String jieshao;
	private String daoyan;
	private String startdate;
	//columns END
	private String fname;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Dianying(){
	}
	public Dianying(Integer id,String dname,String jieshao,String daoyan,String startdate){
		this.id=id;		this.dname=dname;		this.jieshao=jieshao;		this.daoyan=daoyan;		this.startdate=startdate;	}

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}

	public void setDname(String dname){
		this.dname=dname;
	}
	public String getDname(){
		return dname;
	}

	public void setJieshao(String jieshao){
		this.jieshao=jieshao;
	}
	public String getJieshao(){
		return jieshao;
	}

	public void setDaoyan(String daoyan){
		this.daoyan=daoyan;
	}
	public String getDaoyan(){
		return daoyan;
	}

	public void setStartdate(String startdate){
		this.startdate=startdate;
	}
	public String getStartdate(){
		return startdate;
	}

	@Override
	public String toString() {
		return "Dianying [id=" + id + ", dname=" + dname + ", jieshao=" + jieshao + ", daoyan=" + daoyan
				+ ", startdate=" + startdate + ", fname=" + fname + "]";
	}
	
	
}

