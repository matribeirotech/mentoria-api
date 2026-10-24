package com.lypsyos.mentoria_api;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServicoProducao {
    
    // 1. Declaração do atributo (usamos 'final' para garantir a imutabilidade)
    private final MaquinaCorte maquina;

    // 2. Método Construtor (é aqui que o Spring vai injetar a dependência)
    
    // Adicionamos o @Qualifier junto ao parâmetro para ser explícito
    public ServicoProducao(@Qualifier("cortePlasma")MaquinaCorte maquina) {
        this.maquina = maquina;
    }

    public void iniciarOrdem(String material) {
        System.out.println("Processando ordem no sistema...");
        this.maquina.cortar(material);
    }
}