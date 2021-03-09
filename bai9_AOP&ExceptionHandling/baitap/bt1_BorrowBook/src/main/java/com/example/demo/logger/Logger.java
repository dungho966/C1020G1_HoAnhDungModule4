package com.example.demo.logger;

import com.example.demo.controller.BookController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Aspect
public class Logger {
    private static final org.slf4j.Logger
            LOGGER = LoggerFactory.getLogger(BookController.class);
    @AfterReturning("execution(* com.example.demo.controller.BookController.borrow(*,*))")
    public void afterRenting(JoinPoint joinPoint) {
        String args = Arrays.toString(joinPoint.getArgs());
        LOGGER.info("rent" + args);    }
    @AfterReturning("execution(* com.example.demo.controller.BookController.Back(*,*))")
    public void afterReturning(JoinPoint joinPoint){
        String args = Arrays.toString(joinPoint.getArgs());
        LOGGER.info("return" + args);    }
}