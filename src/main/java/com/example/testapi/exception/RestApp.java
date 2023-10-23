package com.example.testapi.exception;

import com.example.testapi.pojos.ErrorValidation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class RestApp extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    //créer une liste d'erreurs

        List<ErrorValidation> errors =new ArrayList<>();

    //récupére les erreurs

        BindingResult result=ex.getBindingResult();
    // récupere la list des erreurs généres par la validation

        List<FieldError> fieldErrors=result.getFieldErrors();

    // parcour la liste fiedlErrors pour construire notre propre list avec des erreurs

        for(FieldError error : fieldErrors){
            errors.add(new ErrorValidation(error.getField(),error.getDefaultMessage()));
        }
        //termine avec la methode handlExcepetionInternal qui retourne un objet ResponseEntity

        return this.handleExceptionInternal(ex,errors, headers, status, request);
    }
}
