package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Player;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.PlayerService;

@RestController
@RequestMapping(value = "/rest")
public class PlayerRESTController {

    private final PlayerService service;
    
    public PlayerRESTController(@Autowired PlayerService service){
        this.service = service;
    }
    
    @RequestMapping(value="/players", method = RequestMethod.GET)
    public List<Player> getPlayers(){
        System.out.println("Getting players");
        try {
            return service.getPlayers(); 
        } catch (Exception e){
            return new ArrayList<>();
        }
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Player getPlayer(@PathVariable Long id){
        System.out.println("Get player" + id);
        try {
            return service.getPlayer(id);
        }
        catch (Exception e){
            return new Player();
        }
    }
    
}