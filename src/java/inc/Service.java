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
            }catch(SQLException e){
                throw e;
            }
        }
        
        public void closeConnection(Connection connection) {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public void insertStyle(Connection c, String style) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO style (style) values (?)";
            try {
                 pst = c.prepareStatement(sql);
                pst.setString(1, style);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
             finally {
                if (pst != null) {
                    pst.close();
            }
        }
        }

        public void insertMateriel(Connection c, String m) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO Materiaux (materiel) values (?)";
            try {
                 pst = c.prepareStatement(sql);
                pst.setString(1, m);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
             finally {
                if (pst != null) {
                    pst.close();
            }
        }
        }
            
    public List<Materiel> getAllMateriel() throws Exception {
        List<Materiel> materiels = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM materiaux";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Materiel produit = new Materiel();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    produit.setIdMateriel(resultSet.getInt("idMateriel"));
                    produit.setMateriel(resultSet.getString("materiel"));
                    produit.setIdStyle(resultSet.getInt("idStyle"));
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
        finally {
            closeConnection(con); // Close the connection in the finally block
        }

        return materiels;
    }

    public List<Style> getAllStyle() throws Exception {
        List<Style> styles = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT * FROM style";
            try (PreparedStatement statement = con.prepareStatement(sql);
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
        }finally{
            closeConnection(con);
        }

        return styles;
    }
    
}
