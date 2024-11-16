package br.com.vinisantosdev.app_soccer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorIndicator {

    ERROR_INDICATOR_001("Resource Not Found", "ERROR_INDICATOR_001", HttpStatus.NOT_FOUND);
    private final String codeMessage;
    private final String errorMessage;
    private final HttpStatus httpStatus;
    ErrorIndicator(String errorMessage, String codeMessage, HttpStatus httpStatus) {
        this.codeMessage = codeMessage;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public CustomError callException(){
        return new CustomError(this.getHttpStatus(), this.getCodeMessage(), this.getErrorMessage());
    }

}
