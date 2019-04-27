package com.dazhaung.family.base.utils;

import java.util.ResourceBundle;

public class PropertiesUtils {


    public static String getStr(String key) {
        try {
            ResourceBundle resource = ResourceBundle.getBundle("application");
            return resource.getString(key);
        } catch (Exception e) {
            return null;
        }
    }
}
