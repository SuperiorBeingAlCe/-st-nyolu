package com.example.futergoal.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	NO_RECORD_EXIST("1001","kullanıcı bulunamadı"),
	NO_ROLE_EXIST("1002","rol bulunamadı"),
	NO_CITY_EXIST("1003","Şehir bulunamadı"),
	NO_TITLE_EXIST("1004","Ünvan bulunamadı"),
	GENERAL_EXCEPTION("9999", "genel bir hata oluştu");
	
	private String code;
	private String message;
	
	
	MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
}
