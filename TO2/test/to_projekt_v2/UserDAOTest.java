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
import org.mockito.*;
/**
 *
 * @author NATI
 */
public class UserDAOTest {
    
    User user = new User(3, "Jan", "Test", "test", "test", "A");
    

    /**
     * Test of getUserByLoginDAO method, of class UserDAO.
     */
    @Test
    public void testGetUserByLoginDAO() {
        System.out.println("getUserByLoginDAO");
        String userLogin = "test";
        UserDAO mockUD = Mockito.mock(UserDAO.class);
        Mockito.when(mockUD.getUserByLoginDAO(userLogin)).thenReturn(new User(3, "Jan", "Test", "test", "test", "A"));
        assertEquals(mockUD.getUserByLoginDAO(userLogin), user);
        
    }

  
    /**
     * Test of getUsersList method, of class UserDAO.
     */
    @Test
    public void testGetUsersList() throws Exception {
        System.out.println("getUsersList");

        ArrayList<User> listOfUsers = new ArrayList<>(Arrays.asList(user, user, user));
        Iterator i = Mockito.mock(Iterator.class);
        Mockito.when(i.next()).thenReturn(user).thenReturn(user).thenReturn(user);
        String result=i.next()+" "+i.next()+" "+i.next()+" ";
        String expected = user+" "+user+" "+user+" ";
        String failExp = user+" ";
        
        UserDAO mockUD = Mockito.mock(UserDAO.class);
        Mockito.when(mockUD.getUsersList()).thenReturn(listOfUsers);
        
        assertEquals(mockUD.getUsersList().size(), 3);
        assertEquals(listOfUsers, mockUD.getUsersList());
        assertEquals(expected, result);
        assertNotEquals(failExp, result);
    }

    /**
     * Test of updateUserDataDAO method, of class UserDAO.
     */
    @Test
    public void testUpdateUserDataDAO() throws Exception {
        System.out.println("updateUserDataDAO");
        String name = "Alan";
        String surname = "Not";
        String login = "not";
        String type = "B";
             
        User updatedUser = new User(name, surname, login, login, type);        
        UserDAO mockUD = Mockito.mock(UserDAO.class);
        Mockito.when(mockUD.updateUserDataDAO(user)).thenReturn(updatedUser);
        assertEquals(mockUD.updateUserDataDAO(user), updatedUser);
        assertNotEquals(mockUD.updateUserDataDAO(user), user);
        
    }
}

    /**
     * Test of addNewUserDAO method, of class UserDAO.
     */
    /*
    @Test
    public void testAddNewUserDAO() throws Exception {
        
        System.out.println("addNewUserDAO");
        UserDAO mockUD = Mockito.mock(UserDAO.class);
        //Mockito.when(mockUD.addNewUserDAO(user)).thenReturn();
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

    /**
     * Test of updateUserPasswordDAO method, of class UserDAO.
     */
    /*@Test
    public void testUpdateUserPasswordDAO() throws Exception {
        System.out.println("updateUserPasswordDAO");
        String givenOldPassword = "test";
        String newPassword1 = "test2";
        String newPassword2 = "test2";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.updateUserPasswordDAO(user, givenOldPassword, newPassword1, newPassword2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
