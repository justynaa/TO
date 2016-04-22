/**
 *
 * @author Justyna
 */
import java.util.*; //List

public class Klient {
    private String imie;
    private String nazwisko;
    private String adres;
    private String telefon;
    private String email;
    private int id = -1;
    
    //Konstruktory
    Klient() {
  
    }

    Klient(String imie, String nazwisko) {
	this.imie = imie;
	this.nazwisko = nazwisko;
    }

        public String getImie() {
	return this.imie;
        }
	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdres() {
		return this.adres;
	}

	/**
	 * 
	 * @param adres
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getTelefon() {
		return this.telefon;
	}

	/**
	 * 
	 * @param telefon
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
        
        public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
    
}
