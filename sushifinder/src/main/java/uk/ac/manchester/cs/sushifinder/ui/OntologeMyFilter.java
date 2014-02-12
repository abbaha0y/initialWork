/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.ui;

import java.io.File;

/**
 *
 * @author Hani Al Abbas - hani.alabbas@postgrad.manchester.ac.uk
 */
public class OntologeMyFilter extends javax.swing.filechooser.FileFilter{
    public boolean accept(File file){
        String filename = file.getName();
        return filename.endsWith(".owl");
}

    public String getDescription(){
        return "*.owl";
    }
}
