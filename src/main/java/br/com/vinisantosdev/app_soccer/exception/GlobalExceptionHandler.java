package br.com.vinisantosdev.app_soccer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomError> handleEmailException(BusinessException ex) {
        CustomError customError = new CustomError(
                ex.getStatusCode(),
                ex.getCodeMessage(),
                ex.getErrorMessage()
        );
        return new ResponseEntity<>(customError, HttpStatus.valueOf(ex.getStatusCode().value()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> handleEmailException(EntityNotFoundException ex) {
        CustomError customError = new CustomError(
                ex.getStatusCode(),
                ex.getCodeMessage(),
                ex.getErrorMessage()
        );
        return new ResponseEntity<>(customError, HttpStatus.valueOf(ex.getStatusCode().value()));
    }
}