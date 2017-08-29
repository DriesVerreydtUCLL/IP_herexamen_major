package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Dummy;
import domain.Player;
import domain.PlayerValidator;
import exception.ServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.PlayerService;

/**
 *
 * @author Dries
 */
@Controller
@RequestMapping(value="/player")
@EnableWebMvc
public class PlayerController {
    
    @Autowired
    private PlayerValidator validator;
    private final PlayerService service;
    
    public PlayerController(@Autowired PlayerService service){
        this.service = service;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPlayers(){
        try {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("players",service.getPlayers());
            model.put("goals", service.getAvgGoals());
            return new ModelAndView("playerOverview", model);
        } catch (Exception e){
            return new ModelAndView("error","errorMessage",e.getMessage());
        }
    }
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
    public ModelAndView getNewForm(){
        return new ModelAndView("playerForm", "player", new Player());
    }
    
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("player") Player player, BindingResult result){
        validator.validate(player, result);
        if(result.hasErrors()){
            return new ModelAndView("playerForm", "player", player);
        }
        try {
            service.updatePlayer(player);
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("players",service.getPlayers());
            model.put("goals", service.getAvgGoals());
            model.put("message", "De speler met id " + player.getId()+ " is succesvol opgeslagen.");
            return new ModelAndView("playerOverview", model );
        } catch (Exception ex) {
            return new ModelAndView("error", "errorMessage", ex.getMessage());
        }
    }
    
    @RequestMapping(value="/delete/{id}")
    public String deletePlayer(@PathVariable Long id, RedirectAttributes redirectAttrs){
        try {
            service.removePlayer(id);
            /*Map<String, Object> model = new HashMap<String, Object>();
            model.put("players",service.getPlayers());
            model.put("goals", service.getAvgGoals());
            model.put("message", "De speler met id " + id + " is succesvol verwijderd.");      
            return new ModelAndView("playerOverview", model );*/
            redirectAttrs.addAttribute("id", id).addFlashAttribute("message", "De speler met id " + id + " is succesvol verwijderd.");
            return "redirect:/player.htm";
        } catch (Exception ex) {
            //return new ModelAndView("error", "errorMessage", ex.getMessage());
            redirectAttrs.addAttribute("id", id).addFlashAttribute("errorMessage", ex.getMessage());
            return "redirect:/error.htm";
        }
       
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable Long id){
        try {
            return new ModelAndView("playerForm", "player", service.getPlayer(id));
        } catch (Exception ex) {
            return new ModelAndView("error", "errorMessage", ex.getMessage());
        }
    }
    
}
