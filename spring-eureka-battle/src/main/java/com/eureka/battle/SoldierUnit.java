package com.eureka.battle;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class SoldierUnit {

    private String name;

    protected int numberOfSoldiers;

    protected int archerDefenseStrength;

    protected int generalDefenseStrength;

    protected int offensiveStrength;

}
