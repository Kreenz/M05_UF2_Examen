/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import examenm05_uf2.Avaluador;
import examenm05_uf2.Estudiant;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.Parameterized.Parameter;

/**
 *
 * @author Oriol Fornos Cuni
 */
public class EstudiantTest {
    
    public static Estudiant estudiant;
    public static Estudiant estudiant2;

    @Rule 
    public Timeout timeout = Timeout.millis(250);
    
    public EstudiantTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        estudiant = new Estudiant("Jorge Javier", 3.0, 5.0, 7.0);
        estudiant2 = new Estudiant("Jorge Javier", 3.0, 5.0, 7.0);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testEquals(){
        estudiant = new Estudiant("Jorge Javier", 3.0, 5.0, 7.0);
        estudiant2 = new Estudiant("Jorge Javier", 3.0, 5.0, 7.0);
        assertEquals(true, estudiant.equals(estudiant2));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
