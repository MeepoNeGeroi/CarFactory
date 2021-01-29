package com.company.enums;

import com.company.Constants;

public enum Colors {
    YELLOW,
    BLUE,
    RED,
    GREEN,
    WHITE;

    public static final String DEFAULT_COLOR = "White";

    public static String get(String s){
        try{
            return Colors.valueOf(s).toString();
        }
        catch (Exception e){
            return DEFAULT_COLOR;
        }
    }
}