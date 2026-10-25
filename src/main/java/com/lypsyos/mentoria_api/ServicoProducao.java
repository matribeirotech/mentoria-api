package com.lypsyos.mentoria_api;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServicoProducao {
    
    // 1. Declaração do atributo (usamos 'final' para garantir a imutabilidade)
    private final MaquinaCorte maquina;
    private final OrdemCorteRepository repository;

    // 2. Método Construtor (é aqui que o Spring vai injetar a dependência)
    
    // Adicionamos o @Qualifier junto ao parâmetro para ser explícito
    public ServicoProducao(@Qualifier("cortePlasma")MaquinaCorte maquina,
    					   OrdemCorteRepository repository) {
        					this.maquina = maquina;
        					this.repository = repository;
    }

    public void iniciarOrdem(String material, double espessuraMm) {
        System.out.println("Processando ordem no sistema...");
        this.maquina.cortar(material);
        
        // Salvar histórico no banco de dados
        OrdemCorte novaOrdem = new OrdemCorte(material, espessuraMm);
        repository.save(novaOrdem); // Comando mágico do JPA que faz o INSERT no banco
        
        System.out.println("Ordem salva no banco com ID: " + novaOrdem.getId());
    }
    public List<OrdemCorte> listarTodas(){
    	System.out.println("Buscando todas as ordens no banco de dados.... ");
    	return repository.findAll();
    }
}