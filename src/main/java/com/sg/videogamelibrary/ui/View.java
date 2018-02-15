/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.ui;

import com.sg.videogamelibrary.dto.VideoGame;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public class View {

    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void videoGameLibraryBannerMenu() {
        io.display("=== Video Game Library ===");
        io.display("1. Add Video Game");
        io.display("2. Delete Video Game");
        io.display("3. View All Video Game");
        io.display("4. View a Video Game");
        io.display("Exit");
    }

    public VideoGame addVG() {

        String name = io.promptString("Please Input Video Game Title");
        VideoGame vg = new VideoGame(name);
        String desc = io.promptString("Please Input Video Game description");
        vg.setDescription(desc);
        String rating = io.promptString("Please Input Video Game Rating");
        vg.setRating(rating);
        io.display("Thank you!");
        return vg;
    }

    public void displayAllVG(List<VideoGame> list) {
        io.display("=== Displaying Library ===");
        for (VideoGame display : list) {
            io.display(display.getName());
            io.display(display.getDescription());
            io.display(display.getRating());
            io.display("~~~~~~~~~~~~");
        }
    }

    public void displayAGame(VideoGame display) {
        io.display(display.getName());
        io.display(display.getDescription());
        io.display(display.getRating());
    }

    public int menuSelectPrompt() {
        return io.promptInt("Input selection from menu.");
    }

    public String promptGame() {
        return io.promptString("Input name of game");
    }
    
    public void displayMessage(String message){
        io.display(message);
    }

}
