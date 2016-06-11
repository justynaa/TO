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
public class Order {
    private String startDate;
    private String endDate;
    private String description;
    private int mechanic;
    private int car;    
    private double cost;
    private int id = -1;
    //private Samochod samochod;
    //private Użytkownik mechanik;
    Order() {

    }

    Order(int id, String startDate, String endDate, String description, int mechanic, int car, double cost) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.mechanic = mechanic;
        this.car = car;
        this.cost = cost;
    }
    Order(String startDate, String endDate, String description, int mechanic, int car, double cost) {
        this.id = 0; //zmienic? v3_6
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.mechanic = mechanic;
        this.car = car;
        this.cost = cost;
    }


    public String getStartDate() {
        return this.startDate;
    }
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    public String getEndDate() {
        return this.endDate;
    }
    public void setEndDate(String startDate){
        this.endDate = startDate;
    }

    public int getCar() {
        return this.car;
    }
    public void setCar(int car) {
        this.car = car;
    }

    public int getMechanic() {
        return this.mechanic;
    }

    public void setMechanic(int mechanic) {
        this.mechanic = mechanic;
    } 
    
    public String getDescription() {
        return this.description;
    }

    public void setOpis(String opis) {
        this.description = description;
    }        
    
    public double getCost(){
        return this.cost;
    }
    public void setCost(double cost){
        this.cost = cost;
    }
    
    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

}
