package com.eureka.common.village;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingDTO {

    private Integer id;

    private String name;

    private int level;

    //Village
    private Integer ownerVillageId;

    private Resources resourcesForNextLevel;

    private Integer populationNeededForNextLevel;

    protected Map<String, Integer> requirements;

}