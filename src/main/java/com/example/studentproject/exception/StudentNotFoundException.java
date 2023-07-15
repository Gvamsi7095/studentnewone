package com.example.studentproject.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class StudentNotFoundException extends RuntimeException {




    private String resourceName;
    private String    fieldName;
    private long fieldValue;


    public  StudentNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%S is not found with %s:'%S'",resourceName,fieldName,fieldValue));

        this.resourceName = resourceName;
        this.fieldName = fieldName;//act like setter
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue()
    {
        return fieldValue;
    }
}

