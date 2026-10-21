package com.lypsyos.mentoria_api;
import org.springframework.stereotype.Component;
@Component // diz ao spring: "crie e gerencie a instancia desta maquina"
public class CorteOxicorte implements MaquinaCorte{
  @Override
  public void cortar(String material){
    System.out.println("Cortando " + material + " no processo de Oxicorte");
  }
  
}