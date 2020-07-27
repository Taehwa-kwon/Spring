package com.spring.pds.vo;

public class PdsVo {
		
	//Board
		private int idx;
		private String menu_id;
		private String title;
		private String cont;
		private String writer;
		private String regdate;
		private int readcount;
		private int bnum;
		private int lvl ;
		private int step;
		private int nref;
		private int delnum;
		
		//Menu
		//private String menu_id;
		private String menu_name;
		private String menu_seq;
		
		//Files
		//private int idx;
		private String file_num;
		private String filename;
		private String fileext;
		private String sfilename;
		
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

		@Override
		public String toString() {
			return "PdsVo [idx=" + idx + ", menu_id=" + menu_id + ", title=" + title + ", cont=" + cont + ", writer="
					+ writer + ", regdate=" + regdate + ", readcount=" + readcount + ", bnum=" + bnum + ", lvl=" + lvl
					+ ", step=" + step + ", nref=" + nref + ", delnum=" + delnum + ", menu_name=" + menu_name
					+ ", menu_seq=" + menu_seq + ", file_num=" + file_num + ", filename=" + filename + ", fileext="
					+ fileext + ", sfilename=" + sfilename + "]";
		}
		
}
