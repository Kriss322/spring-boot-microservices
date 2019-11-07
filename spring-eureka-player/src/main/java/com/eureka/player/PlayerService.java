package com.eureka.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

@Service
public class PlayerService {

    @Autowired
    private RestTemplate restTemplate;

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayer(Integer id) {
        PlayerDAO playerDAO = playerRepository.getOne(id);
        //Player player = new Player(playerDAO);

        Player player = new Player(1,"player1", 300, "Katona");
        Set<Object> villages = restTemplate.getForObject("http://game-service/players/{id}/villages", Set.class);

        player.setVillages(villages);

        return player;
    }
}
