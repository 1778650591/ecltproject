package common;

import java.util.Collection;

/**
 * 
 * @author asus
 *
 * vue请求返回封装bean
 */
public class ResultData {

	private Collection data;
	private Integer status;
	private String msg;
	public Collection getData() {
		return data;
	}
	public void setData(Collection data) {
		this.data = data;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "ResultData [data=" + data + ", status=" + status + ", msg="
				+ msg + "]";
	}
	
}
