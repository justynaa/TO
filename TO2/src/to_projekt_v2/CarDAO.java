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

public class CarDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
	conn = ConnectionFactory.getInstance().getConnection();
	return conn;
    }

    public ArrayList<Car> getCarsList () throws SQLException{
        ArrayList<Car> carsList = new ArrayList<Car>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM Samochod";
        Statement st;
        ResultSet rs;
        
       try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Car car;
            while(rs.next()){
                car = new Car(rs.getInt("IDSamochod"), rs.getString("Marka"), rs.getString("Model"), rs.getString("NrRej"), rs.getInt("RokProd"), rs.getInt("IDKlient"));
                carsList.add(car);
            }
        }catch(Exception e){
               e.printStackTrace();
        }
        return carsList;
    }
    
    public Car updateCarDataDAO(Car car) throws SQLException{
        Car updcar = null;
        if(!car.getBrand().equals("") && !car.getModel().equals("") && !car.getRegistrationNumber().equals("") && !Integer.toString(car.getProductionYear()).equals("") && !Integer.toString(car.getClientID()).equals("") && !Integer.toString(car.getID()).equals("")){    
            String query = "UPDATE Samochod SET Marka='" + car.getBrand() + "', Model='" + car.getModel() + "', NrRej='" +  car.getRegistrationNumber() 
               + "', RokProd='" + car.getProductionYear() + "', IDKlient='" + car.getClientID()  + "' WHERE IDSamochod=" + car.getID();

            updcar = new Car(car.getBrand(), car.getModel(), car.getRegistrationNumber(), car.getProductionYear(), car.getClientID());
            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();
             
                if(st.executeUpdate(query)== 1){
                JOptionPane.showMessageDialog(null, "Dane samochodu zaktualizowane.");
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
        return updcar;
    }    
    
    /*
    public void updateCarDataDAO(String brand, String model, String registrationNumber, String productionYear, String clientID, String id) throws SQLException{
        if(!brand.equals("") && !model.equals("") && !registrationNumber.equals("") && !productionYear.equals("") && !clientID.equals("") && !id.equals("")){    
            String query = "UPDATE Samochod SET Marka='" + brand + "', Model='" + "', NrRej='" +  registrationNumber 
               + "', RokProd='" + productionYear + "', IDKlient='" + clientID  + "' WHERE IDSamochod=" + id;

            Connection con = getConnection();
            Statement st;
            try{
                st = con.createStatement();
             
                if(st.executeUpdate(query)== 1){
                JOptionPane.showMessageDialog(null, "Dane samochodu zaktualizowane.");
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
    
    public void addNewCarDAO(Car car) throws SQLException{
        System.out.println(car.getBrand()+ " - " + car.getModel() + " - " + car.getRegistrationNumber() + " - " + Integer.toString(car.getProductionYear()) + " - " + Integer.toString(car.getClientID()));
        if(!car.getBrand().equals("") && !car.getModel().equals("") && !car.getRegistrationNumber().equals("") && !Integer.toString(car.getProductionYear()).equals("") && !Integer.toString(car.getClientID()).equals("")){    
                String query = "INSERT INTO Samochod (Marka, Model, NrRej, RokProd, IDKlient) VALUES ('" 
                + car.getBrand() + "', '" + car.getModel() + "', '" + car.getRegistrationNumber() + "', '" + car.getProductionYear() + "', '" + car.getClientID() + "')" ;

                Connection con = getConnection();
                Statement st;
                try{
                    st = con.createStatement();

                    if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Samochoód dodany do bazy");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Dodawanie samochodu nie powiodło się.");
                    }  
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                    e.printStackTrace();
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "Niepoprawne dane samochodu. Spróbuj ponownie.");
        }
    }    
    /*
    public void addNewCarDAO(String brand, String model, String registrationNumber, String productionYear, String clientID) throws SQLException{
        if(!brand.equals("") && !model.equals("") && !registrationNumber.equals("") && !productionYear.equals("") && clientID.equals("")){    
                String query = "INSERT INTO Samochod (Marka, Model, NrRej, RokProd, IDKlient) VALUES ('" 
                + brand + "', '" + model + "', '" + registrationNumber + "', '" + productionYear + "', '" + clientID + "')" ;

                Connection con = getConnection();
                Statement st;
                try{
                    st = con.createStatement();

                    if(st.executeUpdate(query)== 1){
                    JOptionPane.showMessageDialog(null, "Samochoód dodany do bazy");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Dodawanie samochodu nie powiodło się.");
                    }  
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Niepoprawny login. Spróbuj ponownie.");
                    e.printStackTrace();
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "Niepoprawne dane użytkownika. Spróbuj ponownie.");
        }
    }
    */
}
	