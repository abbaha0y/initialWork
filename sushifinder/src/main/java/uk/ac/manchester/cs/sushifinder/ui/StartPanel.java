/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author machdd
 */
public class StartPanel extends JPanel {
    JLabel fileLabel;
    final ButtonGroup radioButtonGroup = new ButtonGroup();
    final JFileChooser fc = new JFileChooser();
    JRadioButton radioBtnUrl, radioBtnFile;
    JTextField txtUrl, txtFile;
    JPanel northPanel, centerPanel, southPanel;
    
    public StartPanel(){
        northPanel = new JPanel(new BorderLayout());
        centerPanel = new JPanel(new FlowLayout());
        southPanel = new JPanel(new BorderLayout());
        
        fileLabel = new JLabel();
        fileLabel.setText("Please enter the ontology location:");
        
        radioBtnUrl = new JRadioButton("URL");
        radioBtnFile = new JRadioButton("File");
        radioButtonGroup.add(radioBtnUrl);
        radioButtonGroup.add(radioBtnFile);
        
        txtUrl = new JTextField(25);
        txtFile = new JTextField(25);
        
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());
        
        northPanel.add(BorderLayout.CENTER,fileLabel);
        centerPanel.add(radioBtnUrl);
        centerPanel.add(txtUrl);
        centerPanel.add(radioBtnFile);
        centerPanel.add(txtFile);
        
        this.add(BorderLayout.NORTH, northPanel);
        this.add(BorderLayout.CENTER, centerPanel);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //this.setSize(400, 300);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
