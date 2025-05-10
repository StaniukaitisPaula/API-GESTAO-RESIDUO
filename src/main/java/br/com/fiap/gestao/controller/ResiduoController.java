package br.com.fiap.gestao.controller;

import br.com.fiap.gestao.dto.ResiduoDTO;
import br.com.fiap.gestao.service.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residuo")
public class ResiduoController {

    @Autowired
    private ResiduoService service;

    @GetMapping
    public ResponseEntity<List<ResiduoDTO>> listar() {
        return ResponseEntity.ok(service.listarTudo());
    }

    @GetMapping("/{idResiduo}")
    public ResponseEntity<ResiduoDTO> buscarPorId(@PathVariable Long idResiduo) {
        return ResponseEntity.ok(service.buscarPorId(idResiduo));
    }

    @PostMapping
    public ResponseEntity<ResiduoDTO> criar(@RequestBody ResiduoDTO dto) {
        ResiduoDTO novo = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/{idResiduo}")
    public ResponseEntity<ResiduoDTO> atualizar(@PathVariable Long idResiduo, @RequestBody ResiduoDTO dto) {
        ResiduoDTO atualizado = service.atualizar(idResiduo, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{idResiduo}")
    public ResponseEntity<Void> deletar(@PathVariable Long idResiduo) {
        service.deletar(idResiduo);
        return ResponseEntity.noContent().build();
    }
}


