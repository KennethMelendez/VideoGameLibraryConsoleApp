/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.service;

import com.sg.videogamelibrary.dao.PersistenceException;
import com.sg.videogamelibrary.dto.VideoGame;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface ServiceLayer {

    VideoGame addVGL(String name, VideoGame currentGame)throws ValidInputException, PersistenceException;

    void removeVGL(String name, VideoGame currentGame)throws ValidInputException;

    List<VideoGame> viewAll();

    VideoGame getVG(String name) throws ValidInputException;
}
