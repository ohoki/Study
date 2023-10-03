package com.yedam.web.common;

import lombok.Getter;

@Getter
public class PagingVO {
	private final static int DEFAULT_VAL = 10;
	private int totalData;          //현재 총 데이터 수
	
	private int nowPage;            //현재페이지
	private int cntPage = 10;       //view 안에서 보여줄 페이지 수
	private int startPage;          //시작페이지
	private int endPage;            //끝페이지
	
	private int cntPerPage;         //한 페이지 안에 보여줄 데이터 수
	private int lastPage;           //마지막페이지
	private int start;              //현재 페이지 안에 보여줄 첫번째 데이터    
	private int end;                //현재 페이지 안에 보여줄 마지막 데이터
	
	public PagingVO(int totalData, int nowPage, int cntPerPage) {
		this.totalData = totalData;
		this.nowPage = nowPage;
		this.cntPerPage = cntPerPage;
		calcLastPage();
		calcStartEndPage();
		calcStartEnd();
	}
	
	public PagingVO(int totalData, int nowPage) {
		this(totalData, nowPage, DEFAULT_VAL);
	}
	
	private void calcLastPage() {
		this.lastPage = (int)Math.ceil((double)this.totalData / (double)this.cntPerPage);
	}
	
	// 현재 View 안 시작, 끝 페이지 계산	
	private void calcStartEndPage() {
		this.endPage = (int)Math.ceil((double)this.nowPage / (double)this.cntPage) * this.cntPage;
		if(this.endPage > this.lastPage) {
			this.endPage = this.lastPage;
		}
		this.startPage = (this.endPage - this.cntPage) + 1;
		if(this.startPage < 1) {
			this.startPage = 1;
		}
	}
	
	// 현재 페이지 안에 보여질 첫번째 데이터와 마지막 데이터 -> DB 쿼리 안에 사용할 start, end
	private void calcStartEnd() {
		this.start = ((this.nowPage -1) * this.cntPerPage) + 1;
		this.end = this.nowPage * this.cntPerPage;
		if(this.end > this.totalData) {
			this.end = this.totalData;
		}
	}
}
