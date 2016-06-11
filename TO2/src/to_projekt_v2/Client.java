package to_projekt_v2;

/**
 *
 * @author Justyna
 */
import java.util.*; //List

public class Client {
    private String name;
    private String surname;
    private String address;
    private String phone;
    private String email;
    private int id = -1;
    
    //Konstruktory
    Client() {
  
    }

    Client(int ID, String name, String surname, String address, String phone, String email) {
        this.id = ID;
	this.name = name;
	this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    Client(String name, String surname, String address, String phone, String email) { //konstruktor dla addNewClientDAO v3_6
        this.id = 0; //zmienic? v3_6
	this.name = name;
	this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
	return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
	return this.surname;
    }
    public void setSurname(String surname) {
	this.surname = surname;
    }

    public String getAddress() {
	return this.address;
    }
    public void setAddress(String address) {
	this.address = address;
    }

    public String getPhone() {
	return this.phone;
    }
    public void setPhone(String phone) {
	this.phone = phone;
    }
        
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
            
    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
    	return id;
    }
}
