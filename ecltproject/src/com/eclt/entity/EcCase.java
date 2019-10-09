package com.eclt.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * ec_case:
 */
@Entity
@Table(name = "ec_case")
public class EcCase implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * case_id:
	 */
	private int caseId;

	/**
	 * case_name:
	 */
	private String caseName;

	/**
	 * case_info:
	 */
	private String caseInfo;

	/**
	 * case_img:
	 */
	private String caseImg;

	/**
	 * c_preset:
	 */
	private String cPreset;

	/**
	 * case_maximg:
	 */
	private String caseMaximg;

	public EcCase() {
		super();
	}

	public EcCase(int caseId, String caseName, String caseInfo, String caseImg,
			String cPreset, String caseMaximg) {
		super();
		this.caseId = caseId;
		this.caseName = caseName;
		this.caseInfo = caseInfo;
		this.caseImg = caseImg;
		this.cPreset = cPreset;
		this.caseMaximg = caseMaximg;
	}

	public void setCaseId(int caseId) {
		this.caseId = caseId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "case_id", nullable = false)
	public int getCaseId() {
		return caseId;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	@Column(name = "case_name", length = 40, nullable = false)
	public String getCaseName() {
		return caseName;
	}

	public void setCaseInfo(String caseInfo) {
		this.caseInfo = caseInfo;
	}

	@Column(name = "case_info", length = 255)
	public String getCaseInfo() {
		return caseInfo;
	}

	public void setCaseImg(String caseImg) {
		this.caseImg = caseImg;
	}

	@Column(name = "case_img", length = 255)
	public String getCaseImg() {
		return caseImg;
	}

	public void setCPreset(String cPreset) {
		this.cPreset = cPreset;
	}

	@Column(name = "c_preset", length = 40)
	public String getCPreset() {
		return cPreset;
	}

	public void setCaseMaximg(String caseMaximg) {
		this.caseMaximg = caseMaximg;
	}

	@Column(name = "case_maximg", length = 255)
	public String getCaseMaximg() {
		return caseMaximg;
	}

	public String toString() {
		return "EcCase [caseId=" + caseId + ",caseName=" + caseName
				+ ",caseInfo=" + caseInfo + ",caseImg=" + caseImg + ",cPreset="
				+ cPreset + ",caseMaximg=" + caseMaximg + "]";
	}

}
