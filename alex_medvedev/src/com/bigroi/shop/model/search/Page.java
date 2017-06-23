/**
 * 
 */
package com.bigroi.shop.model.search;

/**
 * @author Alexander Medvedev
 *
 */
public class Page {
	
	private int start;
	
	private int count;
	
	private int pageNo;
	
	public Page() {
		super();
	}

	public Page(int start, int count, int pageNo) {
		super();
		this.start = start;
		this.count = count;
		this.pageNo = pageNo;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
}
