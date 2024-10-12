package kopo.aisw.hc.apicontroller.advice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AAdvice {

    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCustomBadRequest
    (ClassNotFoundException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("responseDTime", LocalDateTime.now());
//        response.put("responseCode", HttpStatus.NOT_FOUND.value());
        response.put("responseCode", "임시코드");
//        response.put("responseMessage", ex.getMessage());
        response.put("responseMessage", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
