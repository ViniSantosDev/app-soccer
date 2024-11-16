package br.com.vinisantosdev.app_soccer.controller;

import br.com.vinisantosdev.app_soccer.entity.Campeonato;
import br.com.vinisantosdev.app_soccer.entity.Time;
import br.com.vinisantosdev.app_soccer.exception.EntityNotFoundException;
import br.com.vinisantosdev.app_soccer.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {
    @Autowired
    private CampeonatoService campeonatoService;

    @GetMapping
    public ResponseEntity<List<Campeonato>> listarCampeonatos() {
        List<Campeonato> campeonatos = campeonatoService.listarCampeonatos();
        return ResponseEntity.ok(campeonatos);
    }

    @PostMapping
    public ResponseEntity<Campeonato> criarCampeonato(@RequestBody Campeonato campeonato) {
        Campeonato novoCampeonato = campeonatoService.criarCampeonato(campeonato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCampeonato);
    }

    @PostMapping("/{id}/times")
    public Campeonato adicionarTime(@PathVariable Long id, @RequestBody Time time) throws EntityNotFoundException {
        return campeonatoService.adicionarTimeAoCampeonato(id, time);
    }

    @DeleteMapping("/{campeonatoId}")
    public ResponseEntity<Void> deleteCampeonato(@PathVariable Long campeonatoId) {
        campeonatoService.deletarCampeonato(campeonatoId);
        return ResponseEntity.noContent().build();
    }
}



