package com.net.env;

import com.net.gson.JsonConverter;

public class EnvErrorException extends Exception {

    public final EnvError error;

    public EnvErrorException(EnvError error) {
        this.error = error;
    }

    public String toString() {
        return JsonConverter.toJson(this);
    }

}