package com.example.aopdemo.exception;

import android.util.Log;

public class AnnotationException extends Exception {
    public AnnotationException(String message) {
        super(message);
        Log.e("AnnotationException", message);
    }
}
