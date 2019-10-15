package com.eureka.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        Player player = new Player(playerDAO);

        List<Object> villages = restTemplate.getForObject("http://game-service/villages", List.class);

        player.setVillages(villages);

        return player;
    }
}
