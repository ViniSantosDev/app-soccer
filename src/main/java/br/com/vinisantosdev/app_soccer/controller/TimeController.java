package br.com.vinisantosdev.app_soccer.controller;

import br.com.vinisantosdev.app_soccer.entity.Time;
import br.com.vinisantosdev.app_soccer.exception.EntityNotFoundException;
import br.com.vinisantosdev.app_soccer.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Time>> listarTimes() {
        List<Time> times = timeService.listarTimes();
        return ResponseEntity.ok(times);
    }

    @PostMapping
    public ResponseEntity<Time> createTime(@RequestBody Time time) {
        Time novoTime = timeService.criarTime(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTime);
    }

    @DeleteMapping("/{timeId}")
    public ResponseEntity<Void> deleteTime(@PathVariable Long timeId) throws EntityNotFoundException {
        timeService.deletarTime(timeId);
        return ResponseEntity.noContent().build();
    }
}