
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Justyna
 */
public class Test {
    public static void main(String [] args){
        KlientDB kj = new KlientDB();
	Klient k1 = kj.select(1);
        System.out.println("Klient nr 1: " + k1.getImie() + k1.getNazwisko());
        System.out.println("Adres i telefon: " + k1.getAdres()+ k1.getTelefon());
        
        try {
            kj.create();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
