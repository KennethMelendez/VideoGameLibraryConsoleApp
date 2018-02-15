/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.dao;

import com.sg.videogamelibrary.dto.VideoGame;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface Dao {

    VideoGame addVGL(String name,VideoGame currentGame)throws PersistenceException;

    void removeVGL(String name, VideoGame currentGame) throws PersistenceException;

    List<VideoGame> viewAll();
    
    VideoGame getVG(String name);
}
