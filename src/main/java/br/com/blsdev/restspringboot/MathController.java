package br.com.blsdev.restspringboot;

import br.com.blsdev.restspringboot.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumber(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumber(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    @RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!isNumber(numberOne) || !isNumber(numberTwo)){
            throw new  UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return  sub;
    }
}
