package com.eclt.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ec_case:
 */
@Entity
@Table(name = "ec_case")
//TODO 报错记录
//问题在于实体被惰性加载并且在完全加载之前发生序列化。
// No serializer found for class org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS) ) (through reference chain: java.util.A
//添加下面代码
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EcCase implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * case_id:
	 */
	private Integer caseId;

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

	public EcCase() {
		super();
	}

	public EcCase(Integer caseId, String caseName, String caseInfo, String caseImg,
			String cPreset) {
		super();
		this.caseId = caseId;
		this.caseName = caseName;
		this.caseInfo = caseInfo;
		this.caseImg = caseImg;
		this.cPreset = cPreset;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "case_id", nullable = false)
	public Integer getCaseId() {
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

	public String toString() {
		return "EcCase [caseId=" + caseId + ",caseName=" + caseName
				+ ",caseInfo=" + caseInfo + ",caseImg=" + caseImg + ",cPreset="
				+ cPreset + "]";
	}

}
