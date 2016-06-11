package to_projekt_v2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justyna
 */

public class Car {
        private String brand;
	private String model;
	private String registrationNumber;
        private int productionYear;
        private int clientID;
	//private Klient wlasciciel;
	private int id = -1;

	Car() {

	}

	Car(int id, String brand, String model, String registrationNumber, int productionYear, int clientID) {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.registrationNumber = registrationNumber;
            this.productionYear = productionYear;
            this.clientID = clientID;
        }
        Car(String brand, String model, String registrationNumber, int productionYear, int clientID) {
            this.id = 0; //v3_6 zmienic?
            this.brand = brand;
            this.model = model;
            this.registrationNumber = registrationNumber;
            this.productionYear = productionYear;
            this.clientID = clientID;
        }
        
      
        public String getBrand() {
		return brand;
	}
	public void setBrand (String brand) {
		this.model = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
        
        public int getClientID() {
		return clientID;
	}
	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

        public int getProductionYear() {
            return productionYear;
	}
	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
        
}