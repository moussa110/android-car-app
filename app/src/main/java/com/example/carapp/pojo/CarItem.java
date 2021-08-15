package com.example.carapp.pojo;

import com.google.gson.annotations.SerializedName;

public class CarItem{

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("id")
	private int id;

	@SerializedName("constractionYear")
	private String constractionYear;

	@SerializedName("brand")
	private String brand;

	@SerializedName("isUsed")
	private boolean isUsed;

	public String getImageUrl(){
		return imageUrl;
	}

	public int getId(){
		return id;
	}

	public String getConstractionYear(){
		return constractionYear;
	}

	public String getBrand(){
		return brand;
	}

	public boolean isIsUsed(){
		return isUsed;
	}
}