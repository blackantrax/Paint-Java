/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dwisesoft.TP2.Kevin_Nelson;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.AncestorListener;

/**
 * Le code fait pour engeristrer et enregistrer sous n'étaient pas fonctionnel, raison pour laquel j'ai simplement
 * laissé l'ouverture de la page de sauvegarde sans plus.
 * @author Kevin Nelson
 */
@SuppressWarnings("serial")
public class MonMenu extends JMenuBar implements ActionListener {

    private final JMenu fichier, editer, document, formes, couleurs, aPropos;
    private JColorChooser choixCouleurs;
    private String file;
    private int reponse;
    JMenuItem nouveau;
    JMenuItem ouvrir;
    JMenuItem enregistre, enregistreSous,
            quitter, répéter, annuler, propriete, propos, menuItemRect,
            menuItemEllipse, menuItemTriangle, menuItemRemplissage, vider,
            menuItemEfface, menuItemBlack, menuItemBlanc, menuItemRouge,
            menuItemVert, menuItemBleu, menuItemJaune, menuItemDefinir;
    private JLabel espace;

    public MonMenu() {
        // JMenu extenciation 
        fichier = new JMenu("Fichier");
        editer = new JMenu("Edition");
        document = new JMenu("Document");
        formes = new JMenu("Formes");
        couleurs = new JMenu("Couleurs");
        aPropos = new JMenu(" ? ");
        choixCouleurs = new JColorChooser();

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
        fichier.add(nouveau);
        fichier.add(ouvrir);
        fichier.addSeparator();
        fichier.add(enregistre);
        fichier.add(enregistreSous);
        fichier.addSeparator();
        fichier.add(quitter);
        editer.add(annuler);
        editer.add(répéter);
        document.add(propriete);
        document.add(vider);
        aPropos.add(propos);
        formes.add(menuItemRect);
        formes.add(menuItemEllipse);
        formes.add(menuItemTriangle);
        formes.add(menuItemRemplissage);
        couleurs.add(menuItemEfface);
        couleurs.addSeparator();
        couleurs.add(menuItemBlack);
        couleurs.add(menuItemBlanc);
        couleurs.add(menuItemRouge);
        couleurs.add(menuItemVert);
        couleurs.add(menuItemBleu);
        couleurs.add(menuItemJaune);
        couleurs.addSeparator();
        couleurs.add(menuItemDefinir);
        // MenuBer
        super.add(fichier);
        super.add(editer);
        super.add(document);
        super.add(formes);
        super.add(couleurs);
        super.add(aPropos);

        enregistre.addActionListener((ActionListener) this);
        enregistreSous.addActionListener((ActionListener) this);
        nouveau.addActionListener((ActionListener) this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enregistre) {

            try {

                JFileChooser chooser = new JFileChooser();

                // Dossier Courant
                chooser.setCurrentDirectory(new File("." + File.separator));

                //Affichage et récupération de la réponse de l'utilisateur
                reponse = chooser.showDialog(chooser, "Enregistrer sous");

                // Si l'utilisateur clique sur OK
                if (reponse == JFileChooser.APPROVE_OPTION) {

                    // Récupération du chemin du fichier
                    file = chooser.getSelectedFile().toString();

                    //Ecriture du fichier
                    //...
                }
            } catch (HeadlessException he) {
                he.printStackTrace();
            }
        } else if (e.getSource() == enregistreSous) {
            
              try {

                JFileChooser chooser = new JFileChooser();

                // Dossier Courant
                chooser.setCurrentDirectory(new File("." + File.separator));

                //Affichage et récupération de la réponse de l'utilisateur
                reponse = chooser.showDialog(chooser, "Enregistrer sous");

                // Si l'utilisateur clique sur OK
                if (reponse == JFileChooser.APPROVE_OPTION) {

                    // Récupération du chemin du fichier
                    file = chooser.getSelectedFile().toString();

                    //Ecriture du fichier
                    //...
                }
            } catch (HeadlessException he) {
                he.printStackTrace();
            }

        } else if (e.getSource() == nouveau) {
            vider.addActionListener((ActionListener) this);
        }

    }

}
