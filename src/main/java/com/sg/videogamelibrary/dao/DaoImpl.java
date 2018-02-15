/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.dao;

import com.sg.videogamelibrary.dto.VideoGame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class DaoImpl implements Dao {

    private Map<String, VideoGame> Library = new HashMap<>();
    private static final String SAVE_FILE = "library.txt";
    private static final String DELIMETER = "::";

    @Override
    public VideoGame addVGL(String name, VideoGame currentGame) throws PersistenceException {
        VideoGame currentgame = Library.put(name, currentGame);
        try {
            Load();
            Save();
        } catch (PersistenceException ex) {
            throw new PersistenceException("Unable to save", ex);
        }
        return currentgame;
    }

    @Override
    public void removeVGL(String name, VideoGame currentGame)throws PersistenceException {
        try {
            Load();
            Save();
        } catch (PersistenceException ex) {
            throw new PersistenceException("Unable to save", ex);
        }
        
        Library.remove(name, currentGame);
    }

    @Override
    public List<VideoGame> viewAll() {
        return new ArrayList<>(Library.values());
    }

    @Override
    public VideoGame getVG(String name) {
        return Library.get(name);
    }

    private void Save() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(SAVE_FILE));
        } catch (IOException ex) {
            throw new PersistenceException("Unable to save", ex);
        }

        List<VideoGame> display = this.viewAll();
        for (VideoGame list : display) {
            out.println(list.getName() + DELIMETER + list.getDescription() + DELIMETER + list.getRating());
            out.flush();
        }

        out.close();

    }

    private void Load() throws PersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(SAVE_FILE)));
        } catch (FileNotFoundException ex) {
            throw new PersistenceException("File can't be loaded", ex);
        }

        String currentLine;
        String[] currentToken;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();

            currentToken = currentLine.split(DELIMETER);

            VideoGame current = new VideoGame(currentToken[0]);
            current.setDescription(currentToken[1]);
            current.setRating(currentToken[2]);

            Library.put(current.getName(), current);
        }
        //close scanner
        scanner.close();

    }

}
