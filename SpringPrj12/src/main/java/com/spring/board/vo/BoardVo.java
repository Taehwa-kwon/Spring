package com.spring.board.vo;

public class BoardVo {
	private int idx;
	private String title;
	private String name;
	private String regdate;
	private int count;
	
	
	public BoardVo() {}
	public BoardVo(int idx, String title, String name, String regdate,int count) {
		super();
		this.idx = idx;
		this.title = title;
		this.name = name;
		this.regdate = regdate;
		this.count = count;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "BoardVo [idx=" + idx + ", title=" + title + ", name=" + name + ", regdate=" + regdate + "]";
	}
	
	
}
