/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.service;

import com.sg.videogamelibrary.dao.Dao;
import com.sg.videogamelibrary.dao.PersistenceException;
import com.sg.videogamelibrary.dto.VideoGame;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class ServiceLayerImpl implements ServiceLayer {

    Dao dao;

    public ServiceLayerImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public VideoGame addVGL(String name, VideoGame currentGame) throws ValidInputException, PersistenceException {

        if (checkForInput(name) == false) {
            throw new ValidInputException("Invalid input/Did not fill feilds.");
        }

        return dao.addVGL(name, currentGame);
    }

    @Override
    public void removeVGL(String name, VideoGame currentGame) throws ValidInputException {
        if (checkForInput(name) == false || currentGame == null) {
            throw new ValidInputException("Invalid input/Did not fill feilds.");
        }
        try {
            dao.removeVGL(name, currentGame);
        } catch (PersistenceException ex) {
          throw new ValidInputException("Invalid input/Did not fill feilds." , ex);
        }
    }

    @Override
    public List<VideoGame> viewAll() {
        return dao.viewAll();
    }

    @Override
    public VideoGame getVG(String name) throws ValidInputException {

        if (checkForInput(name) == false) {
            throw new ValidInputException("Invalid input/Did not fill feilds.");
        }

        return dao.getVG(name);
    }

    public boolean checkForInput(String input) throws ValidInputException{
        if (input.equals("") || input.equals("") || input == null) {
            return false;
        } else {
            return true;
        }
    }

}
