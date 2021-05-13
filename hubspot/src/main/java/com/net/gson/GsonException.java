package com.net.gson;

public class GsonException extends RuntimeException {

    public GsonException(String msg) {
        super(msg);
    }

    public GsonException(Exception e) {
        super(e);
    }

}