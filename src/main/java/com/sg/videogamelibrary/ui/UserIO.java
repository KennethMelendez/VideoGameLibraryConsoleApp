/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.ui;

/**
 *
 * @author kmlnd
 */
public interface UserIO {

    void display(String msg);

    String promptString(String msg);

    int promptInt(String msg);
}
