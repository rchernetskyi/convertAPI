package com.example.convertAPI.model.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExceptionResponse {
    private final String message;
    private final HttpStatus httpStatus;
    private final String time;

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public ExceptionResponse(String message, HttpStatus httpStatus, LocalDateTime now) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = dtf.format(now);
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "{" +
                "\n\t\"message\": \"" + message + "\"," +
                "\n\t\"httpStatus\": \"" + httpStatus +
                "\",\n\t\"time\": \"" + time + "\"\n" +
                '}';
    }
}
