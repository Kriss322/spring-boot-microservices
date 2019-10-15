/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tribe.Tribes.player;

import com.tribe.Tribes.tribe.TribeDTO;
import com.tribe.Tribes.village.VillageDTO;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author kkassa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    
    private Integer id;
    
    private String name;

    private int playerPoints;

    private TribeDTO joinedTribe;

    // private String titleInTribe;


    //VillageDTO
    private List<VillageDTO> villages;

    //private WorldMap world;
}
