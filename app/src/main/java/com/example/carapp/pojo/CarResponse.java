package com.example.carapp.pojo;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CarResponse{

	@SerializedName("data")
	private List<CarItem> data;

	@SerializedName("status")
	private int status;

	public List<CarItem> getData(){
		return data;
	}

	public int getStatus(){
		return status;
	}
}