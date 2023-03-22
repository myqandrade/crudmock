package br.com.mike.myqandrade.restwithspringbootandjava;

import br.com.mike.myqandrade.restwithspringbootandjava.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private static String template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
        }
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return convertToDouble(numberOne) - convertToDouble(numberTwo);
        }
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }
    }

    @RequestMapping(value = "/ave/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double average(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        } else {
            return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        }
    }

    @RequestMapping(value = "/sqrt/{numberOne}")
    public Double squareRoot(@PathVariable(value = "numberOne") String numberOne){
        if(!isNumeric(numberOne)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        } else {
            return Math.sqrt(convertToDouble(numberOne));
        }
    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null){
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)){
            return Double.parseDouble(number);
        }
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
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
