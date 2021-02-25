package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String operator(int number1, int number2, String cal) {
       int res = 0 ;
       String message = null ;
       switch (cal){
           case "+":
               res = number1 + number2 ;
               break;
           case "-":
               res = number1 - number2 ;
               break;
           case "*":
               res = number1 * number2 ;
               break;
           case "/":
               if (number2 == 0){
                   message = "Can't not division by zero";
                   return message;
               }else {
                   res = number1 / number2;
               }
               break;
       }
       return String.valueOf(res) ;
    }
}


