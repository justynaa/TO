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
import java.util.List;
import javax.swing.JOptionPane;

public class OrderDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }
    public ArrayList<Order> getOrdersList () throws SQLException{
        ArrayList<Order> ordersList = new ArrayList<Order>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM Zamowienie";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Order order;
            while(rs.next()){
                order = new Order(rs.getInt("IDZamowienie"), rs.getString("RozpoczecieRealizacji"), rs.getString("ZakonczenieRealizacji"), rs.getString("Opis"), rs.getInt("Mechanik"), rs.getInt("Samochod"), rs.getDouble("KosztRealizacji"));
                ordersList.add(order);
            }
        }catch(Exception e){
               e.printStackTrace();
        }
        return ordersList;
    }

    public Order updateOrderDataDAO(Order order) throws SQLException{
        Order updorder = null;
        String query = "";
        if(!order.getStartDate().equals("") && !order.getDescription().equals("") && !Integer.toString(order.getMechanic()).equals("") && !Integer.toString(order.getCar()).equals("")){
            updorder = new Order(order.getStartDate(), order.getEndDate(), order.getDescription(), order.getMechanic(), order.getCar(), order.getCost());
            if(order.getEndDate().equals("")){
                query = "UPDATE Zamowienie SET RozpoczecieRealizacji='" + order.getStartDate() + "', ZakonczenieRealizacji= NULL"
                    + ", Opis='" +  order.getDescription() + "', Mechanik=" + order.getMechanic() + ", Samochod=" + order.getCar()  
                    + ", KosztRealizacji=" + order.getCost() + " WHERE IDZamowienie=" + order.getID();                
            }
            else{
                query = "UPDATE Zamowienie SET RozpoczecieRealizacji='" + order.getStartDate() + "', ZakonczenieRealizacji='"
                    + order.getEndDate() + "', Opis='" +  order.getDescription() + "', Mechanik=" + order.getMechanic() + ", Samochod=" + order.getCar()  
                    + ", KosztRealizacji=" + order.getCost() + " WHERE IDZamowienie=" + order.getID();
            }
            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();
             
                if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Dane zamówienia zaktualizowane.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Aktualizacja danych nie powiodła się.");
                }  
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                e.printStackTrace();
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Podano niepoprawne dane. Spróbuj ponownie.");
        }  
        return updorder;
    }        
    
    /*
    public void updateOrderDataDAO(String startDate, String endDate, String description, String mechanic, String car, String cost, String id) throws SQLException{
        String query = "";
        if(!startDate.equals("") && !description.equals("") && !mechanic.equals("") && !car.equals("")){
            if(endDate.equals("")){
                query = "UPDATE Zamowienie SET RozpoczecieRealizacji='" + startDate + "', ZakonczenieRealizacji= NULL"
                    + ", Opis='" +  description + "', Mechanik=" + mechanic + ", Samochod=" + car  
                    + ", KosztRealizacji=" + cost + " WHERE IDZamowienie=" + id;                
            }
            else{
                query = "UPDATE Zamowienie SET RozpoczecieRealizacji='" + startDate + "', ZakonczenieRealizacji='"
                    + endDate + "', Opis='" +  description + "', Mechanik=" + mechanic + ", Samochod=" + car  
                    + ", KosztRealizacji=" + cost + " WHERE IDZamowienie=" + id;
            }
            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();
             
                if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Dane zamówienia zaktualizowane.");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Aktualizacja danych nie powiodła się.");
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

    public void addNewOrderDAO(Order order, String userType) throws SQLException{
        String query = ""; //v3_6 usuniecie rozróżnienia dla dodawania nowego klienta na Admina i reszte
        query = "INSERT INTO Zamowienie (RozpoczecieRealizacji, ZakonczenieRealizacji, Opis, Mechanik, Samochod, KosztRealizacji) VALUES ('" 
                + order.getStartDate() + "', NULL, '" + order.getDescription() + "'," + order.getMechanic() + ", " + order.getCar() + ", NULL)";

        
        Connection con = getConnection();
        Statement st;
         try{
            st = con.createStatement();

            if(st.executeUpdate(query)== 1){
                JOptionPane.showMessageDialog(null, "Zamówienie dodane do bazy");
            }
            else{
                JOptionPane.showMessageDialog(null, "Dodawanie zamówienia nie powiodło się.");
            }  
        }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                    e.printStackTrace();
                }
        }    
    
/*
    public void addNewOrderDAO(String startDate, String endDate, String description, String mechanic, String carID, String cost, String userType) throws SQLException{
        String query = "";
        if(userType.equals("A")){
             query = "INSERT INTO Zamowienie (RozpoczecieRealizacji, ZakonczenieRealizacji, Opis, Mechanik, Samochod, KosztRealizacji) VALUES ('" 
                + startDate + "', '" + endDate + "', '" + description + "'," + mechanic + ", " + carID + ", " + cost + ")";           
        }
        else{
            query = "INSERT INTO Zamowienie (RozpoczecieRealizacji, ZakonczenieRealizacji, Opis, Mechanik, Samochod, KosztRealizacji) VALUES ('" 
                + startDate + "', NULL, '" + description + "'," + mechanic + ", " + carID + ", NULL)";
        }
        
        Connection con = getConnection();
        Statement st;
         try{
            st = con.createStatement();

            if(st.executeUpdate(query)== 1){
                JOptionPane.showMessageDialog(null, "Zamówienie dodane do bazy");
            }
            else{
                JOptionPane.showMessageDialog(null, "Dodawanie zamówienia nie powiodło się.");
            }  
        }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                    e.printStackTrace();
                }
        }
    */
}
