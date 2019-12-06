package com.eureka.battle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/battles")
public class BattleController {

    @Autowired
    private RestTemplate restTemplate;

    private BattleService battleService;

    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @GetMapping
    public List<BattleStats> all(){
        return battleService.all();
    }

    @GetMapping("/{id}")
    public Optional<BattleStats> one(@PathVariable Integer id){
        return battleService.one(id);
    }

    @PostMapping
    public BattleStats newBattle(@RequestBody BattleStats battleStats){
        return battleService.newBattle(battleStats);
    }

    @DeleteMapping("/{id}")
    public void deleteBattle(@PathVariable Integer id){
        battleService.delete(id);
    }

}
