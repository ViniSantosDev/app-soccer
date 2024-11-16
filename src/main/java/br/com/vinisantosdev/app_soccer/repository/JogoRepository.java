package br.com.vinisantosdev.app_soccer.repository;

import br.com.vinisantosdev.app_soccer.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
