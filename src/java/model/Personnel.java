/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Irina
 */
public class Personnel {
    private int idPersonnel;
    private String nom;
    private Date dateDeNaissance;
    private Date dateEmbauche;
    private int idmetier;
    private int idposte;

    public int getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(int idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public int getIdmetier() {
        return idmetier;
    }

    public void setIdmetier(int idmetier) {
        this.idmetier = idmetier;
    }

    public int getIdposte() {
        return idposte;
    }

    public void setIdposte(int idposte) {
        this.idposte = idposte;
    }
    
    
}
