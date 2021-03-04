package com.training.micro.rest.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {


    @Autowired
    private MsConfig mc;

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final IllegalArgumentException exp) {
        ErrorObject errorObjectLoc2 = new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                       .setBoundedContext(this.mc.getBoundedContext())
                                                       .setMicroservice(this.mc.getMicroService())
                                                       .setDesc(exp.getMessage())
                                                       .setCause(1000);
        return errorObjectLoc2;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final MethodArgumentNotValidException exp) {
        ErrorObject errorObjectLoc = new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                      .setBoundedContext(this.mc.getBoundedContext())
                                                      .setMicroservice(this.mc.getMicroService())
                                                      .setDesc("Validation Error")
                                                      .setCause(1000);
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            errorObjectLoc.addSubErrorObject(new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                              .setBoundedContext(this.mc.getBoundedContext())
                                                              .setMicroservice(this.mc.getMicroService())
                                                              .setDesc(objectErrorLoc.toString())
                                                              .setCause(2000));
        }
        return errorObjectLoc;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObject handleError(final ConstraintViolationException exp) {
        ErrorObject errorObjectLoc = new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                      .setBoundedContext(this.mc.getBoundedContext())
                                                      .setMicroservice(this.mc.getMicroService())
                                                      .setDesc("Validation Error")
                                                      .setCause(1000);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exp.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            errorObjectLoc.addSubErrorObject(new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                              .setBoundedContext(this.mc.getBoundedContext())
                                                              .setMicroservice(this.mc.getMicroService())
                                                              .setDesc(constraintViolationLoc.toString())
                                                              .setCause(2000));
        }
        return errorObjectLoc;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleError(final Exception exp) {
        if (exp instanceof NullPointerException) {
            ErrorObject errorObjectLoc2 = new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                           .setBoundedContext(this.mc.getBoundedContext())
                                                           .setMicroservice(this.mc.getMicroService())
                                                           .setDesc(exp.getMessage())
                                                           .setCause(3000);
            return ResponseEntity.status(HttpStatus.CONFLICT)
                                 .body(errorObjectLoc2);

        }
        ErrorObject errorObjectLoc2 = new ErrorObject().setSubDomain(this.mc.getSubDomain())
                                                       .setBoundedContext(this.mc.getBoundedContext())
                                                       .setMicroservice(this.mc.getMicroService())
                                                       .setDesc(exp.getMessage())
                                                       .setCause(5000);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(errorObjectLoc2);
    }

}
