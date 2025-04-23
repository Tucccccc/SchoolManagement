package com.example.diemdanh.global.common;

public class HttpStatusText {
    public static String fromCode(int code) {
        switch (code) {
            case 400: return "Bad Request";
            case 401: return "Unauthorized";
            case 403: return "Forbidden";
            case 404: return "Not Found";
            case 500: return "Internal Server Error";
            default: return "Error";
        }
    }
}