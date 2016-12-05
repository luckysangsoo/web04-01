package com.example.web04.model.board.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
    // board table
	private int idx;
	private String userid;
	private String name; // member table 의 name 이라서 나중에 죠인해서 얻는다.
	private String subject;
	private String content;
	private String hit;
	private Date   post_date; // java.sql.Date
	private String filename;
	private long   filesize;
	private int    down;
	private int    ref;
	private int    depth;
	private int    reorder;
	private MultipartFile file1;
	//첨부파일을 저장하기 위한 변수 , getter,setter 추가
    public void setFile1(MultipartFile file1) {
    	this.file1 = file1;
    }
	
    public MultipartFile getFile1() {
		return file1;
	}
    	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	// 매개변수가 있는 생성자 ( userid, subject, content )
	public BoardDTO(String userid, String subject, String content) {
		super();
		this.userid = userid;
		this.subject = subject;
		this.content = content;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getReorder() {
		return reorder;
	}
	public void setReorder(int reorder) {
		this.reorder = reorder;
	}
	
	//toString
	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", userid=" + userid + ", name=" + name + ", subject=" + subject + ", content="
				+ content + ", hit=" + hit + ", post_date=" + post_date + ", filename=" + filename + ", filesize="
				+ filesize + ", down=" + down + ", ref=" + ref + ", depth=" + depth + ", reorder=" + reorder + "]";
	}
	
}
