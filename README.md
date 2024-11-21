Este diagrama representa:

1. As quatro entidades principais (TIME, JOGADOR, CAMPEONATO e JOGO)
2. Uma tabela de associação (CAMPEONATO_TIME) para representar a relação muitos-para-muitos entre CAMPEONATO e TIME
3. Todos os atributos de cada entidade
4. Os relacionamentos entre as entidades:

Um TIME possui muitos JOGADORs (1:N)
Um CAMPEONATO possui muitos JOGOs (1:N)
Um TIME pode ser time da casa ou visitante em muitos JOGOs (1:N)
Um CAMPEONATO pode ter muitos TIMEs e um TIME pode participar de muitos CAMPEONATOs (N:N)



As cardinalidades são representadas usando a notação:

||--o{ : Um para muitos
}|--|| : Muitos para muitos


![image](https://github.com/user-attachments/assets/ffabaaa8-534a-4be5-9e3f-9770284b665b)
