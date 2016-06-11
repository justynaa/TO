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

public class User {

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    private String surname;
    private String name;
    private String login;
    private String password;
    private String type;
    private int id = -1;
        
    User(){        
    }
        
    User(int id, String surname, String name, String login, String password, String type) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.password = password;
        if (type.equals("A") || type.equals("B") || type.equals("M"))
            this.type = type;
          //  else{
           //     JOptionPane.showMessageDialog(null, "Niepoprawny typ uzytkownika. Spróbuj ponownie.");
           // } 
    }
    User(String surname, String name, String login, String password, String type) {
        this.id = 0;
        this.surname = surname;
        this.name = name;
        this.login = login;
        this.password = password;
        if (type.equals("A") || type.equals("B") || type.equals("M"))
            this.type = type;
          //  else{
           //     JOptionPane.showMessageDialog(null, "Niepoprawny typ uzytkownika. Spróbuj ponownie.");
           // } 
    }
    
    
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
        
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String haslo) {
		this.password = password;
	}

	public void setType(String type) {
		this.type = type;
	}
	String getType() {
		return type;
	}        
        
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}

}