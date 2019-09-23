package com.eclt.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * ec_user:
 */
@Entity
@Table(name = "ec_user")
public class EcUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * user_id:
	 */
	private int userId;

	/**
	 * username:
	 */
	private String username;

	/**
	 * password:
	 */
	private String password;

	/**
	 * create_time:
	 */
	private Date createTime;

	/**
	 * update_time:
	 */
	private Date updateTime;

	/**
	 * u_preset:
	 */
	private String uPreset;

	public EcUser() {
		super();
	}

	public EcUser(int userId, String username, String password,
			Date createTime, Date updateTime, String uPreset) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.uPreset = uPreset;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "username", length = 20, nullable = false)
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password", length = 20, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUPreset(String uPreset) {
		this.uPreset = uPreset;
	}

	@Column(name = "u_preset", length = 20)
	public String getUPreset() {
		return uPreset;
	}

	public String toString() {
		return "EcUser [userId=" + userId + ",username=" + username
				+ ",password=" + password + ",createTime=" + createTime
				+ ",updateTime=" + updateTime + ",uPreset=" + uPreset + "]";
	}

}
