/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Hani Al Abbas - hani.alabbas@postgrad.manchester.ac.uk
 */
public class BannerPanel extends JPanel{
    Image logo;
    
    public BannerPanel(){
        URL url = getClass().getResource("/Bannermodified.png");
        ImageIcon icon = new ImageIcon(url);
	logo = icon.getImage();
        setBorder(BorderFactory.createEmptyBorder(7, 7, 0, 0));
        this.setSize(800, 130);
    }
    
    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(logo, 0, 0, this);
	}
}
