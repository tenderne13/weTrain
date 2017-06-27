package com.we.entity.train;

public class Data {
	public QueryLeftNewDTO queryLeftNewDTO;
	public String secretStr;
	public String buttonTextInfo;
	public QueryLeftNewDTO getQueryLeftNewDTO() {
		return queryLeftNewDTO;
	}
	public void setQueryLeftNewDTO(QueryLeftNewDTO queryLeftNewDTO) {
		this.queryLeftNewDTO = queryLeftNewDTO;
	}
	public String getSecretStr() {
		return secretStr;
	}
	public void setSecretStr(String secretStr) {
		this.secretStr = secretStr;
	}
	public String getButtonTextInfo() {
		return buttonTextInfo;
	}
	public void setButtonTextInfo(String buttonTextInfo) {
		this.buttonTextInfo = buttonTextInfo;
	}
	@Override
	public String toString() {
		return "Data [queryLeftNewDTO=" + queryLeftNewDTO + ", secretStr="
				+ secretStr + ", buttonTextInfo=" + buttonTextInfo + "]";
	}
	
	
}
