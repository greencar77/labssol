package httpjson.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointer(NullPointerException ex) {
        System.out.println("httpjson.controller.GlobalExceptionHandler.handleNullPointer");
        return ResponseEntity.status(404)
                .body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        System.out.println("httpjson.controller.GlobalExceptionHandler.handleIllegalArgument");
        return ResponseEntity.badRequest()
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneric(Exception ex) {
        System.out.println("httpjson.controller.GlobalExceptionHandler.handleGeneric");
        return ResponseEntity.status(500)
                .body("Internal server error");
    }
}