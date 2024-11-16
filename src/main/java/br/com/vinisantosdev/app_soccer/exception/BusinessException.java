package br.com.vinisantosdev.app_soccer.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BusinessException extends Exception {

    private final HttpStatus statusCode;
    private final String codeMessage;
    private final String errorMessage;

    public BusinessException(ErrorIndicator customError) {
        this.statusCode = customError.getHttpStatus();
        this.codeMessage = customError.getCodeMessage();
        this.errorMessage = customError.getErrorMessage();
    }
}