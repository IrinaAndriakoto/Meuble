/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Irina
 */
public class V_getStyleMateriel {
    private int idV_Stylemateriel;
    private int idStyle;
    private String style;
    private String materiel;

    public int getIdStyle(){
        return idStyle;
    }
    public void setIdStyle(int st){
        this.idStyle=st;
    }
    public int getIdV_Stylemateriel() {
        return idV_Stylemateriel;
    }

    public void setIdV_Stylemateriel(int idV_Stylemateriel) {
        this.idV_Stylemateriel = idV_Stylemateriel;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }
    
    
}
