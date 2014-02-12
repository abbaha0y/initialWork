/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import org.semanticweb.owlapi.model.OWLOntology;
import uk.ac.manchester.cs.sushifinder.model.SushiOntology;

/**
 *
 * @author machdd
 */
public class SushiApplication extends JFrame implements ActionListener{
    
    //Variables
    int choice;
    File chosenFile;
    JMenuBar menuBar = new JMenuBar();
    JMenu menuFile, importOntology;
    JMenuItem URL, fromComputer, about, exit;
    JFileChooser chooser;
    BannerPanel bannerPanel;
    JPanel mainPanel;
    JSplitPane firstPane, secondPane;
    IngredientsPanel panelLeft;
    //Variables
    
    SushiApplication(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        //this.setVisible(true);
        setupMenuBar();
        setupPanels();
    }
    
    private void setupMenuBar(){
	menuFile = new JMenu("File");
        
        importOntology = new JMenu("Import an ontology");
        URL = new JMenuItem("From URL");
        URL.addActionListener(this);
        fromComputer = new JMenuItem("From Computer");
        //fromComputer.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.Event.CTRL_MASK));
        fromComputer.addActionListener(this);
        importOntology.add(fromComputer);
        importOntology.add(URL);
        menuFile.add(importOntology);
        about = new JMenuItem("About");
        about.addActionListener(this);
        menuFile.add(about);
        menuFile.addSeparator();
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        menuFile.add(exit);
        menuBar.add(menuFile);
        this.setJMenuBar(menuBar);
    }
    
    private void setupPanels(){
        BannerPanel topPanel= new BannerPanel();
        
        JPanel buttomPanel= new JPanel();
        JButton buttom = new JButton("Buttom");
        panelLeft = new IngredientsPanel();
        JButton buttomRight = new JButton("ButtomRight");
        //buttomPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        buttomPanel.add(buttom);
        
        
        JSplitPane hSp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft,buttomRight);
        hSp.setDividerLocation(200);
        hSp.setEnabled(false);
        //buttomPanel.add(hSp);
        JSplitPane vSp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel,hSp);
        //buttomPanel.add(vSp);
        vSp.setDividerLocation(130);
        vSp.setEnabled(false);
        mainPanel = new JPanel();
        
        
        
        //setup the main panels ends
        //this.getContentPane().setLayout(new BorderLayout());
        //bannerPanel = new BannerPanel();
        //mainPanel = new MainPanel();
        //mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        //this.getContentPane().add(bannerPanel,BorderLayout.NORTH );
        //this.getContentPane().add(mainPanel,BorderLayout.CENTER );
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(vSp,BorderLayout.CENTER );
        this.getContentPane().setLayout(new CardLayout());
        this.getContentPane().add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fromComputer){
            chooser= new JFileChooser();
            chooser.setMultiSelectionEnabled(false);
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.addChoosableFileFilter(new OntologeMyFilter());
            choice = chooser.showOpenDialog(null);
            //System.out.println(choice);
            if (choice == JFileChooser.APPROVE_OPTION){
                chosenFile = chooser.getSelectedFile();
                System.out.println(chosenFile.getName());
            }
            //panelLeft.populateIngredientsTree();
            SushiOntology o = new SushiOntology(chosenFile);
            //OWLOntology sushiOntology = o.getSushiOntology();
        }
        else if(e.getSource() == URL){
            URLFrame URLframe = new URLFrame();
            URLframe.setVisible(true);
        }
        else if(e.getSource() == about)
        {
            AboutFrame aboutFrame = new AboutFrame();
            aboutFrame.setVisible(true);
        }
        else if(e.getSource() == exit)
        {
            System.exit(0);
        }
    }
    
    public static void main(String [] args){
	System.out.println("Starting app...");
	SushiApplication frame = new SushiApplication();
	System.out.println("...created sushi app.");
        //StartPanel SPanel = new StartPanel();
        //SPanel.setBounds((frame.getSize().width-SPanel.getWidth())/2, (frame.getSize().height-SPanel.getHeight())/2, 400, 300);
        //frame.getContentPane().add(SPanel);
        frame.setVisible(true);
        
        
        


    }
}
