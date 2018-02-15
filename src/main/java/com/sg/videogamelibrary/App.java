/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.videogamelibrary;

import com.sg.videogamelibrary.controller.Controller;
import com.sg.videogamelibrary.dao.Dao;
import com.sg.videogamelibrary.dao.DaoImpl;
import com.sg.videogamelibrary.service.ServiceLayer;
import com.sg.videogamelibrary.service.ServiceLayerImpl;
import com.sg.videogamelibrary.ui.UserIO;
import com.sg.videogamelibrary.ui.UserIOImpl;
import com.sg.videogamelibrary.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ctx.getBean("Controller", Controller.class);
        controller.run();
        
        
    }

}
