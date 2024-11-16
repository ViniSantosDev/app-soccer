package br.com.vinisantosdev.app_soccer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private String posicao;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
