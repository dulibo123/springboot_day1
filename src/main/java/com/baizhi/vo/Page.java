package com.baizhi.vo;

public class Page {
	//当前页数
	private int pageNum;
	//每页的条数
	private int pageTotal;
	private int start;
	private int end;
	//总页数
	private int allPage;
	//总条数
	private int allTotal;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.start = (pageNum - 1) * 3 ;
		this.pageTotal=3;
		
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getAllPage() {
		return allPage;
	}
	public void setAllPage(int allPage) {
		this.allPage = allPage;
		
	}
	public int getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(int allTotal) {
		this.allTotal = allTotal;
		// 判断页数
				// 总条数除以每页的条数
				this.allPage = (allTotal % pageTotal == 0) ? allTotal/pageTotal:allTotal/pageTotal + 1;
	}
	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageTotal=" + pageTotal
				+ ", start=" + start + ", end=" + end + ", allPage=" + allPage
				+ ", allTotal=" + allTotal + "]";
	}
	public Page(int pageNum, int pageTotal, int start, int end, int allPage,
			int allTotal) {
		super();
		this.pageNum = pageNum;
		this.pageTotal = pageTotal;
		this.start = start;
		this.end = end;
		this.allPage = allPage;
		this.allTotal = allTotal;
	}
	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
