/**
 * Copyright (c) 2010-2019 Google, Inc. http://angularjs.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWAR
 */
package com.dwisesoft.TP2.Kevin_Nelson;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Prof: Mme Najoua G.
 * DA: 1769692
 * @since  01-11-2019
 * @author Kevin Nelson
 * @author Malene Bridelle
 * @author Pierre Meridien Laury
 *  C'est dans cette classe que les actions Listener sont fait.
 * Il y a également les dessins qui se font.
 */
@SuppressWarnings("serial")
public class DrawPanel extends JPanel implements ActionListener {

    private final JButton bouton1, bouton2, bouton3, bouton4,
            ok1, anuller1, ok, anuller, definir;
    private final JColorChooser choixCouleur;
    protected Toolbar BarreTache;
    protected MonMenu menuBar;
    private final BufferedImage img;
    private Graphics g1;
    private Color pointerColor, couleurs;
    private String pointeurType;
    private boolean vider;
    private int opacity, taillex, tailley;
    Graphics2D g2d;
    double myOpacity;
    private ArrayList<Points> pointsD;
    private final ArrayList<Points> pointsD1;
    private ArrayList<Integer> live;
    private final ArrayList<Integer> live1;

    @SuppressWarnings("LeakingThisInConstructor")
    public DrawPanel() {
        // Initialisation des variables

        vider = true;
        pointeurType = "CERCLE";
        couleurs = gray;
        pointerColor = Color.black;
        menuBar = new MonMenu();
        BarreTache = new Toolbar();
        ok = new JButton("Ok");
        ok1 = new JButton("Ok");
        choixCouleur = new JColorChooser();
        anuller = new JButton("Anuller");
        anuller1 = new JButton("Anuller");
        bouton1 = new JButton(new ImageIcon(getClass()
                .getResource("/images/up.png")));
        bouton2 = new JButton(new ImageIcon(getClass()
                .getResource("/images/down.png")));
        bouton3 = new JButton(new ImageIcon(getClass()
                .getResource("/images/left.png")));
        bouton4 = new JButton(new ImageIcon(getClass()
                .getResource("/images/right.png")));
        img = new BufferedImage(35, 20, BufferedImage.TYPE_INT_RGB);
        definir = new JButton("Définir", new ImageIcon(getClass().
                getResource("/images/black.png")));
        pointsD1 = new ArrayList<>();
        pointsD = new ArrayList<>();
        live = new ArrayList<>();
        live1 = new ArrayList<>();
        live1.add(0);
        super.setOpaque(false);

        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                pointsD.add(new Points(e.getX() - (taillex / 2),
                        e.getY() - (tailley / 2), taillex,
                        tailley, pointerColor, pointeurType, opacity));
                repaint();

                live.add(pointsD.size());
            }
        });

        super.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //On récupère les coordonnées de la souris et on enlève
                //  la moitié de la taille du pointeur pour centrer le tracé
                pointsD.add(new Points(e.getX() - (taillex / 2),
                        e.getY() - (tailley / 2), taillex, tailley,
                        pointerColor, pointeurType, opacity));
                repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        //Toutes mes actions listener
        definir.addActionListener(this);
        menuBar.propos.addActionListener(this);
        BarreTache.clear.addActionListener(this);
        menuBar.vider.addActionListener(this);
        BarreTache.black.addActionListener(this);
        BarreTache.yellow.addActionListener(this);
        BarreTache.eraser.addActionListener(this);
        BarreTache.white.addActionListener(this);
        BarreTache.red.addActionListener(this);
        BarreTache.green.addActionListener(this);
        BarreTache.blue.addActionListener(this);
        BarreTache.definir.addActionListener(this);
        BarreTache.ellipse.addActionListener(this);
        ok.addActionListener(this);
        menuBar.quitter.addActionListener(this);
        menuBar.propriete.addActionListener(this);
        menuBar.menuItemBlack.addActionListener(this);
        menuBar.menuItemBlanc.addActionListener(this);
        menuBar.menuItemBleu.addActionListener(this);
        menuBar.menuItemDefinir.addActionListener(this);
        menuBar.menuItemJaune.addActionListener(this);
        menuBar.menuItemVert.addActionListener(this);
        menuBar.menuItemEfface.addActionListener(this);
        menuBar.menuItemRouge.addActionListener(this);
        menuBar.menuItemRect.addActionListener(this);
        menuBar.menuItemEllipse.addActionListener(this);
        menuBar.menuItemTriangle.addActionListener(this);
        menuBar.menuItemRemplissage.addActionListener(this);//
        BarreTache.rect.addActionListener(this);
        BarreTache.ellipse.addActionListener(this);
        menuBar.annuler.addActionListener(this);
        BarreTache.fill.addActionListener(this);
        menuBar.répéter.addActionListener(this);

    }

    @Override
    public void paintComponent(Graphics g) {

        taillex = (Integer) BarreTache.spinner.getValue();
        tailley = (Integer) BarreTache.spinner1.getValue();
        opacity = (Integer) BarreTache.spinner2.getValue();
        repaint();
        g2d = (Graphics2D) g;
        g.setColor(couleurs);
        g.fillRect(100, 45, 600, 410);
        g.setClip(100, 45, 600, 410);

        if (opacity != 0) {
            myOpacity = (opacity * 1.0) / 100;
            g2d.setComposite(AlphaComposite.
                    getInstance(AlphaComposite.SRC_OVER,
                            (float) myOpacity));
        }

        if (this.vider) {
            this.vider = false;
        } else {
            //On parcourt notre collection de points
            this.pointsD.stream().map((p) -> {
                //On récupère la couleur
                g.setColor(p.getColor());
                return p;
            }).forEachOrdered((p) -> {

                if (p.getOPacity() > 0) {
                    myOpacity = (p.getOPacity() * 1.0) / 100;
                    g2d.setComposite(AlphaComposite.
                            getInstance(AlphaComposite.SRC_OVER,
                                    (float) myOpacity));
                }
                if (p.getType().equals("CERCLE")) {
                    g.fillOval(p.getX(), p.getY(), p.getSizeX(), p.getSizeY());
                } else if (p.getType().equals("CARRE")) {
                    g.fillRect(p.getX(), p.getY(), p.getSizeX(), p.getSizeY());
                }
            });
        }
    }

