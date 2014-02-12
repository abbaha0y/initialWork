/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassExpression;
import uk.ac.manchester.cs.sushifinder.model.SushiOntology;

/**
 *
 * @author machdd
 */
public class IngredientsPanel extends JPanel {
    private JTree ingredientsTree;
    private JScrollPane scrollPane;
    
    private SushiOntology ontology;

    public IngredientsPanel(){
        /*this.setLayout(new BorderLayout());
        ingredientsTree = new JTree();
        scrollPane = new JScrollPane();
	//scrollPane.getViewport().add(ingredientsTree);
        this.add(scrollPane, BorderLayout.CENTER);*/
        setupUI();
    }
    
    public IngredientsPanel(SushiOntology o){
        /*this.setLayout(new BorderLayout());
        ingredientsTree = new JTree();
        scrollPane = new JScrollPane();
	//scrollPane.getViewport().add(ingredientsTree);
        this.add(scrollPane, BorderLayout.CENTER);*/
        this.ontology = o;
        setupUI();
    }
    
    public void setupUI(){
        this.setLayout(new BorderLayout());
        ingredientsTree = new JTree();
        scrollPane = new JScrollPane();
	//scrollPane.getViewport().add(ingredientsTree);
        this.add(scrollPane, BorderLayout.CENTER);
    }
    
    public void populateIngredientsTree(){
        scrollPane.getViewport().add(ingredientsTree);
        
        MutableTreeNode rootNode = new DefaultMutableTreeNode("Ingredients");
        for (OWLClassExpression owlClassExpression : ontology.getSushiIngredientsCategories()) {
            OWLClass cls = (OWLClass) owlClassExpression;
            //addClsToTree(cls, rootNode);
        }
    }
}
