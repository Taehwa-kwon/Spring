package com.spring.board.vo;

public class BoardVo {

	private int num;
	private String id;
	private String email;
	
	public BoardVo() {}
	
	public BoardVo(int num, String id,  String email) {
		super();
		this.num = num;
		this.id = id;
		this.email = email;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BoardVo [num=" + num + ", id=" + id + ", email=" + email + "]";
	}
	
	
}
