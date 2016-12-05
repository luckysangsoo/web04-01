package com.example.web04.model.memo.dto;

import java.sql.Date;

public class MemoDTO {
	private int idx;
	private String writer;
	private String memo;
	private Date write_date; //java.sql.Date
	
	//기본생성자
	public MemoDTO() {
		// TODO Auto-generated constructor stub
	}
	// 매개변수가 있는 생성자 (idx, write_date 제외)
	public MemoDTO(String writer, String memo) {
		super();
		this.writer = writer;
		this.memo = memo;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	@Override
	public String toString() {
		return "MemoDTO [idx=" + idx + ", writer=" + writer + ", memo=" + memo + ", write_date=" + write_date + "]";
	}
	
}
