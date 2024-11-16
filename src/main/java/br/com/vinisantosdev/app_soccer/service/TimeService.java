package br.com.vinisantosdev.app_soccer.service;

import br.com.vinisantosdev.app_soccer.entity.Time;
import br.com.vinisantosdev.app_soccer.exception.EntityNotFoundException;
import br.com.vinisantosdev.app_soccer.exception.ErrorIndicator;
import br.com.vinisantosdev.app_soccer.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time criarTime(Time time) {
        return timeRepository.save(time);
    }

    public void deletarTime(Long timeId) throws EntityNotFoundException {
        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorIndicator.ERROR_INDICATOR_001));

        timeRepository.delete(time);
    }

    public List<Time> listarTimes() {
        return timeRepository.findAll();
    }
}
