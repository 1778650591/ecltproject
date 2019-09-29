package com.eclt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable{

	public Product(int productId, String productName, String productInfo,
			String productImg, String productMinimg, String productMinname,
			String productMaxname, String pPreset) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productInfo = productInfo;
		this.productImg = productImg;
		this.productMinimg = productMinimg;
		this.productMinname = productMinname;
		this.productMaxname = productMaxname;
		this.pPreset = pPreset;
	}

	public Product() {
		super();
	}

	/**
	 * product_id:
	 */
	private int productId;

	/**
	 * product_name:
	 */
	private String productName;

	/**
	 * product_info:
	 */
	private String productInfo;

	/**
	 * product_img:
	 */
	private String productImg;

	/**
	 * product_minimg:
	 */
	private String productMinimg;

	/**
	 * product_minname:
	 */
	private String productMinname;

	/**
	 * product_maxname:
	 */
	private String productMaxname;

	/**
	 * p_preset:
	 */
	private String pPreset;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductMinimg() {
		return productMinimg;
	}

	public void setProductMinimg(String productMinimg) {
		this.productMinimg = productMinimg;
	}

	public String getProductMinname() {
		return productMinname;
	}

	public void setProductMinname(String productMinname) {
		this.productMinname = productMinname;
	}

	public String getProductMaxname() {
		return productMaxname;
	}

	public void setProductMaxname(String productMaxname) {
		this.productMaxname = productMaxname;
	}

	public String getpPreset() {
		return pPreset;
	}

	public void setpPreset(String pPreset) {
		this.pPreset = pPreset;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productInfo=" + productInfo
				+ ", productImg=" + productImg + ", productMinimg="
				+ productMinimg + ", productMinname=" + productMinname
				+ ", productMaxname=" + productMaxname + ", pPreset=" + pPreset
				+ "]";
	}
	
	
	
}
