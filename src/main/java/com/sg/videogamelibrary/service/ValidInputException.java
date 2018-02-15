/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary.service;

/**
 *
 * @author kmlnd
 */
public class ValidInputException extends Exception{

    public ValidInputException(String message) {
        super(message);
    }

    public ValidInputException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
