package com.myblog1.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private String message;

    public ErrorDetails(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    private String details;
}
