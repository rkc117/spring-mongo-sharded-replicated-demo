package tech.csguide.springmongoshardedreplicateddemo.payloads;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

public class ResponsePayload<T> {

    private T data;
    private Integer status;
    private String message;
    private Object info;
    private Object error;

    private Long timestamp;

    public ResponsePayload(T data) {
        this.data = data;
        this.timestamp=new Date().getTime();
    }

    public ResponsePayload(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp=new Date().getTime();
    }

    public ResponsePayload(T data, String message, HttpStatusCode httpStatusCode) {
        this.data=data;
        this.status = httpStatusCode.value();
        this.message = message;
        this.timestamp=new Date().getTime();
    }

    public ResponsePayload(T data, HttpStatus httpStatus) {
        this.data = data;
        this.status = httpStatus.value();
        this.timestamp=new Date().getTime();
    }

    public ResponsePayload(T data, Integer status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.timestamp=new Date().getTime();
    }

    public ResponsePayload(T data, Integer status, String message, Object info) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.info = info;
        this.timestamp=new Date().getTime();
    }

    public ResponsePayload(T data, Integer status, String message, Object info, Object error) {
        this.data = data;
        this.status = status;
        this.message = message;
        this.info = info;
        this.error = error;
        this.timestamp=new Date().getTime();
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}