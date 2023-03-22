package br.com.mike.myqandrade.restwithspringbootandjava;

public class MathUtility {

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null){
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    public static boolean isNumeric(String strNumber) {
        if(strNumber == null){
            return false;
        }
        String number = strNumber.replaceAll(",", ".");
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}
