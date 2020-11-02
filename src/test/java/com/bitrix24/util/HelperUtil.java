package com.bitrix24.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class HelperUtil {

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String getStartDate(){
        return LocalDate.now().plusDays(1).format(format);
    }

    public static String getEndDate(int days) {
        return LocalDate.parse(getStartDate(),format).plusDays(days).format(format);
    }

    public static int[] date_format(String string) {
        return Arrays.stream(string.split("-")).mapToInt(Integer::parseInt).toArray();
    }

    public static int get_int_value(String format, String type){
        if (type.equalsIgnoreCase("month")) return date_format(format)[0];
        else if (type.equalsIgnoreCase("date")) return date_format(format)[1];
        else if (type.equalsIgnoreCase("year")) return date_format(format)[2];
        else throw new RuntimeException("invalid date_type, please enter date/month/year");
    }

    public static String [] time_format(String string){
        return string.split("-");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(date_format("10-11-2020")));
    }
}
