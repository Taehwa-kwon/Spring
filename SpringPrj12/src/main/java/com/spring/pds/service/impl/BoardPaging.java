package com.spring.pds.service.impl;

import com.spring.pds.vo.PdsVo;
/*
 * 	startPageNum								endPageNum 			pageGrpNum
 * 		1			2,3,4,5,6,7,8,9					10					1
 * 		11			12 13 14 15 16 17 18 19 		20					2
 * 		21			22 23 24 25 26 27 28 29 		30					3 
 * 
 * pagetotalcount=10
 * 
 * 
 * 
 * */
public class BoardPaging {
	
	private int recordcount; //pagecount * totalrecordpagecount  전체 게시글 수
	private int nowpage; //현재 페이지 정보
	private int prevnowpage; //이전페이지정보
	private int nextnowpage; //다음페이지정보
	private int pagecount; //1페이지에 보여줄 자료 라인수
	
	private int pagetotalcount;  //한 페이지당 총 개수
	
	private int totalrecordpagecount; //주희야 고마웡ㅇㅇㅇ 딱 10에서 끝나는게 아니라 1 ~ 9 까지 끝나는 경우를 계산하려고  
	
	private int pagegrpnum; //페이지 그룹넘버
	
	private int startpagenum; //시작페이지
	private int endpagenum; // 마지막 페이지
	
	
	private boolean isshowpageprev; //◀ ▶  이거 표시
	private boolean isshowpagenext;
	
	
	public BoardPaging() {}
	
	public BoardPaging(int nowpage, int pagecount, int recordcount, int pagetotalcount, int pagegrpnum) {
		this.nowpage=nowpage;
		this.pagecount=pagecount;
		this.recordcount=recordcount;
		this.pagetotalcount=pagetotalcount;
		this.pagegrpnum=pagegrpnum;
		
	}

	public int getRecordcount() {
		return recordcount;
	}

	public void setRecordcount(int recordcount) {
		this.recordcount = recordcount;
	}

	public int getNowpage() {
		return nowpage;
	}

	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}

	public int getPrevnowpage() {
		return prevnowpage;
	}

	public void setPrevnowpage(int prevnowpage) {
		this.prevnowpage = prevnowpage;
	}

	public int getNextnowpage() {
		return nextnowpage;
	}

	public void setNextnowpage(int nextnowpage) {
		this.nextnowpage = nextnowpage;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

	public int getPagetotalcount() {
		return pagetotalcount;
	}

	public void setPagetotalcount(int pagetotalcount) {
		this.pagetotalcount = pagetotalcount;
	}

	public int getPagegrpnum() {
		return pagegrpnum;
	}

	public void setPagegrpnum(int pagegrpnum) {
		this.pagegrpnum = pagegrpnum;
	}

	public int getStartpagenum() {
		return startpagenum;
	}

	public void setStartpagenum(int startpagenum) {
		this.startpagenum = startpagenum;
	}

	public int getEndpagenum() {
		return endpagenum;
	}

	public void setEndpagenum(int endpagenum) {
		this.endpagenum = endpagenum;
	}

	public int getTotalrecordpagecount() {
		return totalrecordpagecount;
	}

	public void setTotalrecordpagecount(int totalrecordpagecount) {
		this.totalrecordpagecount = totalrecordpagecount;
	}

	public boolean isIsshowpageprev() {
		return isshowpageprev;
	}

	public void setIsshowpageprev(boolean isshowpageprev) {
		this.isshowpageprev = isshowpageprev;
	}

	public boolean isIsshowpagenext() {
		return isshowpagenext;
	}

	public void setIsshowpagenext(boolean isshowpagenext) {
		this.isshowpagenext = isshowpagenext;
	}

	/*
	 * 	startPageNum								endPageNum 			pageGrpNum
	 * 		1			2,3,4,5,6,7,8,9					10					1
	 * 		11			12 13 14 15 16 17 18 19 		20					2
	 * 		21			22 23 24 25 26 27 28 29 		30					3 
	 * 
	 * pagetotalcount=10
	 * 
	 * <ex>
		총 50개의 자료를 한 페이지에 3개씩 보여준다
		-->
		pagecount = 3
		totalpagecount = 10
		totalrecordpagecount = 17 (3개씩 16페이지 + 나머지 2개를 보여주는 페이지)
		recordcount = 50
		
		<ex>
		nowpage = 13  --> prevnowpage = 10 / nextnowpage = 21
	 * 
	 * */
	
	public PdsVo getPdsPagingInfo() {
		PdsVo vo = new PdsVo();
		this.totalrecordpagecount = (int) Math.ceil((double)recordcount/(double)pagecount);
		this.startpagenum = (pagegrpnum-1) * pagetotalcount+1;
		
		this.endpagenum = totalrecordpagecount < (pagegrpnum * pagetotalcount)?totalrecordpagecount : (pagegrpnum * pagetotalcount);
		
		if(startpagenum ==1 )isshowpageprev = false; // 맨앞에 1이면◀  << 이거 표현 안함.  false 
		else 				isshowpageprev = true; 		//이게 있어야지 1이 아니면 화살표가 표시된다. 
		if(endpagenum >= totalrecordpagecount) isshowpagenext = false; //맨뒤에 숫자가 없으면 ▶ 표시안함 false
		else isshowpagenext= true;						//이게 있어야지 1이 아니면 화살표가 표시된다.
		
		this.prevnowpage = startpagenum - 1; // 이전10개
		this.nextnowpage = endpagenum + 1; // 다음 10개

		vo.setNowpage(this.nowpage);
		vo.setPrevnowpage(this.prevnowpage);
		vo.setNextnowpage(this.nextnowpage);

		vo.setRecordcount(this.recordcount);
		vo.setTotalpagecount(this.pagetotalcount); //한 페이지당 총 개수 

		vo.setPagestartnum(this.startpagenum);
		vo.setPageendnum(this.endpagenum);

		vo.setPagecount(this.pagecount);
		vo.setPagegrpnum(this.pagegrpnum);

		vo.setIsshowpagenext(this.isshowpagenext);
		vo.setIsshowpageprev(this.isshowpageprev);
				
		return vo;
	}

	
	
}
