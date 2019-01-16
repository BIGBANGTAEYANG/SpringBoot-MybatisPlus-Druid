package com.ybb.framework.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public abstract class TypeUtils {

    public static String castToString(Object value) {
        if (value == null) {
            return null;
        }
        return value.toString();
    }

    public static String castToString(Object value, String defaults) {
        String castString = castToString(value);
        return Objects.isNull(castString) ? defaults : castString;
    }

    public static Byte castToByte(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).byteValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            return Byte.parseByte(strVal);
        }

        throw new Exception("can not cast to byte, value : " + value);
    }

    public static Byte castToByte(Object value, Byte defaults) {
        Byte castToByte = null;
        try {
            castToByte = castToByte(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToByte) ? defaults : castToByte;
    }

    public static Character castToChar(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Character) {
            return (Character) value;
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0) {
                return null;
            }

            if (strVal.length() != 1) {
                throw new Exception("can not cast to char, value : " + value);
            }

            return strVal.charAt(0);
        }

        throw new Exception("can not cast to char, value : " + value);
    }

    public static Character castToChar(Object value, Character defaults) {
        Character castToChar = null;
        try {
            castToChar = castToChar(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToChar) ? defaults : castToChar;
    }

    public static Short castToShort(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).shortValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            return Short.parseShort(strVal);
        }

        throw new Exception("can not cast to short, value : " + value);
    }

    public static Short castToShort(Object value, Short defaults) {
        Short castToShort = null;
        try {
            castToShort = castToShort(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToShort) ? defaults : castToShort;
    }



    public static BigInteger castToBigInteger(Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof BigInteger) {
            return (BigInteger) value;
        }

        if (value instanceof Float || value instanceof Double) {
            return BigInteger.valueOf(((Number) value).longValue());
        }

        String strVal = value.toString();
        if (strVal.length() == 0
                || "null".equals(strVal)
                || "NULL".equals(strVal)) {
            return null;
        }

        return new BigInteger(strVal);
    }

    public static BigInteger castToBigInteger(Object value, BigInteger defaults) {

        BigInteger bigInteger = castToBigInteger(value);
        return Objects.isNull(bigInteger) ? defaults : bigInteger;

    }

    public static Float castToFloat(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).floatValue();
        }

        if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            return Float.parseFloat(strVal);
        }

        throw new Exception("can not cast to float, value : " + value);
    }

    public static Float castToFloat(Object value, Float defaults) {
        Float castToFloat = null;
        try {
            castToFloat = castToFloat(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToFloat) ? defaults : castToFloat;

    }

    public static Double castToDouble(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }

        if (value instanceof String) {
            String strVal = value.toString();
            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            return Double.parseDouble(strVal);
        }

        throw new Exception("can not cast to double, value : " + value);
    }

    public static Double castToDouble(Object value, Double defaults) {
        Double castToDouble = null;
        try {
            castToDouble = castToDouble(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToDouble) ? defaults : castToDouble;

    }


    @SuppressWarnings("Duplicates")
    public static java.sql.Timestamp castToTimestamp(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Calendar) {
            return new java.sql.Timestamp(((Calendar) value).getTimeInMillis());
        }

        if (value instanceof java.sql.Timestamp) {
            return (java.sql.Timestamp) value;
        }

        if (value instanceof Date) {
            return new java.sql.Timestamp(((Date) value).getTime());
        }

        long longValue = 0;

        if (value instanceof Number) {
            longValue = ((Number) value).longValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            longValue = Long.parseLong(strVal);
        }

        if (longValue <= 0) {
            throw new Exception("can not cast to Date, value : " + value);
        }

        return new java.sql.Timestamp(longValue);
    }

    public static java.sql.Timestamp castToTimestamp(Object value, java.sql.Timestamp defaults) {
        java.sql.Timestamp castToTimestamp = null;
        try {
            castToTimestamp = castToTimestamp(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToTimestamp) ? defaults : castToTimestamp;

    }

    public static Long castToLong(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Number) {
            return ((Number) value).longValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;
            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            try {
                return Long.parseLong(strVal);
            } catch (NumberFormatException ex) {
                //
            }

        }

        throw new Exception("can not cast to long, value : " + value);
    }

    public static Long castToLong(Object value, Long defaults) {
        Long castToLong = null;
        try {
            castToLong = castToLong(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToLong) ? defaults : castToLong;

    }

    public static Integer castToInt(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Integer) {
            return (Integer) value;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue();
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            if (strVal.indexOf(',') != 0) {
                strVal = strVal.replaceAll(",", "");
            }

            return Integer.parseInt(strVal);
        }

        if (value instanceof Boolean) {
            return (Boolean) value ? 1 : 0;
        }

        throw new Exception("can not cast to int, value : " + value);
    }

    public static Integer castToInt(Object value, Integer defaults) {
        Integer castToInt = null;
        try {
            castToInt = castToInt(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToInt) ? defaults : castToInt;

    }

    public static Boolean castToBoolean(Object value) throws Exception {
        if (value == null) {
            return null;
        }

        if (value instanceof Boolean) {
            return (Boolean) value;
        }

        if (value instanceof Number) {
            return ((Number) value).intValue() == 1;
        }

        if (value instanceof String) {
            String strVal = (String) value;

            if (strVal.length() == 0
                    || "null".equals(strVal)
                    || "NULL".equals(strVal)) {
                return null;
            }

            if ("true".equalsIgnoreCase(strVal)
                    || "1".equals(strVal)) {
                return Boolean.TRUE;
            }

            if ("false".equalsIgnoreCase(strVal)
                    || "0".equals(strVal)) {
                return Boolean.FALSE;
            }
        }

        throw new Exception("can not cast to boolean, value : " + value);
    }

    public static Boolean castToBoolean(Object value, Boolean defaults) {
        Boolean castToBoolean = null;
        try {
            castToBoolean = castToBoolean(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Objects.isNull(castToBoolean) ? defaults : castToBoolean;

    }


}
