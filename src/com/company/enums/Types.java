package com.company.enums;

import com.company.Constants;

public enum Types {
    MINIVAN,
    SUV,
    COUPE,
    CABRIOLET;

    public static final String DEFAULT_TYPE = "Coupe";

    public static String get(String s){
        try{
            return Types.valueOf(s).toString();
        }
        catch (Exception e){
            return DEFAULT_TYPE;
        }
    }
}
