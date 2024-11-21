package br.com.vinisantosdev.app_soccer.dto;

import br.com.vinisantosdev.app_soccer.entity.Jogo;
import br.com.vinisantosdev.app_soccer.entity.Time;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CampeonatoDTO {

    @Size(max = 50, message = "NÃO PODE CRIAR NOME DE CAMPEONATO COM MAIS DE 50 CARACTERES")
    @NotNull
    private String nome;
    @Size(max = 4, message = "ANO SÃO 4 DIGITOS")
    @NotNull
    private Integer ano;

    private List<Time> timesParticipantes = new ArrayList<>();

    private List<Jogo> jogos = new ArrayList<>();
}
