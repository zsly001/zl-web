package com.zl.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ServletInfoVO implements Serializable {

    private String request;
    private String session;
    private int requestAttrCount;
    private int sessionAttrCount;
    private Map<String,String> reqAttr = new LinkedHashMap<>();
    private Map<String,String> sesAttr = new LinkedHashMap<>();


    public void addReqAttr(String key,String val){
        reqAttr.put(key,val);
    }

    public void addSesAttr(String key,String val){
        sesAttr.put(key,val);
    }

    @Override
    public String toString() {
        return "ServletInfoVO{" +
                "requestAttrCount=" + requestAttrCount +
                ", sessionAttrCount=" + sessionAttrCount +
                ", reqAttr=" + reqAttr +
                ", sesAttr=" + sesAttr +
                '}';
    }

    public int getRequestAttrCount() {
        return requestAttrCount;
    }

    public void setRequestAttrCount(int requestAttrCount) {
        this.requestAttrCount = requestAttrCount;
    }

    public int getSessionAttrCount() {
        return sessionAttrCount;
    }

    public void setSessionAttrCount(int sessionAttrCount) {
        this.sessionAttrCount = sessionAttrCount;
    }

    public Map<String, String> getReqAttr() {
        return reqAttr;
    }

    public void setReqAttr(Map<String, String> reqAttr) {
        this.reqAttr = reqAttr;
    }

    public Map<String, String> getSesAttr() {
        return sesAttr;
    }

    public void setSesAttr(Map<String, String> sesAttr) {
        this.sesAttr = sesAttr;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }
}
