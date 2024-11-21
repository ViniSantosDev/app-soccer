package br.com.vinisantosdev.app_soccer.service;

import br.com.vinisantosdev.app_soccer.dto.TimeDTO;
import br.com.vinisantosdev.app_soccer.entity.Time;
import br.com.vinisantosdev.app_soccer.exception.BusinessException;
import br.com.vinisantosdev.app_soccer.exception.EntityNotFoundException;
import br.com.vinisantosdev.app_soccer.exception.ErrorIndicator;
import br.com.vinisantosdev.app_soccer.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time criarTime(Time time) throws BusinessException {
        Optional<Time> timeExistente = timeRepository.findByNomeAndCidade(time.getNome(), time.getCidade());
        if (timeExistente.isPresent()) {
            throw new BusinessException(ErrorIndicator.BAD_REQUEST_TEAM_EXISTS);
        }
        return timeRepository.save(time);
    }

    public void deletarTime(Long timeId) throws EntityNotFoundException {
        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorIndicator.RESOURCE_NOT_FOUND));

        timeRepository.delete(time);
    }

    public List<TimeDTO> listarTimes() {
        return timeRepository.findAllDTO();
    }
}
