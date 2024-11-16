package br.com.vinisantosdev.app_soccer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @ManyToOne
    @JoinColumn(name = "time_casa_id")
    private Time timeCasa;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time timeVisitante;

    private LocalDateTime dataJogo;
    private Integer placarCasa = 0;
    private Integer placarVisitante = 0;
}
