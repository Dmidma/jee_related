package model;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.ForEach;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmidma
 */
public class Etudiant {
    
    
    public String name, lastName, groupe, genre, login, password;
    public String CIN;
    
    public Etudiant(
            String nom, 
            String prenom, 
            String cin, 
            String groupe, 
            String genre, 
            String login,
            String password) {
        
        
        this.name = nom;
        this.lastName = prenom;
        this.CIN = cin;
        this.groupe = groupe;
        this.login = login;
        this.password = password;
        
    }
    
    public Etudiant() {
  
    }
    
    
    public boolean sauvgarder() {
        
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/duck", "testuser", "password");
            
            st = conn.prepareStatement("INSERT INTO etudiant (nom, cin, prenom, login, pass, groupe) VALUES (?, ?, ?, ?, ?, ?);");
            
            
            
            st.setString(1, this.name);
            st.setString(2, this.CIN);
            st.setString(3, this.lastName);
            st.setString(4, this.login);
            st.setString(5, this.password);
            st.setString(6, this.groupe);
            
            // since it is an inset function and the query won't return any ResultSet
            // execute() will return a false boolean
            // Thus I am testing with !
            return !st.execute();
            
            // st.set
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
        
        return false;
        
    }
    
    
    public Etudiant connect(String login, String password) {
        
        Etudiant et = null;
        
        
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/duck", "testuser", "password");
            
            st = conn.prepareStatement("SELECT * FROM etudiant WHERE login=? AND pass=?;");
            
            
            st.setString(1, login);
            st.setString(2, password);
            
            
            
            
            ResultSet rs = st.executeQuery();
            
            rs.first();
            
            
            // get all information to the current etudiant
            this.name = rs.getString("nom");
            this.CIN = rs.getString("cin");
            this.lastName = rs.getString("prenom");
            this.login = rs.getString("login");
            this.password = rs.getString("pass");
            
            et = this;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return et;
    }

    
    public static HashMap<String, List<String>> groupe(String groupe) {
        
        PreparedStatement st;
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("name", new ArrayList<String>());
        map.put("lastName", new ArrayList<String>());
        map.put("CIN", new ArrayList<String>());
        map.put("Login", new ArrayList<String>());
        
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/duck", "testuser", "password");
            
            st = conn.prepareStatement("SELECT * FROM etudiant WHERE  groupe=?;");
            
            
            st.setString(1, groupe);
            ResultSet rs = st.executeQuery();
            rs.first();
            
            do {
                
                map.get("name").add(rs.getString("nom"));
                map.get("name").add(rs.getString("cin"));
                map.get("name").add(rs.getString("prenom"));
                map.get("name").add(rs.getString("login"));
                       
            } while(rs.next());
            
            
            return map;
                    
                    
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
