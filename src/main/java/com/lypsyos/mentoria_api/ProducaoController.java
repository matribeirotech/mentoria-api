package com.lypsyos.mentoria_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Diz que esta classe vai responder a requisições Web/HTTP
@RequestMapping("/api/producao") // Define a rota base da URL
public class ProducaoController {

    private final ServicoProducao servico;

    // O Spring vê esse construtor, vai na "caixa" dele e injeta o ServicoProducao aqui!
    public ProducaoController(ServicoProducao servico) {
        this.servico = servico;
    }

    @GetMapping("/iniciar")
    public String iniciarProcesso() {
        // Chamamos a nossa regra de negócio pura
        servico.iniciarOrdem("Chapa de Aço 10mm");
        return "Ordem enviada para a maquina! Verifique os logs no terminal.";
    }
}