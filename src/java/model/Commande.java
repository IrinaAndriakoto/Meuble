/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author tonny
 */
public class Commande {
    int idCommande;
    int nbCommande;
    int idCategorie;
    int idStyle;
    int idTaille;
    
    
    
   

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getNbCommande() {
        return nbCommande;
    }

    public void setNbCommande(int nbCommande) {
        this.nbCommande = nbCommande;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public int getIdTaille() {
        return idTaille;
    }

    public void setIdTaille(int idTaille) {
        this.idTaille = idTaille;
    }
    
    
}
