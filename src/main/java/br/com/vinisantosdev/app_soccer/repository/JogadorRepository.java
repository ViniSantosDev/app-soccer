package br.com.vinisantosdev.app_soccer.repository;

import br.com.vinisantosdev.app_soccer.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
