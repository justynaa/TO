/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package to_projekt_v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author NATI
 */
public class CarDAOTest {
    
    public CarDAOTest() {
    }
    
    Car car = new Car(2, "Fiat", "Panda", "MG09U", 2004, 1);
    
    /**
     * Test of getCarsList method, of class CarDAO.
     */
    @Test
    public void testGetCarsList() throws Exception {
        System.out.println("getCarsList");
        ArrayList<Car> listOfCars = new ArrayList<>(Arrays.asList(car, car, car));
        Iterator i = Mockito.mock(Iterator.class);
        Mockito.when(i.next()).thenReturn(car);
        String result=i.next()+" "+i.next()+" "+i.next()+" ";
        String expected = car+" "+car+" "+car+" ";
        String failExp = car+" ";
        
        CarDAO mockUD = Mockito.mock(CarDAO.class);
        Mockito.when(mockUD.getCarsList()).thenReturn(listOfCars);
        
        assertEquals(3, mockUD.getCarsList().size());
        assertEquals(listOfCars, mockUD.getCarsList());
        assertEquals(expected, result);
        assertNotEquals(failExp, result);
    }

    /**
     * Test of updateCarDataDAO method, of class CarDAO.
     */
    @Test
    public void testUpdateCarDataDAO() throws Exception {
        System.out.println("updateCarDataDAO");
        String brand = "Seat";
        String model = "Leon";
        String regNo = "MK455W";
        int prodYear = 2004;
        int clientid = 1;
             
        Car updatedCar = new Car(brand, model, regNo, prodYear, clientid);        
        CarDAO mockUD = Mockito.mock(CarDAO.class);
        Mockito.when(mockUD.updateCarDataDAO(car)).thenReturn(updatedCar);
        assertEquals(mockUD.updateCarDataDAO(car), updatedCar);
        assertNotEquals(mockUD.updateCarDataDAO(car), car);
    }

    /**
     * Test of addNewCarDAO method, of class CarDAO.
     */
    /*@Test
    public void testAddNewCarDAO() throws Exception {
        System.out.println("addNewCarDAO");
        Car car = null;
        CarDAO instance = new CarDAO();
        instance.addNewCarDAO(car);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
