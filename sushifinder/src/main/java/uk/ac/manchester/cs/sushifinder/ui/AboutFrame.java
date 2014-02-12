/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author machdd
 */
public class AboutFrame extends JFrame implements ActionListener{
    
    JButton okBtn;
    JPanel buttonPanel;
    public AboutFrame()
    {
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        okBtn = new JButton("OK");
        okBtn.addActionListener(this);
        this.setTitle("About - the Manchester Sushi Finder");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        buttonPanel.add(okBtn);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        //this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == okBtn){
            dispose();
        }
    }
}
