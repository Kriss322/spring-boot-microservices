
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@DiscriminatorValue("Farm")
@Data
public class Farm extends Building{



    public Farm(){}

    public Farm(Village village){
        super(village);
        this.setName("Farm");
    }

    @Override
    public void setStarterSettings() {

        this.level = 1;

        this.maxLevel = 30;

        Integer maxPopulation = 240;
        Integer clay = 45;
        Integer wood = 40;
        Integer iron = 30;
        for(int i = 1; i <= this.maxLevel; i++){

            this.maximumPopulation.put(i, maxPopulation);
            this.populationNeededForUpgrade.put(i, 0);
            this.totalOfPopulation.put(i, 0);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.25);
            wood += (int) (wood * 0.25);
            iron += (int) (iron * 0.25);

            maxPopulation += (int) (maxPopulation * 0.15);

        }
    }
}
