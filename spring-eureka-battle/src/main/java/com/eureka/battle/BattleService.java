package com.eureka.battle;
/*
import com.tribe.Tribes.village.Village;
import com.tribe.Tribes.village.VillageDTO;
import org.modelmapper.ModelMapper;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class BattleService {

    //private static ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private BattleRepository battleRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<BattleStats> all() {
        return battleRepository.findAll();
    }

    public Optional<BattleStats> one(Integer id) {
        return battleRepository.findById(id);
    }

    public BattleStats newBattle(BattleStats battleStats) {
        //simulateBattle(battleStats);
        return battleRepository.save(battleStats);
    }

    public void delete(Integer id) {
        battleRepository.deleteById(id);
    }
/*
    public void simulateBattle(BattleStats battleStats){

        String gameServiceURL = "http://game-service";

        int defId = battleStats.getDefenderVillageID();

        VillageDTO defenderVillageDTO = restTemplate.getForObject("http://game-service/villages/{id}", VillageDTO.class, defId);

        Village defenderVillage = convertToEntity(defenderVillageDTO);
        int defenderStrength = defenderVillage.getOverallStrength();

        int attId = battleStats.getAttackerVillageID();

        VillageDTO attackerVillageDTO = restTemplate.getForObject("http://game-service/villages/{id}", VillageDTO.class, attId);

        Village attackerVillage = convertToEntity(attackerVillageDTO);

        int attackerStrength = battleStats.getOffensiveStrength();

        if(attackerStrength > defenderStrength){
            defenderVillage.killUnitsAtHome();
            defenderVillageDTO.getUnitsAtHome().stream().forEach(soldierUnit -> soldierUnit.setNumberOfSoldiers(0));
            restTemplate.put(gameServiceURL + "/villages", defenderVillage, defId);
        }
        else{
            attackerVillage.killUnitsAtHome();
            attackerVillageDTO.getUnitsAtHome().stream().forEach(soldierUnit -> soldierUnit.setNumberOfSoldiers(0));
            restTemplate.put(gameServiceURL + "/villages", attackerVillageDTO, attId);
        }


    }

    public static Village convertToEntity(VillageDTO villageDto) {
        Village village = modelMapper.map(villageDto, Village.class);
        return village;
    }*/
}
