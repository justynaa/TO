/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_projekt_v2;

/**
 *
 * @author Justyna
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    public ClientDAO() {

    }

    private Connection getConnection() throws SQLException {
	Connection conn;
	conn = ConnectionFactory.getInstance().getConnection();
	return conn;
}
/*
    public void addNewClientDAO(String surname, String name, String address, String phone, String email) throws SQLException{
        //sprawdzenie czy sa wszystkie dane
        if(!surname.equals("") && !name.equals("") && !address.equals("") && !phone.equals("") && !email.equals("")){
            String query = "INSERT INTO Klient (Imie, Nazwisko, Adres, Telefon, Email) VALUES ('" 
                    + name + "', '" + surname + "', '" + address + "', '" + phone + "', '" + email + "')" ;

            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();

                if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Klient dodany do bazy");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Dodawanie klient nie powiodło się.");
                }  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Podano niepoprawne dane. Spróbuj ponownie.");
        }    
    }
*/        
    public void addNewClientDAO(Client client) throws SQLException{ //v3_6
        //sprawdzenie czy sa wszystkie dane
        if(!client.getSurname().equals("") && !client.getName().equals("") && !client.getAddress().equals("") && !client.getPhone().equals("") && (!client.getEmail().equals("") || client.getEmail().equals("brak"))){
            String query = "INSERT INTO Klient (Imie, Nazwisko, Adres, Telefon, Email) VALUES ('" 
                    + client.getName() + "', '" + client.getSurname() + "', '" + client.getAddress() + "', '" + client.getPhone() + "', '" + client.getEmail() + "')" ;

            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();

                if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Klient dodany do bazy");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Dodawanie klient nie powiodło się.");
                }  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Nie można nadawać ID.");
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Podano niepoprawne dane. Spróbuj ponownie.");
        }    
    }    
    
    public ArrayList<Client> getClientsList () throws SQLException{
        ArrayList<Client> clientsList = new ArrayList<Client>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM Klient";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Client client;
            while(rs.next()){
                client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                clientsList.add(client);
            }
        }catch(Exception e){
               e.printStackTrace();
        }
        return clientsList;
    }
        
 /*       
    public void updateClientDataDAO(String surname, String name, String address, String phone, String email, String id) throws SQLException{
        String query = "UPDATE Klient SET Imie='" + name + "', Nazwisko='" + surname 
                        + "', Adres='" + address + "', Telefon='" + phone + "', Email='" + email  
                        + "' WHERE IDKlient=" + id;

        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
             
            if(st.executeUpdate(query)== 1){
                JOptionPane.showMessageDialog(null, "Dane klienta zaktualizowane.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Aktualizacja danych nie powiodła się.");
            }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
            e.printStackTrace();
        }
    }
   */
        public void updateClientDataDAO(Client client) throws SQLException{
        String query = "UPDATE Klient SET Imie='" + client.getName() + "', Nazwisko='" + client.getSurname() 
                        + "', Adres='" + client.getAddress() + "', Telefon='" + client.getPhone() + "', Email='" + client.getEmail()
                        + "' WHERE IDKlient=" + client.getID();

        Connection con = getConnection();
        Statement st;
        try{
            st = con.createStatement();
             
            if(st.executeUpdate(query)== 1){
                JOptionPane.showMessageDialog(null, "Dane klienta zaktualizowane.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Aktualizacja danych nie powiodła się.");
            }  
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
            e.printStackTrace();
        }
    }
    
    /*
    public ArrayList<Client> getChosenClientsList (String surname, String name, String address, String phone, String email, String id) throws SQLException{   //wyszukiwanie klientów
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){    //jezeli w liscie nie ma danego klienta to go dodaje
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
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
                Client client;
                while(rs.next()){
                    client = new Client(rs.getInt("IDKlient"), rs.getString("Imie"), rs.getString("Nazwisko"), rs.getString("Adres"), rs.getString("Telefon"), rs.getString("Email"));
                    if(!clientsList.contains(client)){
                        clientsList.add(client);
                    }
                    else continue;
                }
            }catch(Exception e){
                   e.printStackTrace();
            }               
        }
        
        return clientsList;
    }
        */
}