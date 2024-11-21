package br.com.vinisantosdev.app_soccer.repository;

import br.com.vinisantosdev.app_soccer.dto.TimeDTO;
import br.com.vinisantosdev.app_soccer.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

    Optional<Time> findByNomeAndCidade(String nome, String cidade);

    @Query("SELECT t.nome AS nome, t.cidade AS cidade FROM Time t")
    List<TimeDTO> findAllDTO();
}
