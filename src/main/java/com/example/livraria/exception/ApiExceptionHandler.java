package com.example.livraria.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(LivroNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(LivroNotFoundException ex, HttpServletRequest req) {
        var body = new ErrorResponse(Instant.now(), 404, "Not Found", ex.getMessage(), req.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toMap(
                        e -> ((FieldError) e).getField(),
                        e -> e.getDefaultMessage(),
                        (a, b) -> a
                ));
        return ResponseEntity.badRequest().body(errors);
    }
}
