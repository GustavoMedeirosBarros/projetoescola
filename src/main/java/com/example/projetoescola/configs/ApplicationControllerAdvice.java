package com.example.projetoescola.configs;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.projetoescola.dtos.ApiErrorDTO;
import com.example.projetoescola.dtos.RegrasNegocioException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegrasNegocioException.class)
    public ApiErrorDTO handleRegraNegocioException(RegrasNegocioException ex) {
        String msg = ex.getMessage();
        return new ApiErrorDTO(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiErrorDTO validationError(MethodArgumentNotValidException ex) {
        List<String> erros = ex.getBindingResult().getFieldErrors().stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(
                        Collectors.toList());
        return new ApiErrorDTO(erros);
    }
}
