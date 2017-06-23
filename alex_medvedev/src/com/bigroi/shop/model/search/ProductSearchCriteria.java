/**
 * 
 */
package com.bigroi.shop.model.search;

/**
 * @author Alexander Medvedev
 *
 */
public class ProductSearchCriteria {
	
	private String name;
	
	private String description;
	
	private Page page;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
		

}
