/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desktopclient.Logic;

import javax.swing.JFrame;

/**
 *
 * @author rmoreno
 */
public class MyFrame extends JFrame {

/**
 * Launch the application.
 */
    public static void main(String[] args) {

                    MyFrame frame = new MyFrame();
                    frame.setVisible(true);

    }
    /**
     * Create the frame.
     */
    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* important Statement */
        setUndecorated(true);
    }
}
