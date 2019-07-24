package com.nexusy.libra.model;

/**
 * @author lanhuidong
 * @since 2019-07-24
 */
public class ResponseData {

    private String requestId;
    private long clientTime;
    private long serverTime;

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

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }
}
