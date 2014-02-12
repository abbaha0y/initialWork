/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.manchester.cs.sushifinder.model;

import java.io.File;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.model.OWLClass;

/**
 *
 * @author Hani Al Abbas - hani.alabbas@postgrad.manchester.ac.uk
 */
public class SushiOntology {
    private OWLReasoner reasoner;
    private OWLOntology ontology;
    private OWLDataFactory df;
    private OWLOntologyManager manager;
    private File oFile;
    private IRI iri;
    
    public SushiOntology(File ontologyFile){
        oFile = ontologyFile;
        manager = OWLManager.createOWLOntologyManager();
        importOntologyLocal();
        runReasoner();
    }
    
    public SushiOntology(String iri){
        this.iri = IRI.create(iri);
        manager = OWLManager.createOWLOntologyManager();
    }
    
    public void importOntologyLocal(){
        try {
            ontology = manager.loadOntologyFromOntologyDocument(oFile);
        } catch (OWLOntologyCreationException ex) {
            Logger.getLogger(SushiOntology.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void importOntologyNet(){
        try {
            ontology = manager.loadOntologyFromOntologyDocument(iri);
        } catch (OWLOntologyCreationException ex) {
            Logger.getLogger(SushiOntology.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public OWLOntology getSushiOntology(){
        return ontology;
    }
    
    protected void runReasoner(){
        try {
            //replaced with hermit reasoner
            OWLReasonerFactory factory = new Reasoner.ReasonerFactory();
            reasoner = factory.createReasoner(ontology);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "A reasoner error has ocurred.\n" +
                            "[" + e.getMessage() + "]",
                    "Reasoner Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Collection<OWLClass> getSushiIngredientsCategories() {
        OWLClass toppingCls = df.getOWLClass(PREFERENCES.getPizzaToppingClassName());
        return reasoner.getSubClasses(toppingCls, true).getFlattened();
    }
}
