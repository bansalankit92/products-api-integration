package com.integration.extensions.domains.devops;

public class DowntimeType {
    private final int code;
    public final String name;

    public DowntimeType(int code) {
        this.code = code;
        switch (code) {
            case 0:
                name = "All";
                break;
            case 1:
                name = "Only scoped to hosts";
                break;
            case 2:
                name = "Scoped to anything but hosts";
                break;
            default:
                name = null;
                break;
        }
    }
}
