package com.lypsyos.mentoria_api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
        
        return "Ordem enviada para a maquina! Verifique os logs no terminal.";
    }
    @PostMapping("/nova")
    public String criarOrdemPersonalizada(@Valid @RequestBody OrdemCorteRequest request) {
    	servico.iniciarOrdem(request.material(), request.espessuraMm());
    	return "Ordem de " + request.material() + " criada com sucesso!";
    }
    @GetMapping
    public List<OrdemCorte> buscarTodasOrdens(){
    	return servico.listarTodas();
    }
}