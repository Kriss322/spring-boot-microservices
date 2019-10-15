
package com.tribe.Tribes.village.buildings;

import com.tribe.Tribes.village.Resources;
import com.tribe.Tribes.village.Village;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable@Entity
@DiscriminatorValue("ClayPit")
@Data
public class ClayPit extends Building{


    public ClayPit(){}

    public ClayPit(Village village){
        super(village);
        this.setName("ClayPit");
    }

    @Override
    public void setStarterSettings() {

        this.level = 0;

        this.maxLevel = 30;

        this.productionPerHour = 30;

        Integer populationNeededForUpgrade = 1;
        Integer totalOfPopulation = 1;
        Integer clay = 65;
        Integer wood = 50;
        Integer iron = 40;
        for(int i = 1; i <= this.maxLevel; i++){

            this.populationNeededForUpgrade.put(i, populationNeededForUpgrade);
            this.totalOfPopulation.put(i, totalOfPopulation);
            this.resourceRequirementsForUpgrade.put(i, new Resources(clay, wood, iron));

            clay += (int) (clay * 0.2);
            wood += (int) (wood * 0.2);
            iron += (int) (iron * 0.2);

            totalOfPopulation += populationNeededForUpgrade;
            populationNeededForUpgrade++;

        }
    }
}
