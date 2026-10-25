package com.lypsyos.mentoria_api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class TratadorDeErrosGlobais {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErroCampo>> tratarErroValidacao(MethodArgumentNotValidException ex){
	List<ErroCampo> errosLimpos = ex.getFieldErrors().stream()
			.map(erro -> new ErroCampo(erro.getField(), erro.getDefaultMessage()))
			.toList();
	
	return ResponseEntity.badRequest().body(errosLimpos);
	}
}
