package com.nexusy.libra.model;

/**
 * @author lanhuidong
 * @since 2019-07-24
 */
public class RequestParams {

    private String requestId;
    private long clientTime;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public long getClientTime() {
        return clientTime;
    }

    public void setClientTime(long clientTime) {
        this.clientTime = clientTime;
    }
}
