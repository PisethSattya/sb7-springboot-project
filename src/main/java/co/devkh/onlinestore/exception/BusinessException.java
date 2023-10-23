package co.devkh.onlinestore.exception;

import co.devkh.onlinestore.base.BaseError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class BusinessException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleBusinessEx(ResponseStatusException responseStatusException){

        var baseError = BaseError.builder()
                .message("Something went wrong!")
                .code(7001)
                .status(false)
                .timestamp(LocalDateTime.now())
                .errors(responseStatusException.getReason())
                .build();

        return new ResponseEntity<>(baseError,
                responseStatusException.getStatusCode());
    }
}
