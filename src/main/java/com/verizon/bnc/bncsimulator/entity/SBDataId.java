package com.verizon.bnc.bncsimulator.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SBDataId implements Serializable {

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "request_type", nullable = false)
    private String requestType;

    @Column(name = "request_status", nullable = false)
    private String requestStatus;

    public SBDataId() {
    }

    public SBDataId(String url, String requestType, String requestStatus) {
        this.url = url;
        this.requestType = requestType;
        this.requestStatus = requestStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBDataId sbDataId = (SBDataId) o;
        return url.equals(sbDataId.url) &&
                requestStatus.equals(sbDataId.requestStatus) && requestType.equals(sbDataId.requestType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, requestType, requestStatus);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
