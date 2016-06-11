/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_projekt_v2;


import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Justyna
 */
public class ClientsBrowser {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
     private Connection getConnection() throws SQLException {
	Connection conn;
	conn = ConnectionFactory.getInstance().getConnection();
	return conn;
     }
    
    public ArrayList<Client> getChosenClientsList (Client client) throws SQLException{   //wyszukiwanie klientów
        Integer idint = client.getID();
        String id = idint.toString();
        String name = client.getName();
        String surname = client.getSurname();
        String address = client.getAddress();
        String phone = client.getPhone();
        String email = client.getEmail();
        System.out.println(id + name + surname + address + phone + email);
        ArrayList<Client> clientsList = new ArrayList<Client>();
        Connection connection = getConnection();
        //wyszukiwanie po: ID, imieniu, nazwisku, adresie
        if(!id.equals("") && !name.equals("") && !surname.equals("") && !address.equals("")){  
            String query = "SELECT * FROM Klient WHERE IDKlient="+ id + 
                            " OR Imie='" + name + "' OR Nazwisko='" + surname + 
                            "' OR Adres LIKE '%" + address + "%'";
            Statement st;
            ResultSet rs;
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){    //jezeli w liscie nie ma danego klienta to go dodaje
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                
        }
        //wyszukiwanie po id imieniu i nazwisku
        else if(!id.equals("") && !name.equals("") && !surname.equals("")&& address.equals("")){
            String query = "SELECT * FROM Klient WHERE IDKlient="+ id + 
                            " OR Imie='" + name + "' OR Nazwisko='" + surname + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                    
        }
        //po imieniu, nazwisku, adresie
        else if(id.equals("") && !name.equals("") && !surname.equals("") && !address.equals("")){  
            String query = "SELECT * FROM Klient WHERE Imie='" + name + "' OR Nazwisko='" + surname + 
                            "' OR Adres LIKE '%" + address + "%'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                
        }
        //wyszukiwanie po ID i po Imieniu
        else if(!id.equals("") && !name.equals("") && surname.equals("") && address.equals("")){ 
            String query = "SELECT * FROM Klient WHERE IDKlient="+ id + 
                            " OR Imie='" + name + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client klient;
                while(rs.next()){
                    klient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(klient)){
                        clientsList.add(klient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                 
        }
        //wyszukiwanie po ID i po Nazwisku
        else if(!id.equals("") && name.equals("") && !surname.equals("") && address.equals("")){ 
            String query = "SELECT * FROM Klient WHERE IDKlient=" + id + " OR Nazwisko='" + surname + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                 
        }
        //wyszukiwanie po ID i po Adresie
        else if(!id.equals("") && name.equals("") && surname.equals("") && !address.equals("")){ 
            String query = "SELECT * FROM Klient WHERE IDKlient="+ id + " OR Adres LIKE'%" + address + "%'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                 
        } 
        //wyszukiwanie po imieniu i nazwisku
        if(id.equals("") && !name.equals("") && !surname.equals("") && address.equals("")){    
            String query = "SELECT * FROM Klient WHERE Imie='" + name + "' AND Nazwisko='" + surname + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                
        }        
        //wyszukiwanie tylko po ID
        else if(!id.equals("") && name.equals("") && surname.equals("") && address.equals("")){    
            String query = "SELECT * FROM Klient WHERE IDKlient="+ id;
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }                 
        }
        //wyszukiwanie tylko po imieniu
        else if(id.equals("") && !name.equals("") && surname.equals("") && address.equals("")){  
            String query = "SELECT * FROM Klient WHERE Imie='" + name + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }               
        }
        //wyszukiwanie Tylko po nazwisku
        else if(id.equals("") && name.equals("") && !surname.equals("") && address.equals("")){ 
            String query = "SELECT * FROM Klient WHERE Nazwisko='" + surname + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }               
        }
        //wyszukiwanie Tylko po nazwisku
        else if(id.equals("") && name.equals("") && surname.equals("") && !address.equals("")){ 
            String query = "SELECT * FROM Klient WHERE Adres LIKE '%" + address + "'";
            Statement st;
            ResultSet rs;
        
            try{
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Client nclient;
                while(rs.next()){
                    nclient = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(nclient)){
                        clientsList.add(nclient);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }               
        }
        
        return clientsList;
    }    
    
    
}
