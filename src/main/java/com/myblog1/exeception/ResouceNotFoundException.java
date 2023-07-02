package com.myblog1.exeception;

public class ResouceNotFoundException extends RuntimeException{
    private String resourceName;

    public ResouceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s:'%s'",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    private String fieldName;
    private long fieldValue;

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
