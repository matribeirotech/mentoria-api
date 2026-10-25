package com.lypsyos.mentoria_api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

//O Record cria automaticamente os construtores e getters nos bastidores
public record OrdemCorteRequest(@NotBlank(message = "O material nao pode ser vazio")String material,
								@Positive (message = "A espessura deve ser maior que zero") double espessuraMm) {	
}
