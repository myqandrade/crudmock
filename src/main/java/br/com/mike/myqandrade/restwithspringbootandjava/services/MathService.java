package br.com.mike.myqandrade.restwithspringbootandjava.services;

import br.com.mike.myqandrade.restwithspringbootandjava.MathUtility;
import br.com.mike.myqandrade.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public Double sum(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return MathUtility.convertToDouble(numberOne) + MathUtility.convertToDouble(numberTwo);
        }
    }

    public Double subtraction(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return MathUtility.convertToDouble(numberOne) - MathUtility.convertToDouble(numberTwo);
        }
    }

    public Double division(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return MathUtility.convertToDouble(numberOne) / MathUtility.convertToDouble(numberTwo);
        }
    }

    public Double multiplication(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return MathUtility.convertToDouble(numberOne) * MathUtility.convertToDouble(numberTwo);
        }
    }

    public Double average(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return (MathUtility.convertToDouble(numberOne) + MathUtility.convertToDouble(numberTwo)) / 2;
        }
    }

    public Double squareRoot(String number){
        if(!MathUtility.isNumeric(number)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        } else {
            return Math.sqrt(MathUtility.convertToDouble(number));
        }
    }


}
