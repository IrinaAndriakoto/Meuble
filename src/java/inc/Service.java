/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inc;

/**
 *
 * @author Irina
 */
import static java.lang.Integer.parseInt;
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
//                pst.setInt(2,parseInt(idStyle));
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
        
        public void InsertStyleMateriel(Connection c,String idStyle,String idMateriel) throws Exception{
//            Connection con = null;
            PreparedStatement pst = null;
            String sql = "insert into stylemateriel(idStyle,idMateriel) values(?,?) ";
            try{
                pst = c.prepareStatement(sql);
                pst.setInt(1,parseInt(idStyle));
                pst.setInt(2,parseInt(idMateriel));
                pst.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                throw e;                
            }finally{
                closeConnection(c);
            }
        }
        
        public void insertCategorie(Connection con , String cat) throws Exception {
//                        Connection con = null;
            PreparedStatement pst = null;
            String sql = "insert into categorie(categorie) values(?) ";
            try{
                pst = con.prepareStatement(sql);
                pst.setString(1,cat);
//                pst.setInt(2,parseInt(idMateriel));
                pst.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                throw e;                
            }finally{
                closeConnection(con);
            }
        }
        public List<Taille> getAllTaille() throws Exception {
        List<Taille> tailles = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT * FROM Taille";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Taille taille = new Taille();
                    
                    taille.setIdTaille(resultSet.getInt("idTaille"));
                    taille.setTaille(resultSet.getString("taille"));
                    
                    tailles.add(taille);
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

        return tailles;
    }
    
    public List<Categorie> getAllCategorie() throws Exception {
        List<Categorie> categs = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT * FROM Categorie";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Categorie categ = new Categorie();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    categ.setIdCategorie(resultSet.getInt("idCategorie"));
                    categ.setCategorie(resultSet.getString("categorie"));
                // Ajoutez d'autres propriétés en fonction de votre modèle de données
                    categs.add(categ);
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

        return categs;
    }
    
    public void insertTaille(Connection c, String t) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO Taille (taille) values (?)";
            try {
                 pst = c.prepareStatement(sql);
               
                pst.setString(1, t);
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
    
    public void insertStock(Connection c, String qte,String idmat) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO stock (quantitestock,idmateriel) values (?,?)";
            try {
                 pst = c.prepareStatement(sql);
               
                pst.setInt(1, parseInt(qte));
                pst.setInt(2, parseInt(idmat));
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
    
    public void insertQuantiteMateriel(Connection co,String idCategorie,String idMatr ,String idTaille , String idStyle , String qte) throws Exception{
        try{
            String sql="insert into quantitemateriel(quantite,idtaille,idcategorie,idmateriel,idstyle) values(?,?,?,?,?) ";
            PreparedStatement pst = co.prepareStatement(sql);
            pst.setInt(1,parseInt(qte));
            pst.setInt(2,parseInt(idTaille));
            pst.setInt(3,parseInt(idCategorie));
            pst.setInt(4,parseInt(idMatr));
            pst.setInt(5,parseInt(idStyle));
            
            pst.executeUpdate();
        }catch(SQLException e){
            throw e;
        }finally{
            closeConnection(co);
        }
    }
        
        public List<V_getStyleMateriel> getMaterielByStyle(String idStyle) throws Exception
        {
           Connection con =null;
           List<V_getStyleMateriel> sm = new ArrayList<>();

           try{
               con=getConnection();
               String sql ="select style,materiel from v_getstylemateriel where idstyle=?";
               try{
                   PreparedStatement stat = con.prepareStatement(sql);
                   stat.setInt(1,parseInt(idStyle));
                   ResultSet res = stat.executeQuery();
                   
                   while(res.next()) {
                       V_getStyleMateriel mt = new V_getStyleMateriel();
                        mt.setMateriel(res.getString("materiel"));
                        mt.setStyle(res.getString("style"));
//                        materiel.setIdStyle(res.getInt("idStyle"));
                        // Ajoutez d'autres propriétés en fonction de votre modèle de données
                        
                        sm.add(mt);
                   }
               }
               catch(SQLException e){
                   e.printStackTrace();
                   throw e;
               }
           }finally {
        if (con != null) {
            con.close();
        }
    }
        return sm;   
    }
        
            public List<V_getquantitemateriel> getAllQuantite() throws Exception {
        List<V_getquantitemateriel> qte = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM v_getquantite order by categorie,style";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    V_getquantitemateriel produit = new V_getquantitemateriel();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    produit.setQuantite(resultSet.getInt("quantite"));
                    produit.setTaille(resultSet.getString("taille"));
                    produit.setCategorie(resultSet.getString("categorie"));
                    produit.setMateriaux(resultSet.getString("materiel"));
                    produit.setStyle(resultSet.getString("style"));
//                    produit.setIdStyle(resultSet.getInt("idStyle"));
                // Ajoutez d'autres propriétés en fonction de votre modèle de données
                    qte.add(produit);
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

        return qte;
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
//                    produit.setIdStyle(resultSet.getInt("idStyle"));
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
    public List<V_getPrixMateriel> getAllMeubleByPrix(String prixMin , String prixMax) throws Exception {
        List<V_getPrixMateriel> prix = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM v_getprixmateriel where prix>"+prixMin+" and prix<"+prixMax+" ";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    V_getPrixMateriel produit = new V_getPrixMateriel();
                    
//                    produit.setIdMeuble(resultSet.getString("idmeuble"));
                    produit.setNomCategorie(resultSet.getString("nomcategorie"));
                    produit.setTaille(resultSet.getString("taille"));
                    produit.setNomStyle(resultSet.getString("nomstyle"));
                    produit.setPrix(resultSet.getDouble("prix"));
//                    produit.setMateriel(resultSet.getString("materiel"));
                    prix.add(produit);
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

        return prix;
    }
    
        public void insertCommande(Connection con,String nb,String idcat,String idstyle,String idtaille) throws Exception {
        PreparedStatement pst = null;
            String sql = "insert into commande(nbCommande,idCategorie , idStyle , idTaille) values(?,?,?,?) ";
            try{
                pst = con.prepareStatement(sql);
                pst.setInt(1,parseInt(nb));
                pst.setInt(2,parseInt(idcat));
                pst.setInt(3,parseInt(idstyle));
                pst.setInt(4,parseInt(idtaille));
                
                pst.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
                throw e;                
            }finally{
                con.close();
            }
    }
        public List<V_getCommande> getAllCommande() throws Exception {
        List<V_getCommande> commandes = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM v_getCommande";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    V_getCommande produit = new V_getCommande();
                    
                    produit.setIdCommande(resultSet.getString("idcommande"));
                    produit.setNbCommande(resultSet.getInt("nbCommande"));
                    produit.setTaille(resultSet.getString("taille"));
                    produit.setStyle(resultSet.getString("style"));
                    produit.setCategorie(resultSet.getString("categorie"));
                    commandes.add(produit);
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

        return commandes;
    }
        
        public void valider(Connection c, String idcomm , boolean isValid , String idQuantite) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO validation (idcommande , isValid , idQuantite ) values (? , 1 , ?)";
            try {
                 pst = c.prepareStatement(sql);
               
                pst.setInt(1, parseInt(idcomm));
                pst.setBoolean(2, isValid);
                pst.setInt(3, parseInt(idQuantite));
                
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
}
