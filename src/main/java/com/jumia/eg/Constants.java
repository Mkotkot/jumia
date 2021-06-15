package com.jumia.eg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {
    public static String ALL = "ALL";
    private static String regEx[] = {"\\(237\\)\\ ?[2368]\\d{7,8}$"
            , "\\(251\\)\\ ?[1-59]\\d{8}$"
            , "\\(212\\)\\ ?[5-9]\\d{8}$"
            , "\\(258\\)\\ ?[28]\\d{7,8}$"
            , "\\(256\\)\\ ?\\d{9}$"};
    public static List<String> regExList = new ArrayList<>(Arrays.asList(regEx));

}
