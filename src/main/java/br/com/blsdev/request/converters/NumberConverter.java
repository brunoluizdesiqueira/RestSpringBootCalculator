package br.com.blsdev.request.converters;

public class NumberConverter {
    public static Double convertToDouble(String strNumber){
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumber(number)) return Double.parseDouble(number);
        return 0d;
    }

    public static boolean isNumber(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
