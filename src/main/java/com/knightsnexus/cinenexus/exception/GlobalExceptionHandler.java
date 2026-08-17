package com.knightsnexus.cinenexus.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateResourceException(DuplicateResourceException exception,
                                                                             HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.CONFLICT, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseDTO);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseDTO> handleConflictException(ConflictException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.CONFLICT, exception.getMessage(), request);
        return ResponseEntity.status(409).body(errorResponseDTO);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponseDTO> handleUnauthorized(UnauthorizedException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.UNAUTHORIZED, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponseDTO);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponseDTO> handleForbidden(ForbiddenException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = builddErrorResponse(HttpStatus.FORBIDDEN, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponseDTO);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidOperationException(InvalidOperationException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception exception, HttpServletRequest request) {
        ErrorResponseDTO errorResponseDTO = buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), request);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseDTO);
    }

    public ErrorResponseDTO buildErrorResponse(HttpStatus status, String message, HttpServletRequest request) {
        return new ErrorResponseDTO(LocalDateTime.now(), status.value(), status.getReasonPhrase(), message, request.getRequestURI());
    }
}


// GlobalExceptionHandler
// This is the command center
// Controller -> Service -> Repository
// and converts them into proper HTTP responses.