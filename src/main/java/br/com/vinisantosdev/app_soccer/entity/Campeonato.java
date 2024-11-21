package br.com.vinisantosdev.app_soccer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
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
    private List<Time> timesParticipantes;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Jogo> jogos;

//    public Campeonato(@Size(max = 50, message = "NÃO PODE CRIAR NOME DE CAMPEONATO COM MAIS DE 50 CARACTERES") @NotNull String nome, @Size(max = 4, message = "ANO SÃO 4 DIGITOS") @NotNull Integer ano, List<Time> timesParticipantes, List<Jogo> jogos) {
//        this.nome = nome;
//        this.ano = ano;
//        this.jogos = jogos;
//        this.timesParticipantes = timesParticipantes;
//    }
}
