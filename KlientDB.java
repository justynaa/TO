
import java.sql.*;
import java.util.*;

/**
 *
 * @author Justyna
 */
public class KlientDB{
	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;

	public KlientDB() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
        void create()throws SQLException {  //dodawanie nowego klienta do bazy
            Klient klient = new Klient();
            Scanner sc = new Scanner(System.in);
            System.out.print("Podaj imie klienta: ");
            klient.setImie(sc.nextLine());
             System.out.print("Podaj nazwisko klienta: ");
            klient.setNazwisko(sc.nextLine());
            System.out.print("Podaj adres klienta: ");
            klient.setAdres(sc.nextLine());
            System.out.print("Podaj numer telefonu klienta: ");
            klient.setTelefon(sc.nextLine());
            System.out.print("Podaj email klienta: ");
            klient.setEmail(sc.nextLine());
            try {
                    String queryString = "INSERT INTO Klient  (Imie, Nazwisko, Adres, Telefon, Email) "
                            + "VALUES ('"+klient.getImie()+"','"+klient.getNazwisko()+"','"+klient.getAdres()+"','"+klient.getTelefon()+"','"+klient.getEmail()+"')";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
                        System.out.println("Utworzenie nowego klienta nie powiodło się.");
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
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
            
           
            
        }

    public <Klient> List<Klient> read(Klient obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public <Klient> Klient update(Klient obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public <Klient> Klient delete(Klient obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    	public Klient select(int id) { // Zwraca klieta o zadanym id
		Klient k = new Klient();
		try {
			String queryString = "SELECT * FROM klient WHERE IDKlient="
					+ id;
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			while (resultSet.next()) {
				k.setId(resultSet.getInt("IDKlient"));
				k.setImie(resultSet.getString("Imie"));
				k.setNazwisko(resultSet.getString("Nazwisko"));
				k.setAdres(resultSet.getString("Adres"));
				k.setTelefon(resultSet.getString("Telefon"));
                                k.setEmail(resultSet.getString("Email"));
				// System.out.println("Wybrano klient id="+id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
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
		return k;
	}


}
