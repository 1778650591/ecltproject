package com.eclt.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * ec_ncp:
 */
@Entity
@Table(name = "ec_ncp")
public class EcNcp implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ncp_id:
	 */
	private int ncpId;

	/**
	 * ncp_name:
	 */
	private String ncpName;

	/**
	 * ncp_img:
	 */
	private String ncpImg;

	/**
	 * ncp_sort:
	 */
	private String ncpSort;

	/**
	 * n_preset:
	 */
	private String nPreset;

	public EcNcp() {
		super();
	}

	public EcNcp(int ncpId, String ncpName, String ncpImg, String ncpSort,
			String nPreset) {
		super();
		this.ncpId = ncpId;
		this.ncpName = ncpName;
		this.ncpImg = ncpImg;
		this.ncpSort = ncpSort;
		this.nPreset = nPreset;
	}

	public void setNcpId(int ncpId) {
		this.ncpId = ncpId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ncp_id", nullable = false)
	public int getNcpId() {
		return ncpId;
	}

	public void setNcpName(String ncpName) {
		this.ncpName = ncpName;
	}

	@Column(name = "ncp_name", length = 40, nullable = false)
	public String getNcpName() {
		return ncpName;
	}

	public void setNcpImg(String ncpImg) {
		this.ncpImg = ncpImg;
	}

	@Column(name = "ncp_img", length = 255)
	public String getNcpImg() {
		return ncpImg;
	}

	public void setNcpSort(String ncpSort) {
		this.ncpSort = ncpSort;
	}

	@Column(name = "ncp_sort", length = 40)
	public String getNcpSort() {
		return ncpSort;
	}

	public void setNPreset(String nPreset) {
		this.nPreset = nPreset;
	}

	@Column(name = "n_preset", length = 40)
	public String getNPreset() {
		return nPreset;
	}

	public String toString() {
		return "EcNcp [ncpId=" + ncpId + ",ncpName=" + ncpName + ",ncpImg="
				+ ncpImg + ",ncpSort=" + ncpSort + ",nPreset=" + nPreset + "]";
	}

}
