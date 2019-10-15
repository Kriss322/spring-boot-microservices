package com.tribe.Tribes.player;

import com.tribe.Tribes.tribe.Tribe;
import com.tribe.Tribes.village.Village;
import java.io.Serializable;
import java.util.List;

import com.tribe.Tribes.village.WorldMap;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player implements Serializable {

    @Id @GeneratedValue
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private Integer playerPoints;

    @ManyToOne
    @JoinColumn(name="tribe_id")
    private Tribe joinedTribe;

    private String titleInTribe;

    @OneToMany(mappedBy="ownerPlayer", fetch = FetchType.EAGER)
    private List<Village> villages;

    @ManyToOne
    @JoinColumn(name="worldmap_id")
    private WorldMap world;

    public void addPoints(int points){
        this.playerPoints += points;
    }

    public void addVillage(Village village){
        this.villages.add(village);
    }
}
