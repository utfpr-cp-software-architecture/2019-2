package com.example.app.servico;

import com.example.app.negocio.ClienteNegocio;
import com.example.app.dto.ClienteDTO;
import com.example.app.negocio.excecao.ObjetoJaExisteException;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClienteServico {
    
    private final ClienteNegocio clienteNegocio;
    
    @PostMapping ("/servico/cliente")
    public ResponseEntity<ClienteDTO> incluir (ClienteDTO cliente) throws ObjetoJaExisteException {
        
        clienteNegocio.incluir(cliente);
        
        return ResponseEntity.status(201).body(
                clienteNegocio.listar().stream()
                .filter(clienteAtual -> clienteAtual.getNome().equalsIgnoreCase(cliente.getNome()))
                .findAny()
                .get()
        );
    }
    
    @GetMapping ("/servico/cliente")
    public ResponseEntity<Set<ClienteDTO>> listar() {
        return ResponseEntity.ok(clienteNegocio.listar());
    }
    
}
