package com.example.news.Common;

import java.util.Date;
import java.util.TimeZone;
import java.text.SimpleDateFormat;



public class ISO8601Parse {
    
    public static Date parse(String ip) throws java.text.ParseException {

        
        SimpleDateFormat datefrmat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

        
        if (ip.endsWith("Z")) {
            input = ip.substring(0, ip.length() - 1) + "GMT-00:00";
        } else {
            int inset = 6;

            String str1 = ip.substring(0, ip.length() - inset);
            String str2 = ip.substring(ip.length() - inset, ip.length());

            dataip = str1 + "GMT" + str2;
        }

        return datefrmat.parse(dataip);

    }

    public static String toString(Date date) {

        SimpleDateFormat datefrmat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz");

        TimeZone timez = TimeZone.getTimeZone("UTC");

        datefrmat.setTimeZone(timez);

        String output = datefrmat.format(date);

        int inset0 = 9;
        int inset1 = 6;

        String str1 = output.substring(0, output.length() - inset0);
        String str2 = output.substring(output.length() - inset1, output.length());

        String outpt = str1 + str2;

        outpt = outpt.replaceAll("UTC", "+00:00");

        return outpt;

    }

}
