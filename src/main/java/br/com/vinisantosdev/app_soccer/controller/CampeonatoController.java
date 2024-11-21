package br.com.vinisantosdev.app_soccer.controller;

import br.com.vinisantosdev.app_soccer.dto.CampeonatoDTO;
import br.com.vinisantosdev.app_soccer.entity.Campeonato;
import br.com.vinisantosdev.app_soccer.entity.Time;
import br.com.vinisantosdev.app_soccer.exception.BusinessException;
import br.com.vinisantosdev.app_soccer.exception.EntityNotFoundException;
import br.com.vinisantosdev.app_soccer.service.CampeonatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonatos")
@Tag(name = "Campeonatos", description = "Gerenciamento de Campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoService campeonatoService;

    @Operation(summary = "Lista todos os campeonatos", description = "Retorna uma lista de todos os campeonatos cadastrados.")
    @GetMapping
    public ResponseEntity<List<Campeonato>> listarCampeonatos() {
        List<Campeonato> campeonatos = campeonatoService.listarCampeonatos();
        return ResponseEntity.ok(campeonatos);
    }

    @Operation(summary = "Lista o campeonato por ID", description = "Retorna um campeonato cadastrado.")
    @GetMapping("/{id}")
    public HttpEntity<Optional<Campeonato>> listarCampeonatoById(@PathVariable Long id) throws EntityNotFoundException{
       Optional<Campeonato> campeonatos = campeonatoService.listarCampeonatoById(id);
        return ResponseEntity.ok(campeonatos);
    }
    @Operation(summary = "Cria um novo Campeonato", description = "Adiciona um novo Campeonato no sistema.")
    @PostMapping
    public ResponseEntity<Campeonato> criarCampeonato(@RequestBody Campeonato campeonato) throws BusinessException {
        Campeonato novoCampeonato = campeonatoService.criarCampeonato(campeonato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCampeonato);
    }

//    @PostMapping("/lote")
//    public ResponseEntity<List<Campeonato>> criarCampeonatosEmLote(@RequestBody @Valid List<CampeonatoDTO> campeonatoDTOs) {
//        List<Campeonato> campeonatos = campeonatoService.criarCampeonatosEmLote(campeonatoDTOs);
//        return ResponseEntity.status(HttpStatus.CREATED).body(campeonatos);
//    }



    @PostMapping("/{id}/times")
    public Campeonato adicionarTime(@PathVariable Long id, @RequestBody Time time) throws EntityNotFoundException {
        return campeonatoService.adicionarTimeAoCampeonato(id, time);
    }

    @Operation(summary = "Deleta um campeonato", description = "Remove um campeonato pelo ID.")
    @DeleteMapping("/{campeonatoId}")
    public ResponseEntity<Void> deleteCampeonato(@PathVariable Long campeonatoId) throws EntityNotFoundException{
        campeonatoService.deletarCampeonato(campeonatoId);
        return ResponseEntity.noContent().build();
    }
}



