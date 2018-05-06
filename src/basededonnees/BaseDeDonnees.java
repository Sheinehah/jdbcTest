/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededonnees;


import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.*;

/**
 *
 * @author eleve9
 */
public class BaseDeDonnees {
    
    public static void main(String[] args) throws Exception {
            //MySqlAccess dao = new MySqlAccess();
            //dao.readDataBase();
            sauverEnBase("Mike LUC");
            print("Good");
        }
    
    public static void print(Object a){
        System.out.println(a);
    }
    
    public static void sauverEnBase(String personne) throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://localhost/testjava";
        String login = "root";
        String passwd = ""; 
        Connection connect = null; 
        Statement statement = null; 
        
        try {
            // Etape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver"); 
            
            // Etape 2 : Récupération de la connexion
            connect = DriverManager.getConnection(url, login, passwd);
            
            // Etape 3 : Création d'un statement 
            statement = connect.createStatement();
            String sql = "INSERT INTO personne (personne) VALUES ('" + personne + "')";
            
            // Etape 4 : exécution requête
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // Etape 5 : libérer ressources de la mémoire
                connect.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}


    

