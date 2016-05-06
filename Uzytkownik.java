/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_projekt_v2;

import javax.swing.JOptionPane;

/**
 *
 * @author Justyna
 */

public class Uzytkownik {
	private String nazwisko;
        private String imie;
	private String login;
	private String haslo;
        private String typ;
	private int id = -1;
        
        Uzytkownik(){
            
        }
        
        Uzytkownik(int id, String nazwisko, String imie, String login, String haslo, String typ) {

            this.id = id;
            this.nazwisko = nazwisko;
            this.imie = imie;
            this.login = login;
            this.haslo = haslo;
            if (typ.equals("A") || typ.equals("B") || typ.equals("M"))
                    this.typ = typ;
          //  else{
           //     JOptionPane.showMessageDialog(null, "Niepoprawny typ uzytkownika. Spróbuj ponownie.");
           // } 
	}
/* DO USUNIECA CHYBA
    Uzytkownik() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
	public String getSurname() {
		return nazwisko;
	}
	public void setSurname(String nazwisko) {
		this.nazwisko = nazwisko;
	}
        
	public String getName() {
		return imie;
	}
	public void setName(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return haslo;
	}
	public void setPassword(String haslo) {
		this.haslo = haslo;
	}

	public void setType(String stanowisko) {
		this.typ = typ;
	}
	String getType() {
		return typ;
	}        
        
	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public void zaloguj() {
		// TODO - implement Użytkownik.zaloguj
		throw new UnsupportedOperationException();
	}

	public void wyloguj() {
		// TODO - implement Użytkownik.wyloguj
		throw new UnsupportedOperationException();
	}

	public void zmienHaslo() {
		// TODO - implement Użytkownik.zmienHaslo
		throw new UnsupportedOperationException();
	}

}