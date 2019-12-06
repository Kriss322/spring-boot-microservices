package com.eureka.common.village;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class SoldierUnit implements Serializable {

    protected String name;

    protected Resources resourceTrainingCost;

    protected Village ownerVillage;

    protected int numberOfSoldiers;

    protected int population;

    protected int archerDefenseStrength;

    protected int generalDefenseStrength;

    protected int offensiveStrength;

    //minutes per field
    protected int speed;

    protected int haulCapacity;

    //protected Map<String, Integer> requirements;

    public void addToNumberOfSoldiers(int value){
        this.numberOfSoldiers += value;
    }
}