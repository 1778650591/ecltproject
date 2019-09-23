package com.eclt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ec_product:
 */
@Entity
@Table(name = "ec_product")
public class EcProduct implements Serializable {

	private static final long serialVersionUID = 1L;

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
	 * p_preset:
	 */
	private String pPreset;

	/**
	 * ec_product:
	 */
	private EcProduct ecProduct;

	/**
	 * ec_product:
	 */
	private Set<EcProduct> ecProductSet = new HashSet<EcProduct>(0);

	public EcProduct() {
		super();
	}

	public EcProduct(int productId, String productName, String productInfo,
			String productImg, String pPreset, EcProduct ecProduct,
			Set<EcProduct> ecProductSet) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productInfo = productInfo;
		this.productImg = productImg;
		this.pPreset = pPreset;
		this.ecProduct = ecProduct;
		this.ecProductSet = ecProductSet;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", nullable = false)
	public int getProductId() {
		return productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "product_name", length = 40, nullable = false)
	public String getProductName() {
		return productName;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	@Column(name = "product_info", length = 255)
	public String getProductInfo() {
		return productInfo;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	@Column(name = "product_img", length = 255)
	public String getProductImg() {
		return productImg;
	}

	public void setPPreset(String pPreset) {
		this.pPreset = pPreset;
	}

	@Column(name = "p_preset", length = 20)
	public String getPPreset() {
		return pPreset;
	}

	public void setEcProduct(EcProduct ecProduct) {
		this.ecProduct = ecProduct;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public EcProduct getEcProduct() {
		return ecProduct;
	}

	public void setEcProductSet(Set<EcProduct> ecProductSet) {
		this.ecProductSet = ecProductSet;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ecProduct")
	public Set<EcProduct> getEcProductSet() {
		return ecProductSet;
	}

	public String toString() {
		return "EcProduct [productId=" + productId + ",productName="
				+ productName + ",productInfo=" + productInfo + ",productImg="
				+ productImg + ",pPreset=" + pPreset + ",ecProduct="
				+ ecProduct + ",ecProductSet=" + ecProductSet + "]";
	}

}
