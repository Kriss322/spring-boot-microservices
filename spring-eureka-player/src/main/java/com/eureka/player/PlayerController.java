package com.eureka.player;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tribe.Tribes.player.PlayerDTO;
import com.tribe.Tribes.tribe.TribeController;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.tribe.Tribes.player.Player;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {


    private static ModelMapper modelMapper = new ModelMapper();

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
/*
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/{id}")
    @ResponseBody
    public Player getPlayer(@PathVariable("id") Integer id){

        Player players = playerService.getPlayer(id);
        return players;
    }

    @GetMapping
    @ResponseBody
    public List<PlayerDTO> getAllPlayers(){
        List<Player> players = playerService.getAllPlayers();
        return players.stream()
                .map(player -> convertToDto(player))
                .collect(Collectors.toList());
    }

    // a fallback method to be called if failure happened
    public Player fallback(Integer id, Throwable hystrixCommand){
        return new Player(id);
    }
*/
    public static com.tribe.Tribes.player.Player convertToEntity(PlayerDTO playerDto) {
        com.tribe.Tribes.player.Player player = modelMapper.map(playerDto, com.tribe.Tribes.player.Player.class);
        return player;
    }

    public static PlayerDTO convertToDto(com.tribe.Tribes.player.Player player) {
        PlayerDTO playerDto = modelMapper.map(player, PlayerDTO.class);

        /*
        playerDto.setVillageIds(player.getVillages()
                .stream()
                .map(Village::getId)
                .collect(Collectors.toList()));
        */


        if(player.getJoinedTribe() != null){
            playerDto.setJoinedTribe(TribeController.convertToDto(player.getJoinedTribe()));
        }


        return playerDto;
    }

}
