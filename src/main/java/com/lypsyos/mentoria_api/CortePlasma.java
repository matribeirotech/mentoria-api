package com.lypsyos.mentoria_api;
import org.springframework.stereotype.Component;
@Component
public class CortePlasma implements MaquinaCorte {
	@Override
	  public void cortar(String material){
	    System.out.println("Cortando " + material + " no processo de Plasma");
	  }
	  
	}

