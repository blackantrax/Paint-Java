/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwisesoft.TP2.Kevin_Nelson;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Kevin Nelson
 */
@SuppressWarnings("serial")
public class MonMenu extends JMenuBar {

    private final JMenu file, edit, doc, form, color, about;
    JColorChooser kader;
    JMenuItem nouveau, ouvrir, enregistre, enregistreSous,
            quitter, répéter, annuler, propriete, propos, menuItemRect,
            menuItemEllipse, menuItemTriangle, menuItemRemplissage, vider,
            menuItemEfface, menuItemBlack, menuItemBlanc, menuItemRouge,
            menuItemVert, menuItemBleu, menuItemJaune, menuItemDefinir;
    JLabel espace;

    public MonMenu() {
        // JMenu extenciation 
        file = new JMenu("Fichier");
        edit = new JMenu("Edition");
        doc = new JMenu("Document");
        form = new JMenu("Formes");
        color = new JMenu("Couleurs");
        about = new JMenu(" ? ");
        kader = new JColorChooser();

        //JMenuItem extenciation
        nouveau = new JMenuItem("   Nouveau...");
        ouvrir = new JMenuItem("   Ouvrir");
        enregistre = new JMenuItem("   Enregistrer");
        enregistreSous = new JMenuItem("   Enregistrer sous...");
        quitter = new JMenuItem("   Quitter");
        répéter = new JMenuItem("    Répéter");
        annuler = new JMenuItem("    annuler");
        propriete = new JMenuItem("Propriété...");
        propos = new JMenuItem("À propos");
        menuItemRect = new JMenuItem("Rectangle");
        menuItemEllipse = new JMenuItem("Ellipse");
        menuItemTriangle = new JMenuItem("Triangle");
        menuItemRemplissage = new JMenuItem("Remplissage");
        vider = new JMenuItem("Vider");
        menuItemEfface = new JMenuItem("Efface");
        menuItemBlack = new JMenuItem("Noir");
        menuItemBlanc = new JMenuItem("Blanc");
        menuItemRouge = new JMenuItem("Rouge");
        menuItemVert = new JMenuItem("Vert");
        menuItemBleu = new JMenuItem("Bleu");
        menuItemJaune = new JMenuItem("Jaune");
        menuItemDefinir = new JMenuItem("Définir...");
        // les  raccourcis
        menuItemEfface.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemBlanc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemBlack.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemBleu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemVert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemRouge.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemJaune.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemDefinir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        menuItemRect.setAccelerator(KeyStroke.
                getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_MASK));
        menuItemEllipse.setAccelerator(KeyStroke.
                getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_MASK));
        menuItemTriangle.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
                KeyEvent.CTRL_MASK));
        menuItemRemplissage.setAccelerator(KeyStroke.
                getKeyStroke(KeyEvent.VK_4, KeyEvent.CTRL_MASK));
        ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                KeyEvent.CTRL_MASK));
        nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                KeyEvent.CTRL_MASK));
        enregistre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_MASK));
        enregistreSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                KeyEvent.ALT_MASK));
        annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
                KeyEvent.CTRL_MASK));
        répéter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
                KeyEvent.CTRL_MASK));

        // les photos dans les JmenuItem
        menuItemEfface.setIcon(new ImageIcon(getClass().
                getResource("/images/eraser.png")));
        menuItemBlack.setIcon(new ImageIcon(getClass()
                .getResource("/images/black.png")));
        menuItemBlanc.setIcon(new ImageIcon(getClass()
                .getResource("/images/white.png")));
        menuItemRouge.setIcon(new ImageIcon(getClass()
                .getResource("/images/red.png")));
        menuItemVert.setIcon(new ImageIcon(getClass()
                .getResource("/images/green.png")));
        menuItemBleu.setIcon(new ImageIcon(getClass()
                .getResource("/images/blue.png")));
        menuItemJaune.setIcon(new ImageIcon(getClass()
                .getResource("/images/yellow.png")));
        vider.setIcon(new ImageIcon(getClass().
                getResource("/images/clear.png")));
        menuItemRect.setIcon(new ImageIcon(getClass().
                getResource("/images/rectangle.png")));
        menuItemEllipse.setIcon(new ImageIcon(getClass().
                getResource("/images/ellipse.png")));
        menuItemTriangle.setIcon(new ImageIcon(getClass().
                getResource("/images/triangle.png")));
        menuItemRemplissage.setIcon(new ImageIcon(getClass().
                getResource("/images/fill.png")));
        // Les sous menu
        file.add(nouveau);
        file.add(ouvrir);
        file.addSeparator();
        file.add(enregistre);
        file.add(enregistreSous);
        file.addSeparator();
        file.add(quitter);
        edit.add(annuler);
        edit.add(répéter);
        doc.add(propriete);
        doc.add(vider);
        about.add(propos);
        form.add(menuItemRect);
        form.add(menuItemEllipse);
        form.add(menuItemTriangle);
        form.add(menuItemRemplissage);
        color.add(menuItemEfface);
        color.addSeparator();
        color.add(menuItemBlack);
        color.add(menuItemBlanc);
        color.add(menuItemRouge);
        color.add(menuItemVert);
        color.add(menuItemBleu);
        color.add(menuItemJaune);
        color.addSeparator();
        color.add(menuItemDefinir);
        // MenuBer
        super.add(file);
        super.add(edit);
        super.add(doc);
        super.add(form);
        super.add(color);
        super.add(about);

    }

}
