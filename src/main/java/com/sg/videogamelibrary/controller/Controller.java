/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.controller;

import com.sg.videogamelibrary.dao.Dao;
import com.sg.videogamelibrary.dao.PersistenceException;
import com.sg.videogamelibrary.dto.VideoGame;
import com.sg.videogamelibrary.service.ServiceLayer;
import com.sg.videogamelibrary.service.ValidInputException;
import com.sg.videogamelibrary.ui.View;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class Controller {

    View v;
    ServiceLayer sl;

    public Controller(ServiceLayer sl, View v) {
        this.sl = sl;
        this.v = v;
    }

    public void run() {
        boolean turnOn = true;
        int menuSelection = 0;

        while (turnOn) {

            try {
                displayMenu();
                try{                    
                menuSelection = menuSelect();
                } catch(NumberFormatException ex){
                    displayMessageException("Invalid menu input.");
                }
                switch (menuSelection) {
                    case 1:
                {
                    try {
                        //Add Video game
                        addLB();
                    } catch (PersistenceException ex) {
                        displayMessageException(ex.getMessage());
                    }
                }
                        break;
                    case 2:
                        //Delete Video game
                        try {
                            removeLB();
                        } catch (NullPointerException e) {
                            displayMessageException("Game not Found.");
                        }
                        break;
                    case 3:
                        //View all video games;
                        displayAll();
                        break;
                    case 4:
                        //get a video game;
                        try {
                            getGame();
                        } catch (NullPointerException e) {
                            displayMessageException("Game not Found.");
                        }
                        break;
                    default:
                        //invalid input
                        turnOn = false;
                        break;
                }
            } catch (ValidInputException ex) {
                displayMessageException(ex.getMessage());
            }

        }
        displayMessageException("Good bye!");
    }

    private void addLB() throws ValidInputException, PersistenceException {
        VideoGame currentGame = v.addVG();
        sl.addVGL(currentGame.getName(), currentGame);
    }

    private void displayAll() {
        v.displayAllVG(sl.viewAll());
    }

    private int menuSelect() {
        return v.menuSelectPrompt();
    }

    private void displayMenu() {
        v.videoGameLibraryBannerMenu();
    }

    private void removeLB() throws ValidInputException {
        VideoGame currentGame = sl.getVG(v.promptGame());
        sl.removeVGL(currentGame.getName(), currentGame);
    }

    private void getGame() throws ValidInputException {
        v.displayAGame(sl.getVG(v.promptGame()));
    }

    private void displayMessageException(String message) {
        v.displayMessage(message);
    }

}
