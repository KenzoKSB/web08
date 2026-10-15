package com.ads.loja;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {

    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private int contador = 0;

    @GetMapping("/api/cliente")
    public Map<Integer, Cliente> listar() {
        return clientes;
    }

    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<Cliente> carregarDetalhe(@PathVariable("codigo") int codigo) {
        Cliente obj = clientes.get(codigo);
        if (obj == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/cliente")
    public Cliente gravar(@RequestBody Cliente obj) {
        contador++;
        obj.setCodigo(contador);
        clientes.put(contador, obj);
        return obj;
    }

    @PutMapping("/api/cliente/{codigo}")
    public ResponseEntity<Cliente> atualizar(
            @PathVariable("codigo") int codigo,
            @RequestBody Cliente obj) {
        if (!clientes.containsKey(codigo)) {
            return ResponseEntity.notFound().build();
        }
        obj.setCodigo(codigo);
        clientes.put(codigo, obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<Void> excluir(@PathVariable("codigo") int codigo) {
        if (clientes.remove(codigo) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
