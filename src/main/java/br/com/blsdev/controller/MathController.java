package br.com.blsdev.controller;

import br.com.blsdev.exception.UnsupportedMathOperationException;
import br.com.blsdev.math.SimpleMath;
import br.com.blsdev.request.converters.NumberConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)){
            throw new UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

    }

    @RequestMapping(value = "sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)){
            throw new  UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)){
            throw new  UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)){
            throw new  UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "raiz/{numberOne}", method = RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne){
        if (!NumberConverter.isNumber(numberOne)){
            throw new  UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        return math.squareRoot(NumberConverter.convertToDouble(numberOne));
    }

    @RequestMapping(value = "media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!NumberConverter.isNumber(numberOne) || !NumberConverter.isNumber(numberTwo)){
            throw new  UnsupportedMathOperationException("Por favor forneça um valor numérico!");
        }
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }
}
