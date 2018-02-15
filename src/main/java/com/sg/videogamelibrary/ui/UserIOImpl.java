/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.ui;

import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOImpl implements UserIO{

    private Scanner sc = new Scanner(System.in);
    
    @Override
    public void display(String msg) {
        System.out.println(msg);
    }

    @Override
    public String promptString(String msg) {
        String result = "";
        display(msg);
        return result = sc.nextLine();        
    }

    @Override
    public int promptInt(String msg) {
       int result = 0;
       String response = promptString(msg);
       result = Integer.parseInt(response);
       return result;
    }
    
}
