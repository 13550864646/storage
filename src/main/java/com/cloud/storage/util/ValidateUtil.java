package com.cloud.storage.util;

import java.util.regex.Pattern;

public class ValidateUtil {

    /**
     * @param string
     * @return
     */
    public static Boolean isValid(String string) {
        if (string == null || !"".equals(string.trim()))
            return false;
        else
            return true;
    }

    /**
     * @param pageno
     * @param total
     * @return
     */
    @SuppressWarnings("finally")
    public static int isLegalPagenoUtil(int pageno, int total) {
        try {
            if (pageno < 1)
                pageno = 1;
            else if (pageno > total)
                pageno = total;
        } catch (Exception e) {
            pageno = 1;
        } finally {
            return pageno;
        }
    }

    /**
     * false,
     *
     * @param param
     * @return
     */
    public static Boolean paramCheck(Object... param) {
        for (Object o : param) {
            if (o instanceof String) {
                if (!ValidateUtil.isValid((String) o)) {
                    return false;
                } else {
                    if (o == null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * @param dateTime
     * @return
     */
    public static String checkDateTime(String dateTime) {
        String returnstr = "";
        int length = dateTime == null ? 0 : dateTime.length();
        if (length == 14 && isPositiveInteger(dateTime)) {
            returnstr = "";
        } else if (length == 10 && dateTime.indexOf('-') != -1) {
            returnstr = "";
        } else if (length == 8 && dateTime.indexOf(':') != -1) {
            returnstr = "";
        } else if (length == 19 && dateTime.indexOf(':') != -1) {
            returnstr = "";
        } else {
            returnstr = "无效的时间！";
        }
        return returnstr;
    }

    /**
     * validate the idcard
     *
     * @param idcard
     * @return
     */
    public static String checkIdCard(String idcard) {
        String isidcard = "";
        if (idcard == null || (idcard.length() != 15 && idcard.length() != 18)) {
            isidcard = " 无效的身份证号！ ";
        }
        return isidcard;
    }

    /**
     * @param number
     * @param filedname
     * @return
     */
    public static String checkNumber(String number, String filedname) {
        return isNonNegativeInteger(number) ? "" : filedname + " 字段值无效！ ";
    }

    /**
     * @param number
     * @param filedname
     * @return
     */
    public static String checkNumber(int number, String filedname) {
        return number >= 0 ? " " : filedname + " 字段值无效！";
    }

    /**
     * @param number
     * @param filedname
     * @return
     */
    public static String checkDecimal(String number, String filedname) {
        return isPositiveDouble(number) ? "" : filedname + " 字段值无效！";
    }

    /**
     * @param ape
     * @return
     */
    public static String checkAppType(String ape) {
        boolean app_boolean = false;
        String apptype = PropertiesReader.getProp("apptype");
        if (apptype.indexOf(ape) != -1)
            app_boolean = true;
        return app_boolean == true ? "" : " 系统类型无效！";
    }

    /**
     * validate the posit 工ve double/float number
     *
     * @param number
     * @return
     */
    public static boolean isPositiveDouble(String number) {
        boolean isNumber = false;
        isNumber = number.matches(" ^(0|([1-9]+[0-9]*))(\\.[0-9]+)?$ ");
        return isNumber;
    }

    /**
     * validate the positive int number
     *
     * @param number
     * @return
     */
    public static boolean isPositiveInteger(String number) {
        boolean isNumber = false;
        isNumber = number.matches("^([1-9]+[0-9]*)$");
        return isNumber;
    }

    /**
     * validate the NonNegative int number
     *
     * @param number
     * @return
     */
    public static boolean isNonNegativeInteger(String number) {
        boolean isNumber = false;
        isNumber = number.matches("^0|([1-9]+[0-9]*)$");
        return isNumber;
    }
}
