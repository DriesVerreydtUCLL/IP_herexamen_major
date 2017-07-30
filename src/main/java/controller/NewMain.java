/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Player;
import exception.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.PlayerService;

/**
 *
 * @author Dries
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
            PlayerService instance = new PlayerService("Memory");
            Player player = new Player("Dries","Verreydt",99,1);
            instance.addPlayer(player);
            System.out.println(player.getFirstName());
            System.out.println(player.getId());
    }
    
}
