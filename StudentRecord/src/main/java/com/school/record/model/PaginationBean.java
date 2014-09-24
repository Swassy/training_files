package com.school.record.model;

import org.codehaus.jackson.annotate.JsonProperty;

public class PaginationBean {
	@JsonProperty(value="page_no")
	private int page_no;
	
	@JsonProperty(value="contents_per_page")
	private int contents_per_page;
	public void setPageNo(int page_no){
		page_no=page_no;
	}
	/*public void setPageNo(String pg){
		page_no=Integer.parseInt(pg);
	}*/
	public void setContentsPerPage(int contents_per_page){
		contents_per_page=contents_per_page;
	}
	/*public void setContentsPerPage(String cpp){
		contents_per_page=Integer.parseInt(cpp);
	}*/
	public int getPageNo(){
		return page_no;
	}
	public int getContentsPerPage(){
		return contents_per_page;
	}
}
