package br.com.mike.myqandrade.restwithspringbootandjava.services;

import br.com.mike.myqandrade.restwithspringbootandjava.math.SimpleMath;
import br.com.mike.myqandrade.restwithspringbootandjava.utility.MathUtility;
import br.com.mike.myqandrade.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MathService {

    private final SimpleMath simpleMath;

    public Double sum(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            Double convertedNumberOne = MathUtility.convertToDouble(numberOne);
            Double convertedNumberTwo = MathUtility.convertToDouble(numberTwo);
            return simpleMath.sum(convertedNumberOne, convertedNumberTwo);
        }
    }

    public Double subtraction(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            Double convertedNumberOne = MathUtility.convertToDouble(numberOne);
            Double convertedNumberTwo = MathUtility.convertToDouble(numberTwo);
            return simpleMath.subtraction(convertedNumberOne, convertedNumberTwo);
        }
    }

    public Double division(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            Double convertedNumberOne = MathUtility.convertToDouble(numberOne);
            Double convertedNumberTwo = MathUtility.convertToDouble(numberTwo);
            return simpleMath.division(convertedNumberOne, convertedNumberTwo);
        }
    }

    public Double multiplication(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            Double convertedNumberOne = MathUtility.convertToDouble(numberOne);
            Double convertedNumberTwo = MathUtility.convertToDouble(numberTwo);
            return simpleMath.multiplication(convertedNumberOne, convertedNumberTwo);
        }
    }

    public Double average(String numberOne, String numberTwo){
        if(!MathUtility.isNumeric(numberOne) || !MathUtility.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            Double convertedNumberOne = MathUtility.convertToDouble(numberOne);
            Double convertedNumberTwo = MathUtility.convertToDouble(numberTwo);
            return simpleMath.average(convertedNumberOne, convertedNumberTwo);
        }
    }

    public Double squareRoot(String number){
        if(!MathUtility.isNumeric(number)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        } else {
            Double convertedNumber = MathUtility.convertToDouble(number);
            return simpleMath.squareRoot(convertedNumber);
        }
    }


}
