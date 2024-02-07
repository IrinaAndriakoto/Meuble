/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inc;

/**
 *
 * @author Irina
 */
import exception.InsufficientMaterialsException;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
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

        public void insertMateriel(Connection c, String m,String pu) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO Materiaux (materiel,pu) values (?,?)";
            try {
                 pst = c.prepareStatement(sql);
               
                pst.setString(1, m);
                pst.setInt(2,parseInt(pu));
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
            String sql = "INSERT INTO stock (quantitestock,idmateriel) values (?,?)  on conflict (idmateriel) do update set quantitestock=stock.quantitestock + EXCLUDED.quantitestock;";
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
    
    public void insertHistoriqueStock(Connection co,String idm,String qte,Date date,boolean entree,boolean sortie) throws Exception{
        
        PreparedStatement pst = null;
        co=getConnection();
        String sql="insert into historiquestock(idmateriel,quantite,date,entree,sortie) values(?,?,?,?,?)";
        try{
            pst=co.prepareStatement(sql);
            pst.setInt(1,parseInt(idm));
            pst.setInt(2,parseInt(qte));
            pst.setDate(3, date);
            pst.setBoolean(4,entree);
            pst.setBoolean(5,sortie);
            pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
                     finally {
                if (pst != null) {
                    pst.close();
            }
        
    }
    }
    public void insertQuantiteMateriel(Connection co,String idCategorie,String idMatr ,String idTaille , String idStyle , String qte,String duree,String nb) throws Exception{
        try{
            String sql="insert into quantitemateriel(quantite,idtaille,idcategorie,idmateriel,idstyle,dureefabrication,nbemploye) values(?,?,?,?,?,?,?) ";
            PreparedStatement pst = co.prepareStatement(sql);
            pst.setInt(1,parseInt(qte));
            pst.setInt(2,parseInt(idTaille));
            pst.setInt(3,parseInt(idCategorie));
            pst.setInt(4,parseInt(idMatr));
            pst.setInt(5,parseInt(idStyle));
            pst.setInt(6, parseInt(duree));
            pst.setInt(7,parseInt(nb));
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
    
//    public void test(Connection con,String nb,String idcat,String idstyle,String)
    
        public void insertCommande(Connection con,String nb,String idcat,String idstyle,String idtaille,String idclient) throws Exception {
        PreparedStatement pst = null;
            String sql = "insert into commande(nbCommande,idCategorie , idStyle , idTaille,idclient) values(?,?,?,?,?) ";
            try{
                
                            // Vérifier la disponibilité des matériaux dans le stock
//            if (!checkMaterialsAvailability(con, idstyle,nb)) {
//                throw new InsufficientMaterialsException("Il n'y a pas assez de matériaux disponibles.");
//            }
            
                pst = con.prepareStatement(sql);
                pst.setInt(1,parseInt(nb));
                pst.setInt(2,parseInt(idcat));
                pst.setInt(3,parseInt(idstyle));
                pst.setInt(4,parseInt(idtaille));
                pst.setInt(5,parseInt(idclient));
                pst.executeUpdate();
                
//                ResultSet generatedKeys = pst.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    int orderId = generatedKeys.getInt(1);
//
//                    // Étapes 2, 3 et 4 : Récupérez les informations et mettez à jour le stock
//                    ockAfterCommande(con, orderId);
//                } else {
//                    throw new SQLException("Échec de récupération de l'ID de commande généré.");
//                }
            }
         catch (SQLException e) {
            throw e;
        }finally{
                con.close();
            }
    }
    
    public void updateStockAfterCommande(Connection connection, int orderId) throws SQLException {
        // ... code précédent pour récupérer les informations et mettre à jour le stock ...
        String selectCommandeInfo = "SELECT idstyle, idcategorie, idtaille FROM commande WHERE idcommande = ?";
        PreparedStatement selectCommandeInfoStmt = connection.prepareStatement(selectCommandeInfo);
        selectCommandeInfoStmt.setInt(1, orderId);
        ResultSet commandeInfoResult = selectCommandeInfoStmt.executeQuery();

        if (commandeInfoResult.next()) {
            int idStyle = commandeInfoResult.getInt("idstyle");
            int idCategorie = commandeInfoResult.getInt("idcategorie");
            int idTaille = commandeInfoResult.getInt("idtaille");

            // Étape 3 : Obtenez les quantités nécessaires de chaque matériau à partir de la table quantitemateriel
            String selectQuantiteMateriel = "SELECT idmateriel, quantite FROM quantitemateriel WHERE idstyle = ? AND idcategorie = ? AND idtaille = ?";
            PreparedStatement selectQuantiteMaterielStmt = connection.prepareStatement(selectQuantiteMateriel);
            selectQuantiteMaterielStmt.setInt(1, idStyle);
            selectQuantiteMaterielStmt.setInt(2, idCategorie);
            selectQuantiteMaterielStmt.setInt(3, idTaille);
            ResultSet quantiteMaterielResult = selectQuantiteMaterielStmt.executeQuery();

            // Étape 4 : Soustrayez ces quantités du stock actuel dans la table stock
            String updateStock = "UPDATE stock SET quantite = quantite - ? WHERE idmateriel = ?";
            PreparedStatement updateStockStmt = connection.prepareStatement(updateStock);

            while (quantiteMaterielResult.next()) {
                int idMateriel = quantiteMaterielResult.getInt("idmateriel");
                int quantite = quantiteMaterielResult.getInt("quantite");

                updateStockStmt.setInt(1, quantite);
                updateStockStmt.setInt(2, idMateriel);
                updateStockStmt.executeUpdate();
    }
}
    }
 private boolean checkMaterialsAvailability(Connection connection, String id,String nb) throws SQLException {
        // Implémentez la logique pour vérifier la disponibilité des matériaux dans le stock
        // Retournez true si suffisamment de matériaux sont disponibles, sinon false

        // Exemple de requête SQL pour vérifier la disponibilité du matériau pour un style donné :
    String checkAvailabilityQuery = "SELECT COUNT(*) FROM quantitemateriel qm " +
                                     "WHERE qm.idstyle = ? AND qm.quantite <= (SELECT quantite FROM stock WHERE idmateriel = qm.idmateriel)";
        try (PreparedStatement checkAvailabilityStmt = connection.prepareStatement(checkAvailabilityQuery)) {
            checkAvailabilityStmt.setInt(1,parseInt( id));
            checkAvailabilityStmt.setInt(2, parseInt(nb));
            ResultSet resultSet = checkAvailabilityStmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            return count > 0;
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
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
        
        
    public List<Poste> getAllPost() throws Exception{
        List<Poste> post = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT * FROM poste";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Poste p = new Poste();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    p.setIdPoste(resultSet.getInt("idPoste"));
                    p.setPoste(resultSet.getString("poste"));
                    p.setSalaireparheure(resultSet.getInt("salaireparheure"));
                // Ajoutez d'autres propriétés en fonction de votre modèle de données
                    post.add(p);
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

        return post;
    }
    public void insertPersonnel(Connection c,String nom,Date dtn,Date demb,String idp) throws Exception {
        PreparedStatement pst = null;
        String sql="insert into personnel(nompersonnel,datedenaissance,dateembauche,idmetier,idposte) values(?,?,?,1,?)";
        
        try{
            pst=c.prepareStatement(sql);
            
            pst.setString(1,nom);
            pst.setDate(2, dtn);
            pst.setDate(3,demb);
            pst.setInt(4,parseInt(idp));
            pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    
    public void insertMetier(Connection c,String metier,int coeff) throws Exception {
        PreparedStatement pst = null;
        String sql="insert into metier(metier,coeff) values(?,?)";
        
        try{
            pst=c.prepareStatement(sql);
            
            pst.setString(1,metier);
//            pst.setInt(2, /sph);
            pst.setInt(2,coeff);
            pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    
        public void insertPoste(Connection c,String poste,String sal) throws Exception {
        PreparedStatement pst = null;
        String sql="insert into poste(poste,salaireparheure) values(?,?)";
        
        try{
            pst=c.prepareStatement(sql);
            
            pst.setString(1,poste);
//            pst.setInt(2, /sph);
            pst.setInt(2,parseInt(sal));
            pst.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
            throw e;
        }
    }
    public double getSalaireByIdMetier(Connection con,int idmet) {
        PreparedStatement ps = null;
        double salaire=0.0;
        String sql = "select salaireparheure from metier where idmetier= ? ";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idmet);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    salaire = rs.getDouble("salaire");
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return salaire;
    }
    
    public List<Metier> getAllMetier() throws Exception{
            PreparedStatement pst = null;
            Connection con = null;
            List<Metier> metiers = new ArrayList<>();
        try{
            con = getConnection();
            String sql = "SELECT * FROM metier";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Metier m = new Metier();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    m.setIdMetier(resultSet.getInt("idmetier"));
                    m.setMetier(resultSet.getString("metier"));
                // Ajoutez d'autres propriétés en fonction de votre modèle de données
                    metiers.add(m);
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

        return metiers;
    
    }
    
        public int calculerAge(Date dateNaissance) {
        Calendar dateNaissanceCal = Calendar.getInstance();
        dateNaissanceCal.setTime(dateNaissance);

        Calendar maintenant = Calendar.getInstance();

        int age = maintenant.get(Calendar.YEAR) - dateNaissanceCal.get(Calendar.YEAR);

        // Vérifier si l'anniversaire n'a pas encore eu lieu cette année
        if (maintenant.get(Calendar.DAY_OF_YEAR) < dateNaissanceCal.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
        public void checkDate(LocalDate d,Connection c,int idPersonnel)throws Exception{
        LocalDate now = LocalDate.now();
        int differenceY = now.getYear()-d.getYear();
        int differenceM = now.getMonthValue()-d.getMonthValue();
        int differenceD = now.getDayOfMonth()-d.getDayOfMonth();
        PreparedStatement pst = null;
        String sql="";
        try {
            if(differenceY==2 && differenceM>=0 && differenceD>=0){
                sql = "update personnel set idMetier=2 where idPersonnel="+idPersonnel;
                pst=c.prepareStatement(sql);
                pst.executeUpdate();
            }
            else if(differenceY>=3 && differenceM>=0 && differenceD>=0){
                sql = "update personnel set idMetier=3 where idPersonnel="+idPersonnel;
                pst=c.prepareStatement(sql);
                pst.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
         finally {
            if (pst != null) {
                pst.close();
            }
        }
   
        }
        
    public List<V_salairepersonnel> getAllPersonnel() throws Exception{
              List<V_salairepersonnel> list = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            String sql = "SELECT * FROM v_getsalairepersonnel";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    V_salairepersonnel pers = new V_salairepersonnel();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    pers.setIdPersonnel(resultSet.getInt("idpersonnel"));
                    pers.setNomPersonnel(resultSet.getString("nompersonnel"));
                    pers.setDatedenaissance(resultSet.getDate("datedenaissance"));
//                    pers.setDateembauche(resultSet.getDate("dateembauche"));
                    pers.setMetier(resultSet.getString("metier"));
                    pers.setPoste(resultSet.getString("poste"));
                    pers.setSalaireHeure(resultSet.getDouble("salaireparheure"));
// Ajoutez d'autres propriétés en fonction de votre modèle de données
                    list.add(pers);
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

        return list;
    }
    
        public void insertClient(Connection c, String cl,String g) throws Exception {
            PreparedStatement pst = null;
            String sql = "INSERT INTO client (nom,genre) values (?,?)";
            try {
                 pst = c.prepareStatement(sql);
                pst.setString(1, cl);
                pst.setString(2,g);
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
    
    public List<Client> getAllClients() throws Exception{
        String sql="Select * from client";
        Connection con=null;
        List<Client> clients = new ArrayList<>();
        try{
            con = getConnection();
            
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Client pers = new Client();
                    
//                    request.setAttribute(produit.setIdProduit(resultSet.getInt("id")),"rod")
                    pers.setIdClient(resultSet.getInt("idclient"));
                    pers.setNomClient(resultSet.getString("nom"));
//                    pers.setDateDeNaissance(resultSet.getDate("datedenaissance"));
                    pers.setGenre(resultSet.getString("genre"));
// Ajoutez d'autres propriétés en fonction de votre modèle de données
                    clients.add(pers);
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
        return clients;
    }
    
    
    public List<Client> getStatistiques(Connection con,String produit, String genre) throws Exception {
    List<Client> statistiques = new ArrayList<>();

    // Utilisez une requête SQL pour récupérer les statistiques depuis la base de données
    String sqlQuery = "SELECT c.idClient, c.nom, c.dateDeNaissance, c.genre , Count(*) " +
                      "FROM client c " +
                      "JOIN commande cmd ON c.idClient = cmd.idClient " +
                      "WHERE cmd.produit = ? AND c.genre = ?";
    PreparedStatement pst =null;
    
    try  {
            con = getConnection();

        pst = con.prepareStatement(sqlQuery);
        pst.setString(1, produit);
        pst.setString(2, genre);

        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Client client = new Client();
                client.setIdClient(rs.getInt("idClient"));
                client.setNomClient(rs.getString("nom"));
//                client.setDateDeNaissance(rs.getDate("dateDeNaissance"));
                client.setGenre(rs.getString("genre"));

                statistiques.add(client);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Gérez l'exception selon vos besoins
    }

    return statistiques;
}
    
//    public void insertCoeff(Connection c,String coeff,String idmetier) throws Exception{
//        PreparedStatement pst = null;
//        c=getConnection();
//        String sql="insert into metier(coeff) values(?) where idmetier";
//        
//        try{
//            pst=c.prepareStatement(sql);
//            pst.setInt(1,parseInt(coeff))
//        }
//    }
}
