import org.junit.jupiter.api.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class LogTest {
   @Test
public void testCaseSensitivity() {
    LoginApp app = new LoginApp();


        String username = app.authenticateUser("johndoe@example.com", "password123");
        assertNotNull(username, "Username should not be null for exact email and password match");
        assertEquals("John Doe", username, "Username should match the expected value for correct credentials");

        // Password case mismatch (should fail - passwords are case-sensitive)
        username = app.authenticateUser("johndoe@example.com", "Password123"); // Capital "P"
        assertNull(username, "Username should be null for case-sensitive password mismatch");

}

@Test
public void testValid() {
    LoginApp app = new LoginApp();
    
        String username = app.authenticateUser("johndoe@example.com", "password123");
        assertNotNull(username, "Username should not be null for valid email and password");
        assertEquals("John Doe", username, "Username should match the expected value");
    
}

@Test
public void testInvalid() {
    LoginApp app = new LoginApp();
   
        String username = app.authenticateUser("tomclark@example.com", "password789");
        assertNull(username, "Username should be null for invalid email-password combination");
}

@Test
public void testEmpty() {
    LoginApp app = new LoginApp();

    String username = app.authenticateUser("", "");
    assertNull(username, "Username should be null for empty email and password");
    
    username = app.authenticateUser("johndoe@example.com", "");
    assertNull(username, "Username should be null for empty password");
}


@Test
public void test2() {
    LoginApp app = new LoginApp();

    
    String username = app.authenticateUser("", "password123");
    assertNull(username, "Username should be null for empty email");
}


}
