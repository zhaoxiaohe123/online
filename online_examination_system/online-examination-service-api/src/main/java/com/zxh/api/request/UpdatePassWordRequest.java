package com.zxh.api.request;

public class UpdatePassWordRequest {

	String id;

	String oldPass;

	String newPass;

	public String getId() {
		return id;
	}

	public UpdatePassWordRequest setId(String id) {
		this.id = id;
		return this;
	}

	public String getOldPass() {
		return oldPass;
	}

	public UpdatePassWordRequest setOldPass(String oldPass) {
		this.oldPass = oldPass;
		return this;
	}

	public String getNewPass() {
		return newPass;
	}

	public UpdatePassWordRequest setNewPass(String newPass) {
		this.newPass = newPass;
		return this;
	}

}
