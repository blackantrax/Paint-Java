/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwisesoft.TP2.Kevin_Nelson;

import javax.swing.*;

/**
 *
 * @author  Kevin Nelson
 */
public class Toolbar extends JToolBar {

    JSpinner spinner, spinner1, spinner2;

    JButton rect, ellipse, triangle, fill, pattern, eraser, black,
            white, red, green, blue, yellow, definir, clear;
    JLabel size;
    public Toolbar() {

        spinner = new JSpinner(new SpinnerNumberModel(25, 0, 50, 1));
        spinner1 = new JSpinner(new SpinnerNumberModel(25, 0, 50, 1));
        spinner2 = new JSpinner(new SpinnerNumberModel(100, 0, 100, 1));
        // Les JBouton
        clear = new JButton(new ImageIcon(getClass()
                .getResource("/images/clear.png")));
        rect = new JButton(new ImageIcon(getClass()
                .getResource("/images/rectangle.png")));
        ellipse = new JButton(new ImageIcon(getClass()
                .getResource("/images/ellipse.png")));
        triangle = new JButton(new ImageIcon(getClass()
                .getResource("/images/triangle.png")));
        fill = new JButton(new ImageIcon(getClass()
                .getResource("/images/fill.png")));
        pattern = new JButton(new ImageIcon(getClass()
                .getResource("/images/pattern.png")));
        eraser = new JButton(new ImageIcon(getClass()
                .getResource("/images/eraser.png")));
        black = new JButton(new ImageIcon(getClass()
                .getResource("/images/black.png")));
        white = new JButton(new ImageIcon(getClass()
                .getResource("/images/white.png")));
        red = new JButton(new ImageIcon(getClass()
                .getResource("/images/red.png")));
        green = new JButton(new ImageIcon(getClass()
                .getResource("/images/green.png")));
        blue = new JButton(new ImageIcon(getClass()
                .getResource("/images/blue.png")));
        yellow = new JButton(new ImageIcon(getClass()
                .getResource("/images/yellow.png")));
        definir = new JButton("Définir...");
        size = new JLabel(new ImageIcon(getClass()
                .getResource("/images/size.png")));

        //Les images 
        // mettre les boutons dans le frame
        super.add(rect);
        super.add(ellipse);
        super.add(triangle);
        super.add(fill);
        super.add(pattern);
        super.add(new JLabel(" "));
        super.add(new JSeparator(JSeparator.VERTICAL));// 
        super.addSeparator();
        super.add(eraser);
        super.add(black);
        super.add(white);
        super.add(red);
        super.add(green);
        super.add(blue);
        super.add(new JLabel(" "));
        super.add(new JSeparator(JSeparator.VERTICAL));//
        super.addSeparator();
        super.add(yellow);
        super.add(definir);
        super.add(size);
        super.add(new JLabel(" taille "));
        super.add(spinner1);
        super.add(new JLabel(" x "));//
        super.add(spinner);//
        super.add(new JLabel("  Pression : "));//
        super.add(spinner2);//
        super.add(new JLabel(" "));
        super.add(new JSeparator(JSeparator.VERTICAL));//
        super.addSeparator();
        super.add(clear);
        super.add(new JLabel("Vider"));
        super.add(new JLabel(String.format("%100s", " ")));
        super.setFloatable(false);
        super.setRollover(true);

    }
}
