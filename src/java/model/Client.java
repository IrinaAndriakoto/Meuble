/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Irina
 */
public class Client {
    private int idClient;
    private String nomClient;
//    private Date dateDeNaissance;
    private String genre;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

//    public Date getDateDeNaissance() {
//        return dateDeNaissance;
//    }
//
//    public void setDateDeNaissance(Date dateDeNaissance) {
//        this.dateDeNaissance = dateDeNaissance;
//    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    
}
