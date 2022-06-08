package com.example.travel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class Response {
    // metadata
    private LocalDateTime timeStamp;
    private int statusCode;
    private HttpStatus status;
    private String reason;
    private String message;
    private String developerMessage;
    // data
    private Map<?, ?> data;

    Response(LocalDateTime timeStamp, int statusCode, HttpStatus status, String reason, String message, String developerMessage, Map<?, ?> data) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.status = status;
        this.reason = reason;
        this.message = message;
        this.developerMessage = developerMessage;
        this.data = data;
    }



    public static ResponseBuilder builder() {
        return new ResponseBuilder();
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getReason() {
        return this.reason;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDeveloperMessage() {
        return this.developerMessage;
    }

    public Map<?, ?> getData() {
        return this.data;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public void setData(Map<?, ?> data) {
        this.data = data;
    }

    public static class ResponseBuilder{
        private LocalDateTime timeStamp;
        private int statusCode;
        private HttpStatus status;
        private String reason;
        private String message;
        private String developerMessage;
        private Map<?, ?> data;

        ResponseBuilder() {
        }

        public ResponseBuilder timeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public ResponseBuilder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ResponseBuilder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public ResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResponseBuilder data(Map<?, ?> data) {
            this.data = data;
            return this;
        }

        public Response build() {
            return new Response(timeStamp, statusCode, status, reason, message, developerMessage, data);
        }

        public String toString() {
            return "Response.ResponseBuilder(timeStamp=" + this.timeStamp + ", statusCode=" + this.statusCode + ", status=" + this.status + ", reason=" + this.reason + ", message=" + this.message + ", developerMessage=" + this.developerMessage + ", data=" + this.data + ")";
        }
    }
}