package br.com.vinisantosdev.app_soccer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores = new ArrayList<>();
}

