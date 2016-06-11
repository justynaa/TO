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
public class OrderDAOTest {
    
    public OrderDAOTest() {
    }
    
    Order order = new Order(3, "14-06-2016", "15-06-2016", "wymiana paska klinowego", 4, 2, 50.0);

    /**
     * Test of getOrdersList method, of class OrderDAO.
     */
    @Test
    public void testGetOrdersList() throws Exception {
        System.out.println("getOrdersList");
        ArrayList<Order> listOfOrders = new ArrayList<>(Arrays.asList(order, order, order));
        Iterator i = Mockito.mock(Iterator.class);
        Mockito.when(i.next()).thenReturn(order);
        String result=i.next()+" "+i.next()+" "+i.next()+" ";
        String expected = order+" "+order+" "+order+" ";
        String failExp = order+" ";
        
        OrderDAO mockUD = Mockito.mock(OrderDAO.class);
        Mockito.when(mockUD.getOrdersList()).thenReturn(listOfOrders);
        
        assertEquals(mockUD.getOrdersList().size(), 3);
        assertEquals(listOfOrders, mockUD.getOrdersList());
        assertEquals(expected, result);
        assertNotEquals(failExp, result);
    }

    /**
     * Test of updateOrderDataDAO method, of class OrderDAO.
     */
    @Test
    public void testUpdateOrderDataDAO() throws Exception {
        System.out.println("updateOrderDataDAO");
        String sd = "15-06-2016";
        String ed = order.getEndDate();
        String desc = order.getDescription();
        int mechid = 3;
        int carid = order.getCar();
        double cost = 55.0;
             
        Order updatedOrder = new Order(sd, ed, desc, mechid, carid, cost);        
        OrderDAO mockUD = Mockito.mock(OrderDAO.class);
        Mockito.when(mockUD.updateOrderDataDAO(order)).thenReturn(updatedOrder);
        assertEquals(mockUD.updateOrderDataDAO(order), updatedOrder);
        assertNotEquals(mockUD.updateOrderDataDAO(order), order);
    }

    /**
     * Test of addNewOrderDAO method, of class OrderDAO.
     */
    /*@Test
    public void testAddNewOrderDAO() throws Exception {
        System.out.println("addNewOrderDAO");
        Order order = null;
        String userType = "";
        OrderDAO instance = new OrderDAO();
        instance.addNewOrderDAO(order, userType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

    }
    */
}
