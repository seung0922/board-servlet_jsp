package org.naruto.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class BoardVO {
	private Long bno;
	private String title,content,writer;
	private Date regdate,updatedate;
	private int viewcnt;
	
	private List<String> fnames;
	
	public BoardVO() {
		fnames = new ArrayList<>();
	}
	
	public void addFileName(String fname) {
		fnames.add(fname);
	}
}
