package com.example.carapp.api.resource;

import static com.example.carapp.api.resource.Status.ERROR;

public class Resource<T> {
    private T data;
    private String message;

    public Resource(T data, String message, Status status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status;

    public static <T> Resource<T> success(T data   ) {
        return new Resource(data,"", Status.SUCCESS);
    }
    public static <T> Resource<T> loading() {
        return new Resource(null,"",  Status.LOADING);
    }
    public static <T> Resource<T> error(String message ) {
        return new Resource(null,message, ERROR);
    }
}

