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
import java.util.Objects;
import javax.swing.JOptionPane;


public class UserDAO {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.connection);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDAO other = (UserDAO) obj;
        if (!Objects.equals(this.connection, other.connection)) {
            return false;
        }
        return true;
    }
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    int id = -1;

    private Connection getConnection() throws SQLException {
	Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
	return conn;
    }

    public User getUserByLoginDAO(String userLogin){
        User user = null;
	try {
            String queryString = "SELECT * FROM Uzytkownik WHERE Login = '" + userLogin + "'";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko").trim(), rs.getString("Imie").trim(), rs.getString("Login").trim(), rs.getString("Haslo").trim(), rs.getString("Typ").trim());
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
        return user;
        
    }
 /*
    public User getUserByIdDAO(int userID){ //USUN
        User user = null;
	try {
            String queryString = "SELECT * FROM Uzytkownik WHERE IDUzytkownik = " + userID;
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
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
        return user;
        
    }
    
    
    public String getUserTypeDAO(String userName){ //USUN
        User user = new User();
	try {
            String queryString = "SELECT * FROM Uzytkownik WHERE Login = '" + userName + "'";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
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
        return user.getType();
        
    }
    */
    public ArrayList<User> getUsersList () throws SQLException{
        ArrayList<User> usersList = new ArrayList<User>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM Uzytkownik";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            User user;
            while(rs.next()){
                user = new User(rs.getInt("IDUzytkownik"), rs.getString("Nazwisko"), rs.getString("Imie"), rs.getString("Login"), rs.getString("Haslo"), rs.getString("Typ"));
                usersList.add(user);
            }
        }catch(Exception e){
               e.printStackTrace();
        }
        return usersList;
    }
 
    
    public User updateUserDataDAO(User user) throws SQLException{
        User upduser = null;
        
        if(user.getType().equals("A") || user.getType().equals("B") || user.getType().equals("M")){    
            String query = "UPDATE Uzytkownik SET Nazwisko='" + user.getSurname() + "', Imie='"
                    + user.getName() + "', Login='" +  user.getLogin() + "', Haslo='" + user.getPassword() + "', Typ='" + user.getType()
                    + "' WHERE IDUzytkownik=" + user.getID();
            
            upduser = new User(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getType());
            
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
        return upduser;
    }    
    
    /*
    public void updateUserDataDAO(String surname, String name, String login, String password, String type, String id) throws SQLException{
        if(type.equals("A") || type.equals("B") || type.equals("M")){    
            String query = "UPDATE Uzytkownik SET Nazwisko='" + surname + "', Imie='"
                    + name + "', Login='" +  login + "', Haslo='" + password + "', Typ='" + type  
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
*/

    public void addNewUserDAO(User user) throws SQLException{
        if(!user.getSurname().equals("") && !user.getLogin().equals("") && !user.getPassword().equals("") && !user.getType().equals("")){    
            if(user.getType().equals("A") || user.getType().equals("B") || user.getType().equals("M")){
                String query = "INSERT INTO Uzytkownik (Nazwisko, Imie, Login, Haslo, Typ) VALUES ('" 
                        + user.getSurname() + "', '" + user.getName() + "', '" + user.getLogin() + "', '" + user.getPassword() + "', '"
                        + user.getType() + "')" ;

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
    
/*    
    public void addNewUserDAO(String surname, String name, String login, String password, String type) throws SQLException{
        if(!surname.equals("") && !login.equals("") && !password.equals("") && !type.equals("")){    
            if(type.equals("A") || type.equals("B") || type.equals("M")){
                String query = "INSERT INTO Uzytkownik (Nazwisko, Imie, Login, Haslo, Typ) VALUES ('" 
                        + surname + "', '" + name + "', '" + login + "', '" + password + "', '"
                        + type + "')" ;

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
*/    
    public boolean updateUserPasswordDAO(User user, String givenOldPassword, String newPassword1, String newPassword2) throws SQLException{
        boolean canChangePassword = true; //flaga - czy mozna zmienic haslo czy nie
        if(!(givenOldPassword.equals(user.getPassword()))){
            canChangePassword = false;
            JOptionPane.showMessageDialog(null, "Błąd. Stare hasło nieprawidłowe.");
        }
        if(!(newPassword1.equals(newPassword2))){
            JOptionPane.showMessageDialog(null, "Błąd. Różnica w nowym haśle.");
            canChangePassword = false;
        }
        else if (canChangePassword){
            String query = "UPDATE Uzytkownik SET Haslo='" + newPassword2 + "' WHERE Login='" + user.getLogin() + "'";
            
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
    
  /*  public void displayUserDataDAO(int userID){
        User user = new User();
        UserDAO userDAO = new UserDAO();
        user = userDAO.getUserByIdDAO(userID);
        
        System.out.println("ID: " + user.getID() + "\n" + "Imię: " + user.getName() 
                + "\n" + "Nazwisko: " + user.getSurname() + "\n" + "Login: " + user.getLogin()+
                "\n" + "Typ: " + user.getType());
    }*/
    
    
}
