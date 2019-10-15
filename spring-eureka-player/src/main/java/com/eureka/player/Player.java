package com.eureka.player;

import lombok.Data;
import java.util.List;

@Data
public class Player {

    private Integer id;

    private String name;

    private Integer playerPoints;

    private String titleInTribe;

    private List<Object> villages;

    public Player(Integer id) {
        this.id = id;
    }

    public Player(PlayerDAO playerDAO){
        this.id = playerDAO.getId();
        this.name = playerDAO.getName();
        this.playerPoints = playerDAO.getPlayerPoints();
        this.titleInTribe = playerDAO.getTitleInTribe();
    }

}
