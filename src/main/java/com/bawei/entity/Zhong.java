package com.bawei.entity;


public class Zhong implements java.io.Serializable {

	//columns START
	private Integer did;
	private Integer fid;
	//columns END
	public Zhong(){
	}
	public Zhong(Integer did,Integer fid){
		this.did=did;		this.fid=fid;	}

	public void setDid(Integer did){
		this.did=did;
	}
	public Integer getDid(){
		return did;
	}

	public void setFid(Integer fid){
		this.fid=fid;
	}
	public Integer getFid(){
		return fid;
	}
}

