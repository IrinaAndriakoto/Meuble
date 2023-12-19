/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Irina
 */
public class Materiel {
    private int idMateriel;
    private String Materiel;
    private int quantitePetit;
    private int quantiteGrand;

    public int getQuantitePetit() {
        return quantitePetit;
    }

    public void setQuantitePetit(int quantitePetit) {
        this.quantitePetit = quantitePetit;
    }

    public int getQuantiteGrand() {
        return quantiteGrand;
    }

    public void setQuantiteGrand(int quantiteGrand) {
        this.quantiteGrand = quantiteGrand;
    }
    
    
    
    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getMateriel() {
        return Materiel;
    }

    public void setMateriel(String Materiel) {
        this.Materiel = Materiel;
    }
}
