/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_projekt_v2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Justyna
 */
public class Test {
    public static void main(String [] args){
        UzytkownikDB udb = new UzytkownikDB();
        udb.displayUserDataDB(3);
        udb.displayUserDataDB(4); 
        udb.displayUserDataDB(5); 
        ArrayList<Uzytkownik> listauzytk = new ArrayList<Uzytkownik>();
        try {
            listauzytk = udb.getUsersList();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Uzytkownik u : listauzytk){
            System.out.println(u.getName() + ", " + u.getSurname() +  ", " + u.getType());
        }
    }    
}
