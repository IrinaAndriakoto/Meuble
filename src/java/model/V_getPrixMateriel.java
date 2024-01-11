/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Irina
 */
public class V_getPrixMateriel {
//    private int idPrixMateriel;
    private String nomCategorie;
    private String nomStyle;
    private String taille;
    private Double prix;

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public String getNomStyle() {
        return nomStyle;
    }

    public void setNomStyle(String nomStyle) {
        this.nomStyle = nomStyle;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    
}
