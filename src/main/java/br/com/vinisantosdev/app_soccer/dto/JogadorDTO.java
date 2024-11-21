package br.com.vinisantosdev.app_soccer.dto;

import br.com.vinisantosdev.app_soccer.entity.Time;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JogadorDTO {

    @Size(max = 25, message = "NÃO PODE CRIAR NOME DE CAMPEONATO COM MAIS DE 25 CARACTERES")
    private String nome;
    @Size(max = 2, message = "NÃO PODE CRIAR IDADE DE JOGADOR COM MAIS DE 2 DIGITOS")
    private Integer idade;
    @Size(max = 20, message = "NÃO PODE CRIAR POSIÇÃO DO JOGADOR COM MAIS DE 20 CARACTERES")
    private String posicao;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
