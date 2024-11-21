package br.com.vinisantosdev.app_soccer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorIndicator {

    RESOURCE_NOT_FOUND("Resource Not Found", "ERROR_INDICATOR_001", HttpStatus.NOT_FOUND),
    NOT_FOUND_TEAM("Team Not Found", "ERROR_INDICATOR_002", HttpStatus.NOT_FOUND),
    NOT_FOUND_CHAMPIONSHIP("Championship Not Found", "ERROR_INDICATOR_003", HttpStatus.NOT_FOUND),
    BAD_REQUEST_TEAM_EXISTS("Team already exists with this name and city", "ERROR_INDICATOR_004", HttpStatus.BAD_REQUEST),
    BAD_REQUEST_CHAMPIONSHIP_EXISTS("Championship already exists with this name", "ERROR_INDICATOR_005", HttpStatus.BAD_REQUEST);

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
