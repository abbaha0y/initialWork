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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hani Al Abbas - hani.alabbas@postgrad.manchester.ac.uk
 */
public class URLFrame extends JFrame implements ActionListener{
    String url;
    JButton okBtn, cancelBtn;
    JTextField urlTxt;
    JLabel URLLbl;
    
    JPanel BtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel txtPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    public URLFrame(){
        this.setSize(400, 100);
        this.setResizable(false);
        this.setTitle("URL...");
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        
        okBtn = new JButton("OK");
        //okBtn.setEnabled(false);
        cancelBtn = new JButton("Cancel");
        okBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        
        urlTxt = new JTextField("http://", 25);
        
        URLLbl = new JLabel("URL: ");
       
        BtnPanel.add(okBtn);
        BtnPanel.add(cancelBtn);
        
        txtPanel.add(URLLbl);
        txtPanel.add(urlTxt);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(BtnPanel, BorderLayout.SOUTH);
        this.getContentPane().add(txtPanel, BorderLayout.CENTER);
    }
    
    public String getURL(){
        return url;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == cancelBtn){
            dispose();
        }
        else if(e.getSource() == okBtn){
            if(!urlTxt.getText().endsWith("http://")){
                //do something then depose()
            }
            else{
                
            }
        }
        /*else if(e.getSource() ==  urlTxt){
            okBtn.setEnabled(true);
            url = urlTxt.getText();
        }*/
    }
}
