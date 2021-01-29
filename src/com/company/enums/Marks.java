package com.company.enums;

import com.company.Constants;

public enum Marks {
    Mercedes,
    Porsh,
    Renault,
    Ferrari;

    public static final String DEFAULT_MARK = "Mercedes";

    public static String get(String s){
        try{
            return Marks.valueOf(s).toString();
        }
        catch (Exception e){
            return DEFAULT_MARK;
        }
    }
}
