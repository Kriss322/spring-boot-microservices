package com.tribe.Tribes.battle;

import com.tribe.Tribes.player.Player;
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.units.SoldierUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ATTAcKER_VILLAGE_ID")
    private Village attackerVillage;

    @ManyToOne
    @JoinColumn(name = "DEFENDER_VILLAGE_ID")
    private Village defenderVillage;

    @ElementCollection
    @CollectionTable(
            name="BATTLE_ATTACKER_ARMY",
            joinColumns=@JoinColumn(name="BATTLE_ID")
            )
    private List<SoldierUnit> attackerArmy;

    @ElementCollection
    @CollectionTable(
            name="BATTLE_DEFENDER_ARMY",
            joinColumns=@JoinColumn(name="BATTLE_ID")
    )
    private List<SoldierUnit> defenderArmy;

    // private Player attackerPlayer;

    // private Player defenderPlayer;

    private LocalDateTime date;

    //private Player winnerPlayer;

    @ElementCollection
    @CollectionTable(
            name="BATTLE_SURVIVED_ARMY",
            joinColumns=@JoinColumn(name="BATTLE_ID")
    )
    List<SoldierUnit> survivedUnits;

    public Village simulateBattle(){

        int overallDefenseStrength = 0;
        for ( SoldierUnit unit : this.defenderArmy) {
            overallDefenseStrength += unit.getGeneralDefenseStrength() * unit.getNumberOfSoldiers();
        }

        int overallOffensiveStrength = 0;
        for (SoldierUnit unit : this.attackerArmy
             ) {
            overallOffensiveStrength += unit.getOffensiveStrength() * unit.getNumberOfSoldiers();
        }

        if(overallDefenseStrength >= overallOffensiveStrength){
            return defenderVillage;
        }
        else return attackerVillage;
    }

}
