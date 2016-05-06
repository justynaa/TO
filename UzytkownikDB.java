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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class UzytkownikDB {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    int id = -1;

    private Connection getConnection() throws SQLException {
	Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
	return conn;
    }

    public Uzytkownik getUserByLoginDB(String userLogin){ //USUN
        Uzytkownik uzytkownik = null;
	try {
            String queryString = "SELECT * FROM Uzytkownik WHERE Login = '" + userLogin + "'";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                uzytkownik = new Uzytkownik(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
	} finally {
            try {
                if (rs != null)
                    rs.close();
		if (ptmt != null)
                    ptmt.close();
		if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }        
        return uzytkownik;
        
    }

    public Uzytkownik getUserByIdDB(int userID){ //USUN
        Uzytkownik uzytkownik = null;
	try {
            String queryString = "SELECT * FROM Uzytkownik WHERE IDUzytkownik = " + userID;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                uzytkownik = new Uzytkownik(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
	} finally {
            try {
                if (rs != null)
                    rs.close();
		if (ptmt != null)
                    ptmt.close();
		if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }        
        return uzytkownik;
        
    }
    
    
    public String getUserTypeDB(String userName){ //USUN
        Uzytkownik uzytkownik = new Uzytkownik();
	try {
            String queryString = "SELECT * FROM Uzytkownik WHERE Login = '" + userName + "'";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                uzytkownik = new Uzytkownik(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
	} finally {
            try {
                if (rs != null)
                    rs.close();
		if (ptmt != null)
                    ptmt.close();
		if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }        
        return uzytkownik.getType();
        
    }
    
    public ArrayList<Uzytkownik> getUsersList () throws SQLException{
        ArrayList<Uzytkownik> listaUzytkownikow = new ArrayList<Uzytkownik>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM Uzytkownik";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Uzytkownik uzytkownik;
            while(rs.next()){
                uzytkownik = new Uzytkownik(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
                listaUzytkownikow.add(uzytkownik);
            }
        }catch(Exception e){
               e.printStackTrace();
        }
        return listaUzytkownikow;
    }
    
    public void updateUserDataDB(String nazwisko, String imie, String login, String haslo, String typ, String id) throws SQLException{
        if(typ.equals("A") || typ.equals("B") || typ.equals("M")){    
            String query = "UPDATE Uzytkownik SET Nazwisko='" + nazwisko + "', Imie='"
                    + imie + "', Login='" +  login + "', Haslo='" + haslo + "', Typ='" + typ  
                    + "' WHERE IDUzytkownik=" + id;

            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();
             
                if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Dane uzytkownika zaktualizowane.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Aktualizacja danych nie powiodła się.");
                }  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Niepoprawny typ uzytkownika. Spróbuj ponownie.");
        }
    }
    
    public void addNewUserDB(String nazwisko, String imie, String login, String haslo, String typ) throws SQLException{
        if(!nazwisko.equals("") && !login.equals("") && !haslo.equals("") && !typ.equals("")){    
            if(typ.equals("A") || typ.equals("B") || typ.equals("M")){
                String query = "INSERT INTO Uzytkownik (Nazwisko, Imie, Login, Haslo, Typ) VALUES ('" 
                        + nazwisko + "', '" + imie + "', '" + login + "', '" + haslo + "', '"
                        + typ + "')" ;

                Connection con = getConnection();
                Statement st;
                try{
                    st = con.createStatement();

                    if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Użytkownik dodany do bazy");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Dodawanie użytkownika nie powiodło się.");
                    }  
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Niepoprawny typ uzytkownika. Spróbuj ponownie.");
            }      
        }
        else{
            JOptionPane.showMessageDialog(null, "Niepoprawne dane użytkownika. Spróbuj ponownie.");
        }
    }
    
    public boolean updateUserPasswordDB(Uzytkownik uzytkownik, String givenOldPassword, String newPassword1, String newPassword2) throws SQLException{
        boolean canChangePassword = true; //flaga - czy mozna zmienic haslo czy nie
        if(!(givenOldPassword.equals(uzytkownik.getPassword()))){
            canChangePassword = false;
            JOptionPane.showMessageDialog(null, "Błąd. Stare hasło nieprawidłowe.");
        }
        if(!(newPassword1.equals(newPassword2))){
            JOptionPane.showMessageDialog(null, "Błąd. Różnica w nowym haśle.");
            canChangePassword = false;
        }
        else if (canChangePassword){
            String query = "UPDATE Uzytkownik SET Haslo='" + newPassword2 + "' WHERE Login='" + uzytkownik.getLogin() + "'";
            
          Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();
             
                if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Hasło zostało zmienione.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Zmiana hasła nie powiodła się.");
                }  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                e.printStackTrace();
            }
         
        }
        return canChangePassword;
    }
    //wypisanie danych wybranego użytkownika na konsole
    
    public void displayUserDataDB(int userID){
        Uzytkownik uzytkownik = new Uzytkownik();
        UzytkownikDB uzytkownikDB = new UzytkownikDB();
        uzytkownik = uzytkownikDB.getUserByIdDB(userID);
        
        System.out.println("ID: " + uzytkownik.getID() + "\n" + "Imię: " + uzytkownik.getName() 
                + "\n" + "Nazwisko: " + uzytkownik.getSurname() + "\n" + "Login: " + uzytkownik.getLogin()+
                "\n" + "Typ: " + uzytkownik.getType());
    }
}
