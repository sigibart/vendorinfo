package com.cujo.vendorinfo.controller;

import java.sql.Timestamp;

public class ResponseInfo {
	
	public enum ResponseState {
		SUCCESS,
		INTERNAL_ERROR
	}

	public Object responseContent;
	public ResponseState status;
	public Timestamp evaluatedAt;

	protected static ResponseInfo success(Object content) {
        ResponseInfo r = new ResponseInfo();
        r.status = ResponseInfo.ResponseState.SUCCESS;
        r.responseContent = content;
        r.evaluatedAt = new Timestamp(System.currentTimeMillis());
        return r;
    }

	protected static ResponseInfo failure() {
		ResponseInfo r = new ResponseInfo();
		r.status = ResponseInfo.ResponseState.INTERNAL_ERROR;
		r.evaluatedAt = new Timestamp(System.currentTimeMillis());
		return r;
	}
	
	protected static ResponseInfo failure(String errMsg) {
		ResponseInfo r = new ResponseInfo();
		r.status = ResponseInfo.ResponseState.INTERNAL_ERROR;
		r.evaluatedAt = new Timestamp(System.currentTimeMillis());
		r.responseContent = errMsg;
		return r;
	}

}
