package com.eureka.common.village;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Village {

    private Integer id;

    private String name;

    private int villagePoints;

    private Integer ownerPlayer;

    private int currentPopulation;

    private int maxPopulation;
    //
    private WorldPosition position;
    //
    private Resources resourcesInWareHouse;
    //
    private ResourceProduction resourceProducementPerHour;
    //
    private List<SoldierUnit> unitsAtHome;
    //
    private List<BuildingDTO> buildings;

    private List<Integer> buildingsLevel;
}