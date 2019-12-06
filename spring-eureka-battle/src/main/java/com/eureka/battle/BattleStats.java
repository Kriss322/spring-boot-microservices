package com.eureka.battle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class BattleStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    int attackerVillageID;

    int defenderVillageID;

    int defPlayerID;

    int attPlayerID;

    @ElementCollection
    @CollectionTable(
            name="BATTLE_ATTACKER_ARMY",
            joinColumns=@JoinColumn(name="BATTLE_ID")
    )
    private List<SoldierUnit> attackerArmy;

    public int getOffensiveStrength(){
        int overallStrength = 0;

        for (SoldierUnit s: this.attackerArmy) {
            overallStrength += s.getOffensiveStrength();
        }

        return overallStrength;
    }
}
