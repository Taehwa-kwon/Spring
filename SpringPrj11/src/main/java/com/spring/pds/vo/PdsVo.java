package com.spring.pds.vo;

public class PdsVo {
		
		//Board 게시글 처리 
		private int idx;
		private String menu_id;
		private String title;
		private String cont;
		private String writer;
		private String regdate;
		private int readcount;
		
		//답글처리
		private int bnum; //글번호
		private int lvl ; //답변 단계
		private int step; //출력순서
		private int nref; // 글 그룹번호
		private int delnum; //글 삭제 여부
		
		//Menu
		//private String menu_id;
		private String menu_name;
		private String menu_seq;
		
		//Files
		//private int idx;
		/* 파일이 1개일때 */
		private String file_num;
		private String filename;
		private String fileext;
		private String sfilename;
		/* 파일이 여러개 일때 */
		private int filescount; //출력할 파일의 수
		
		//페이징 관련 변수 ( 게시판 하단에 1,2,3,4,5 이런 페이지)
		private int nowpage; // 현재 페이지 정보
		private int prevnowpage; // 이전 페이지 정보 
		private int nextnowpage; // 다음 페이지 정보
		
		private int totalcount; //전체 자료수
		private int totalpagecount; //전체 페이지수
		
		private int pagestartnum; //페이지 시작 번호 ( 단일 화면 ) 
		private int pageendnum; //페이지 끝 번호 ( 단일 화면 )
		private int pagegrpnum; //페이지그룹번호
		
		private int pagecount; // 1페이지에 보여줄 자료 라인수
		
		private boolean isshowpageprev; 
		private boolean isshowpagenext;
		
	

		public PdsVo() {}
		
		public PdsVo(int idx, String menu_id, String title, String cont, String writer, String regdate, int readcount,
				int bnum, int lvl, int step, int nref, int delnum, String menu_name, String menu_seq, String file_num,
				String filename, String fileext, String sfilename) {
			this.idx = idx;
			this.menu_id = menu_id;
			this.title = title;
			this.cont = cont;
			this.writer = writer;
			this.regdate = regdate;
			this.readcount = readcount;
			this.bnum = bnum;
			this.lvl = lvl;
			this.step = step;
			this.nref = nref;
			this.delnum = delnum;
			this.menu_name = menu_name;
			this.menu_seq = menu_seq;
			this.file_num = file_num;
			this.filename = filename;
			this.fileext = fileext;
			this.sfilename = sfilename;
		}

		
		
		public PdsVo(int idx, String menu_id, String title, String cont, String writer, String regdate, int readcount,
				int bnum, int lvl, int step, int nref, int delnum, String menu_name, String menu_seq, String file_num,
				String filename, String fileext, String sfilename, int filescount, int nowpage, int prevnowpage,
				int nextnowpage, int totalcount, int totalpagecount, int pagestartnum, int pageendnum, int pagegroupnum,
				int pagecount, boolean isshowpageprev, boolean isshowpagenext) {
			super();
			this.idx = idx;
			this.menu_id = menu_id;
			this.title = title;
			this.cont = cont;
			this.writer = writer;
			this.regdate = regdate;
			this.readcount = readcount;
			this.bnum = bnum;
			this.lvl = lvl;
			this.step = step;
			this.nref = nref;
			this.delnum = delnum;
			this.menu_name = menu_name;
			this.menu_seq = menu_seq;
			this.file_num = file_num;
			this.filename = filename;
			this.fileext = fileext;
			this.sfilename = sfilename;
			this.filescount = filescount;
			this.nowpage = nowpage;
			this.prevnowpage = prevnowpage;
			this.nextnowpage = nextnowpage;
			this.totalcount = totalcount;
			this.totalpagecount = totalpagecount;
			this.pagestartnum = pagestartnum;
			this.pageendnum = pageendnum;
			this.pagecount = pagecount;
			this.isshowpageprev = isshowpageprev;
			this.isshowpagenext = isshowpagenext;
		}
		
