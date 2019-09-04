package com.chat.simbir.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static <T> List<String> toArrayListString(List<T> list){
        List<String> listString = new ArrayList<>();
        list.forEach(value -> listString.add(value.toString()));
        return listString;
    }
}
