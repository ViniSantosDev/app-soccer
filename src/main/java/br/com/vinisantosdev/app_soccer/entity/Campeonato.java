package br.com.vinisantosdev.app_soccer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer ano;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "campeonato_times",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id"))
    private List<Time> timesParticipantes = new ArrayList<>();

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Jogo> jogos = new ArrayList<>();
}