		public int getPagegrpnum() {
			return pagegrpnum;
		}

		public void setPagegrpnum(int pagegrpnum) {
			this.pagegrpnum = pagegrpnum;
		}
		
		public String getMenu_name() {
			return menu_name;
		}

		public void setMenu_name(String menu_name) {
			this.menu_name = menu_name;
		}

		public String getMenu_seq() {
			return menu_seq;
		}

		public void setMenu_seq(String menu_seq) {
			this.menu_seq = menu_seq;
		}

		public String getFile_num() {
			return file_num;
		}

		public void setFile_num(String file_num) {
			this.file_num = file_num;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public String getFileext() {
			return fileext;
		}

		public void setFileext(String fileext) {
			this.fileext = fileext;
		}

		public String getSfilename() {
			return sfilename;
		}

		public void setSfilename(String sfilename) {
			this.sfilename = sfilename;
		}

		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public String getMenu_id() {
			return menu_id;
		}
		public void setMenu_id(String menu_id) {
			this.menu_id = menu_id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCont() {
			return cont;
		}
		public void setCont(String cont) {
			this.cont = cont;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getRegdate() {
			return regdate;
		}
		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}
		public int getReadcount() {
			return readcount;
		}
		public void setReadcount(int readcount) {
			this.readcount = readcount;
		}
		public int getBnum() {
			return bnum;
		}
		public void setBnum(int bnum) {
			this.bnum = bnum;
		}
		public int getLvl() {
			return lvl;
		}
		public void setLvl(int lvl) {
			this.lvl = lvl;
		}
		public int getStep() {
			return step;
		}
		public void setStep(int step) {
			this.step = step;
		}
		public int getNref() {
			return nref;
		}
		public void setNref(int nref) {
			this.nref = nref;
		}
		public int getDelnum() {
			return delnum;
		}
		public void setDelnum(int delnum) {
			this.delnum = delnum;
		}
		
		public int getFilescount() {
			return filescount;
		}

		public void setFilescount(int filescount) {
			this.filescount = filescount;
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

		public int getTotalcount() {
			return totalcount;
		}

		public void setTotalcount(int totalcount) {
			this.totalcount = totalcount;
		}

		public int getTotalpagecount() {
			return totalpagecount;
		}

		public void setTotalpagecount(int totalpagecount) {
			this.totalpagecount = totalpagecount;
		}

		public int getPagestartnum() {
			return pagestartnum;
		}

		public void setPagestartnum(int pagestartnum) {
			this.pagestartnum = pagestartnum;
		}

		public int getPageendnum() {
			return pageendnum;
		}

		public void setPageendnum(int pageendnum) {
			this.pageendnum = pageendnum;
		}


		public int getPagecount() {
			return pagecount;
		}

		public void setPagecount(int pagecount) {
			this.pagecount = pagecount;
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
		
		
		@Override
		public String toString() {
			return "PdsVo [idx=" + idx + ", menu_id=" + menu_id + ", title=" + title + ", cont=" + cont + ", writer="
					+ writer + ", regdate=" + regdate + ", readcount=" + readcount + ", bnum=" + bnum + ", lvl=" + lvl
					+ ", step=" + step + ", nref=" + nref + ", delnum=" + delnum + ", menu_name=" + menu_name
					+ ", menu_seq=" + menu_seq + ", file_num=" + file_num + ", filename=" + filename + ", fileext="
					+ fileext + ", sfilename=" + sfilename + ", filescount=" + filescount + ", nowpage=" + nowpage
					+ ", prevnowpage=" + prevnowpage + ", nextnowpage=" + nextnowpage + ", totalcount=" + totalcount
					+ ", totalpagecount=" + totalpagecount + ", pagestartnum=" + pagestartnum + ", pageendnum="
					+ pageendnum + ", pagegrpnum=" + pagegrpnum + ", pagecount=" + pagecount + ", isshowpageprev="
					+ isshowpageprev + ", isshowpagenext=" + isshowpagenext + "]";
		}
		
		
		
}