//vider le contenu
    public void erase() {
        this.vider = true;
        this.pointsD = new ArrayList<>();
        repaint();
    }

    //Définit la forme du pointeur
    public void setPointerType(String str) {
        this.pointeurType = str;
    }

    /**
     * C'est ici que je fais toutes mes actions listerner
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == menuBar.vider
                || e.getSource() == BarreTache.clear) {
            this.vider = true;
            this.pointsD = new ArrayList<>();
            repaint();
        } else if (e.getSource() == BarreTache.black
                || e.getSource() == menuBar.menuItemBlack) {
            this.pointerColor = black;
        } else if (e.getSource() == BarreTache.red
                || e.getSource() == menuBar.menuItemRouge) {
            this.pointerColor = red;
            BarreTache.red.getModel().setSelected(true);
        } else if (e.getSource() == BarreTache.yellow
                || e.getSource() == menuBar.menuItemJaune) {
            this.pointerColor = yellow;
        } else if (e.getSource() == BarreTache.white
                || e.getSource() == menuBar.menuItemBlanc) {
            this.pointerColor = white;
            BarreTache.white.getModel().setSelected(true);
        } else if (e.getSource() == BarreTache.eraser
                || e.getSource() == menuBar.menuItemEfface) {
            this.pointerColor = couleurs;
        } else if (e.getSource() == BarreTache.green
                || e.getSource() == menuBar.menuItemVert) {
            this.pointerColor = green;
        } else if (e.getSource() == BarreTache.blue
                || e.getSource() == menuBar.menuItemBleu) {
            this.pointerColor = blue;
        } else if (e.getSource() == definir) {
            CreetJDialogue();
        } else if (e.getSource() == menuBar.propos) {
            JOptionPane.showMessageDialog(null, "       "
                    + "Ce programme à était dévéloppé par :"
                    + " Kevin Nelson \nÉtudiant de la "
                    + "technique en informatique en"
                    + " troisième année", " Network Security",
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == menuBar.propriete) {
            CreerJframe();
        } else if (e.getSource() == menuBar.menuItemRect
                || e.getSource() == BarreTache.rect) {
            this.pointeurType = "CARRE";

        } else if (e.getSource() == menuBar.menuItemEllipse
                || e.getSource() == BarreTache.ellipse) {
            this.pointeurType = "CERCLE";
        } else if (e.getSource() == menuBar.répéter) {

            try {
                while (pointsD1.size() > live1.get(live1.size() - 2)) {
                    pointsD.add(pointsD1.get(pointsD1.size() - 1));
                    pointsD1.remove(pointsD1.size() - 1);
                }
                Points t = pointsD.get(pointsD.size() - 1);
                live1.remove(live1.size() - 1);
                live.add(pointsD.size());
                repaint();
                pointsD.add(t);
            } catch (Exception E) {
                live1.clear();
                live1.add(0);
                JOptionPane.showMessageDialog(null, "    Aucun vestige "
                        + "trouvé ",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == menuBar.annuler) {
            try {

                while (pointsD.size() >= live.get(live.size() - 1)) {
                    pointsD1.add(pointsD.get(pointsD.size() - 1));
                    pointsD.remove(pointsD.size() - 1);
                }
                live.remove(live.size() - 1);
                live1.add(pointsD1.size());

                repaint();
            } catch (Exception E) {
                live.clear();
                JOptionPane.showMessageDialog(null, "Vous n'avez "
                        + "pas des points à annuler",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == BarreTache.fill
                || e.getSource() == menuBar.menuItemRemplissage) {
            this.pointsD = new ArrayList<>();
            couleurs = pointerColor;
            repaint();
        } else if (e.getSource() == menuBar.menuItemDefinir
                || e.getSource() == BarreTache.definir) {
            CreetJDialoguePinceau();
        }
//        else if (e.getSource() == menuBar.quitter) {
//            exit(0);
//        }
    }

    /**
     * Dans ce block de code, je crée un JDialogue qui va contenir mon jchooser
     * qui permet changer des couleurs. Le block contient aussi deux actons
     * listener qui permettent de valider ou d'annuler la modification faite.
     * Cette methode est void...
     */
    void CreetJDialogue() {

        JPanel pane = new JPanel();
        JDialog panneauCouleurs = new JDialog();
        panneauCouleurs.setTitle("Couleur du pinceau");
        panneauCouleurs.setLayout(new BorderLayout());
        panneauCouleurs.add(choixCouleur, BorderLayout.CENTER);
        pane.add(new JLabel(String.format("%58s", " ")));
        pane.add(new JLabel(String.format("%105s", " ")));
        pane.add(ok);
        ok.addActionListener((ActionEvent e) -> {
            g1 = img.getGraphics();
            g1.setColor(choixCouleur.getColor());
            g1.fillRect(0, 0, 35, 20);
            panneauCouleurs.dispose();
        });
        pane.add(anuller);
        anuller.addActionListener((ActionEvent e) -> {
            panneauCouleurs.dispose();
        });
        panneauCouleurs.add(pane, BorderLayout.SOUTH);
        panneauCouleurs.setLocationRelativeTo(null);
        panneauCouleurs.setSize(660, 370);
        panneauCouleurs.setResizable(false);
        panneauCouleurs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panneauCouleurs.setVisible(true);

    }

    /**
     * Dans ce block de code, je crée un JDialogue2 qui va contenir mon jchooser
     * qui permet changer des couleurs. Le block contient aussi deux actons
     * listener qui permettent de valider ou d'annuler la modification faite.
     * Cette methode est void...
     */
    void CreetJDialoguePinceau() {
        JPanel pane = new JPanel();
        JDialog panneauCouleurs = new JDialog();
        panneauCouleurs.setTitle("Couleur du pinceau");
        panneauCouleurs.setLayout(new BorderLayout());
        panneauCouleurs.add(choixCouleur, BorderLayout.CENTER);
        pane.add(new JLabel(String.format("%58s", " ")));
        pane.add(new JLabel(String.format("%105s", " ")));
        pane.add(ok);
        ok.addActionListener((ActionEvent e) -> {
            this.pointerColor = choixCouleur.getColor();
            panneauCouleurs.dispose();
        });
        pane.add(anuller);
        anuller.addActionListener((ActionEvent e) -> {
            panneauCouleurs.dispose();
        });
        panneauCouleurs.add(pane, BorderLayout.SOUTH);
        panneauCouleurs.setLocationRelativeTo(null);
        panneauCouleurs.setSize(660, 370);
        panneauCouleurs.setResizable(false);
        panneauCouleurs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panneauCouleurs.setVisible(true);

    }

    /**
     * Dans ce block, je crée un JFrame qui permet pour afficher la propriété.
     * Le block contient aussi deux actons listener qui permettent de valider ou
     * d'annuler la modification faite. Cette methode est void...
     */
    private void CreerJframe() {
        JPanel cellule1 = new JPanel(), cellule2 = new JPanel(),
                cellule3 = new JPanel(), cellule4 = new JPanel();
        /// Les spinner et
        JSpinner spinner1 = new JSpinner(
                new SpinnerNumberModel(20, 0, 50, 1));
        JSpinner spinner2 = new JSpinner(
                new SpinnerNumberModel(20, 0, 20, 1));
        JSpinner spinner3 = new JSpinner(
                new SpinnerNumberModel(255, 0, 400, 5));

        JDialog proprieteDoc = new JDialog();
        proprieteDoc.setTitle("Propriété du document");
        JPanel pan = new JPanel(), alignement = new JPanel(),
                tail = new JPanel(), arriere = new JPanel();

        // Création du panel tail qui se met dans la pan
        tail.setPreferredSize(new Dimension(152, 100));
        tail.setBorder(BorderFactory.createTitledBorder("Taille"));
        tail.add(new JLabel("Largeur: "));
        tail.add(spinner1);
        tail.add(new JLabel("Hauteur: "));
        tail.add(spinner2);

        // Création du panel arriere qui se met dans la pan
        arriere.setPreferredSize(new Dimension(152, 100));
        arriere.setBorder(BorderFactory.createTitledBorder("Arriére-plan"));
        definir.setIcon(new ImageIcon(img));
        arriere.add(definir);
        arriere.add(new JLabel("    Opacité: "));
        arriere.add(spinner3);
        cellule1.add(bouton1);
        cellule1.setPreferredSize(new Dimension(50, 40));
        cellule2.add(bouton4);
        cellule2.setPreferredSize(new Dimension(50, 40));
        cellule3.add(bouton2);
        cellule3.setPreferredSize(new Dimension(50, 40));
        cellule4.add(bouton3);
        cellule4.setPreferredSize(new Dimension(50, 40));
        alignement.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        alignement.add(cellule1, gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        alignement.add(cellule2, gbc);
        gbc.gridx = 2;
        gbc.gridy = 4;
        alignement.add(cellule3, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        alignement.add(cellule4, gbc);
        alignement.setPreferredSize(new Dimension(310, 160));
        alignement.setBorder(BorderFactory.createTitledBorder("Alignement"));
        proprieteDoc.setLocation(800, 400);
        proprieteDoc.setSize(360, 350);
        proprieteDoc.setContentPane(pan);
        pan.add(tail);
        pan.add(arriere);
        pan.add(alignement);
        pan.setPreferredSize(new Dimension(220, 60));
        pan.add(new JLabel(String.format("%58s", " ")));
        pan.add(ok1);
        ok1.addActionListener((ActionEvent e) -> {
            couleurs = choixCouleur.getColor();
            erase();
            proprieteDoc.dispose();
        });
        pan.add(anuller1);
        anuller1.addActionListener((ActionEvent e) -> {
            proprieteDoc.dispose();
        });
        proprieteDoc.setVisible(true);
    }

}
