/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inc;

/**
 *
 * @author Irina
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class Service {
    
        public Connection getConnection() throws Exception{
        Connection c = null;
        String conn = "jdbc:postgresql://localhost:5432/meuble";
       
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(conn, "postgres", "irina");
            return c;
        }catch(Exception e){
            throw e;
        }
    }
        public static void insertStyle(Connection c , Style s) throws Exception {
            String sql = "INSERT INTO Style (style) values (?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, s.getStyle());
            pst.executeUpdate();
        }
            
        public static void insertMateriel(Connection c , Materiel m) throws Exception {
        String sql = "INSERT INTO Materiel (materiel) values (?)";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, m.getMateriel());
        pst.executeUpdate();
    }
            
    public List<Materiel> getAllMateriel() throws Exception {
        List<Materiel> materiels = new ArrayList<>();
        try(Connection connection = getConnection()) {
            String sql = "SELECT * FROM materiel";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Materiel produit = new Materiel();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    produit.setIdMateriel(resultSet.getInt("idMateriel"));
                    produit.setMateriel(resultSet.getString("matricule"));
                    produit.setIdStyle(resultSet.getInt("idStyles"));
                // Ajoutez d'autres propriétés en fonction de votre modèle de données
                    materiels.add(produit);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                throw e;
            }
        } catch (Exception e) {
            throw e; // Gérez les exceptions de manière appropriée dans votre application
        }

        return materiels;
    }

    public List<Style> getAllStyle() throws Exception {
        List<Style> styles = new ArrayList<>();
        try(Connection connection = getConnection()) {
            String sql = "SELECT * FROM style";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Style style = new Style();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    style.setIdStyle(resultSet.getInt("idStyle"));
                    style.setStyle(resultSet.getString("style"));
                // Ajoutez d'autres propriétés en fonction de votre modèle de données
                    styles.add(style);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                throw e;
            }
        } catch (Exception e) {
            throw e; // Gérez les exceptions de manière appropriée dans votre application
        }

        return styles;
    }
    
}
