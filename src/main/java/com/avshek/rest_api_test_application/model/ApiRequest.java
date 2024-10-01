package com.avshek.rest_api_test_application.model;

import jakarta.persistence.*;

@Entity
public class ApiRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String method;
    @Column(columnDefinition = "TEXT")
    private String headers;
    @Column(columnDefinition = "TEXT")
    private String body;

    public ApiRequest(){

    }

    public ApiRequest(String url, String method, String headers, String body){
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = body;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}