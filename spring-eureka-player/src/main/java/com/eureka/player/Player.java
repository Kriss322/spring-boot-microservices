package com.eureka.player;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.util.List;
import java.util.Set;

@Data
public class Player {
    public Player(Integer id, String name, Integer playerPoints, String titleInTribe) {
        this.id = id;
        this.name = name;
        this.playerPoints = playerPoints;
        this.titleInTribe = titleInTribe;
    }

    private Integer id;

    private String name;

    private Integer playerPoints;

    private String titleInTribe;

    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Object> villages;

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
