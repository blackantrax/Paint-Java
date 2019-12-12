/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwisesoft.TP2.Kevin_Nelson;

import java.awt.Color;

/**
 *
 * @author  Kevin Nelson
 */
public class Points {

    private Color color = Color.red;
    private int sizex = 10;
    private int sizey = 10;
    private int x = -10;
    private int y = -10;
    private String type = "ROND";
    private int opacity;

    // Constructeur par défaut
    public Points() {
    }
    // constructeur avec parametre

    public Points(int x, int y, int sizex,
            int sizey, Color color, String type, int opacity) {
        this.sizex = sizex;
        this.sizey = sizey;
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
        this.opacity = opacity;
    }

    //ACCESSEURS
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSizeX() {
        return sizex;
    }

    public void setSizeX(int size) {
        this.sizex = size;
    }

    public int getSizeY() {
        return sizey;
    }

    public void setSizeY(int size) {
        this.sizey = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getOPacity() {
        return opacity;
    }

    public void setOPacity(int opacity) {
        this.opacity = opacity;
    }

}
