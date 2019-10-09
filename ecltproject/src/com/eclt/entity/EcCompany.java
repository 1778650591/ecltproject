package com.eclt.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * ec_company:
 */
@Entity
@Table(name = "ec_company")
public class EcCompany implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * co_id:
	 */
	private int coId;

	/**
	 * co_name:
	 */
	private String coName;

	/**
	 * co_address:
	 */
	private String coAddress;

	/**
	 * co_postcode:
	 */
	private int coPostcode;

	/**
	 * co_fax:
	 */
	private String coFax;

	/**
	 * co_contact:
	 */
	private String coContact;

	/**
	 * co_mobile:
	 */
	private long coMobile;

	/**
	 * co_cooperate:
	 */
	private String coCooperate;

	/**
	 * co_websitenum:
	 */
	private String coWebsitenum;

	/**
	 * co_mail:
	 */
	private String coMail;

	/**
	 * co_preset:
	 */
	private String coPreset;

	public EcCompany() {
		super();
	}

	public EcCompany(int coId, String coName, String coAddress, int coPostcode,
			String coFax, String coContact, long coMobile, String coCooperate,
			String coWebsitenum, String coMail, String coPreset) {
		super();
		this.coId = coId;
		this.coName = coName;
		this.coAddress = coAddress;
		this.coPostcode = coPostcode;
		this.coFax = coFax;
		this.coContact = coContact;
		this.coMobile = coMobile;
		this.coCooperate = coCooperate;
		this.coWebsitenum = coWebsitenum;
		this.coMail = coMail;
		this.coPreset = coPreset;
	}

	public void setCoId(int coId) {
		this.coId = coId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co_id", nullable = false)
	public int getCoId() {
		return coId;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	@Column(name = "co_name", length = 255)
	public String getCoName() {
		return coName;
	}

	public void setCoAddress(String coAddress) {
		this.coAddress = coAddress;
	}

	@Column(name = "co_address", length = 255)
	public String getCoAddress() {
		return coAddress;
	}

	public void setCoPostcode(int coPostcode) {
		this.coPostcode = coPostcode;
	}

	@Column(name = "co_postcode")
	public int getCoPostcode() {
		return coPostcode;
	}

	public void setCoFax(String coFax) {
		this.coFax = coFax;
	}

	@Column(name = "co_fax", length = 255)
	public String getCoFax() {
		return coFax;
	}

	public void setCoContact(String coContact) {
		this.coContact = coContact;
	}

	@Column(name = "co_contact", length = 255)
	public String getCoContact() {
		return coContact;
	}

	public void setCoMobile(long coMobile) {
		this.coMobile = coMobile;
	}

	@Column(name = "co_mobile")
	public long getCoMobile() {
		return coMobile;
	}

	public void setCoCooperate(String coCooperate) {
		this.coCooperate = coCooperate;
	}

	@Column(name = "co_cooperate", length = 255)
	public String getCoCooperate() {
		return coCooperate;
	}

	public void setCoWebsitenum(String coWebsitenum) {
		this.coWebsitenum = coWebsitenum;
	}

	@Column(name = "co_websitenum", length = 255)
	public String getCoWebsitenum() {
		return coWebsitenum;
	}

	public void setCoMail(String coMail) {
		this.coMail = coMail;
	}

	@Column(name = "co_mail", length = 255)
	public String getCoMail() {
		return coMail;
	}

	public void setCoPreset(String coPreset) {
		this.coPreset = coPreset;
	}

	@Column(name = "co_preset", length = 255)
	public String getCoPreset() {
		return coPreset;
	}

	public String toString() {
		return "EcCompany [coId=" + coId + ",coName=" + coName + ",coAddress="
				+ coAddress + ",coPostcode=" + coPostcode + ",coFax=" + coFax
				+ ",coContact=" + coContact + ",coMobile=" + coMobile
				+ ",coCooperate=" + coCooperate + ",coWebsitenum="
				+ coWebsitenum + ",coMail=" + coMail + ",coPreset=" + coPreset
				+ "]";
	}

}
