package com.eureka.player;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/{id}")
    @ResponseBody
    public Player getPlayer(@PathVariable("id") Integer id){

        Player players = playerService.getPlayer(id);
        return players;
    }

    // a fallback method to be called if failure happened
    public Player fallback(Integer id, Throwable hystrixCommand){
        return new Player(id);
    }



}
