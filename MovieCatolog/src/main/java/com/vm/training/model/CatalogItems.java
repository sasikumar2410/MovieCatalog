package com.vm.training.model;

public class CatalogItems
{
	private String name;
	private String description;
	private int ratting;



	public CatalogItems() {
		super();
	}



	public CatalogItems(String name, String description, int ratting) {
		super();
		this.name = name;
		this.description = description;
		this.ratting = ratting;
	}



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



	public int getRatting() {
		return ratting;
	}



	public void setRatting(int ratting) {
		this.ratting = ratting;
	}





}
