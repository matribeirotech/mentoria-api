package com.lypsyos.mentoria_api;
import org.springFramework.stereotype.Service;
@Service
maquinaCorte maquina;

  public ServicoProducao(MaquinaCorte maquina){
    this.maquina = maquina;
  }
  public void iniciarOrdem(String material){
    System.out.println("Processando ordem no sistema");
      this.maquina.cortar(material);
    
  }
}