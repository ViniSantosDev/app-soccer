package br.com.vinisantosdev.app_soccer.service;

import br.com.vinisantosdev.app_soccer.entity.Campeonato;
import br.com.vinisantosdev.app_soccer.entity.Jogo;
import br.com.vinisantosdev.app_soccer.entity.Time;
import br.com.vinisantosdev.app_soccer.exception.EntityNotFoundException;
import br.com.vinisantosdev.app_soccer.exception.ErrorIndicator;
import br.com.vinisantosdev.app_soccer.repository.CampeonatoRepository;
import br.com.vinisantosdev.app_soccer.repository.JogoRepository;
import br.com.vinisantosdev.app_soccer.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampeonatoService {

    @Autowired
    private CampeonatoRepository campeonatoRepository;
    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private TimeRepository timeRepository;


    public List<Campeonato> listarCampeonatos() {
        return campeonatoRepository.findAll();

    }


    public Campeonato criarCampeonato(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Campeonato adicionarTimeAoCampeonato(Long campeonatoId, Time time) throws EntityNotFoundException {
        Campeonato campeonato = campeonatoRepository.findById(campeonatoId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorIndicator.ERROR_INDICATOR_001));

        Time validTime = timeRepository.findById(time.getId())
                .orElseThrow(() -> new EntityNotFoundException(ErrorIndicator.ERROR_INDICATOR_001));

        campeonato.getTimesParticipantes().add(validTime);
        campeonatoRepository.save(campeonato);
        return campeonato;
    }

    private void criarJogosParaCampeonato(Long campeonatoId, Campeonato campeonato) {
        List<Time> times = campeonato.getTimesParticipantes();
        for (int i = 0; i < times.size(); i++) {
            for (int j = i + 1; j < times.size(); j++) {
                Jogo jogo = new Jogo();
                jogo.setCampeonato(campeonato);
                jogo.setTimeCasa(times.get(i));
                jogo.setTimeVisitante(times.get(j));
                jogo.setDataJogo(LocalDateTime.now().plusDays(i + j)); // Define uma data para o exemplo
                jogoRepository.save(jogo);
            }
        }
    }

    public void deletarCampeonato(Long campeonatoId) throws EntityNotFoundException {
        Campeonato campeonato = campeonatoRepository.findById(campeonatoId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorIndicator.ERROR_INDICATOR_001));

        campeonatoRepository.delete(campeonato);
    }
}
