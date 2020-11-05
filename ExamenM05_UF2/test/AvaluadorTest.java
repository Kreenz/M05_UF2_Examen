/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import examenm05_uf2.Avaluador;
import examenm05_uf2.Estudiant;
import java.util.Arrays;
import java.util.Collection;
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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Oriol Fornos Cuni
 */
@RunWith(Parameterized.class)
public class AvaluadorTest {
    
    static Avaluador avaluador;
        
    static Estudiant estudiant;
    
    static Estudiant[] estudiants = new Estudiant[6];
    
    static Estudiant[] estudiants1 = new Estudiant[5];
    
    
    @Parameter(0)
    public static Estudiant estudiant1;
    
    @Parameter(1)
    public static Estudiant estudiant2;
    
    @Parameter(2)
    public static Estudiant estudiant3;
    
    @Parameter(3)
    public static Estudiant estudiant4;
    
    @Parameter(4)
    public static Estudiant estudiant5;
    
    @Parameter(5)
    public static Estudiant esutidantBo; //resultat de la array d'estudiants
    
    @Parameter(6)
    public static Estudiant estudiantMetodes;
    
    @Parameter(7)
    public static double resultatSiSupera;
    
    @Parameter(8)
    public static double resultatMitjana;
    
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule 
    public Timeout timeout = Timeout.millis(250);
    
    @Parameters
    public static Collection<Object[]> data() {
        
        Object[][] data = new Object[][] {
            { //0
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 3.0, 5.0, 7.0),
               new Estudiant("Josemi Gepardo", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 10.0, 10.0, 10.0),//Este es respuesta a los de arriba
               new Estudiant("Noemi Castillo", 3.0, 5.0, 7.0),
               0.0,
               5.0
            },
            { //1
               new Estudiant("Juan Rodrigez", 0.0, 5.0, 3.0),
               new Estudiant("Jorge Javier", 5.0, 6.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 3.0, 5.0, 7.0),
               new Estudiant("Josemi Gepardo", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Jose Guiterrez", 7.0, 7.0, 7.0),
               7.0,
               7.0
            },
            { //2
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //3
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 10.0, 10.0, 10.0),
               new Estudiant("Alex Casanovas", 7.0, 7.0, 7.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Jorge Hernandez", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 8.0, 8.0 ,8.0),
               8.0,
               8.0
            },
            { //4
               new Estudiant("Juan Rodrigez", 5.0, 3.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 3.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 2.0, 5.0, 4.0),
               new Estudiant("Josemi Gepardo", 2.0, 2.0, 2.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 3.0, 2.0 ,7.0),
               0.0,
               4.0
            },
            { //5
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 8.0, 8.0, 8.0),
               new Estudiant("Alex Casanovas", 7.0, 7.0, 7.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Jorge Hernandez", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 3.0, 5.0 ,5.0),
               0.0,
               4.33
            },
            { //6
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 5.0),
               new Estudiant("Jorge Hernandez", 3.0, 3.0, 3.0),
               new Estudiant("Alex Casanovas", 1.0, 3.0, 3.0),
               new Estudiant("Josemi Gepardo", 2.0, 2.0, 2.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 5.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 4.0, 4.0 ,4.0),
               4.0,
               4.0
            },
            { //7
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //8
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //9
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //10
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //11
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //12
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //13
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            },
            { //14
               new Estudiant("Juan Rodrigez", 5.0, 5.0, 5.0),
               new Estudiant("Jorge Javier", 5.0, 7.0, 3.0),
               new Estudiant("Jorge Hernandez", 3.0, 5.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0),
               new Estudiant("Josemi Gepardo", 7.0, 7.0, 7.0),
               new Estudiant("Alex Casanovas", 10.0, 10.0, 10.0), //Respuesta a los de arriba
               new Estudiant("Alex Casado", 5.0, 6.0 ,7.0),
               6.0,
               6.0
            }
        };
        
        return Arrays.asList(data);
    }

    
    public AvaluadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        avaluador = new Avaluador(10.0, 0.0, 4.0);
    }
    
    @AfterClass
    public static void tearDownClass() {
        //cuando acaba la clase
    }
    
    @Before
    public void setUp() {
        //antes de cada testt
    }
    
    @After
    public void tearDown() {
       //despues de cada test
    }

    @Test
    public void testMitjanaSiSupera() throws Exception{
        assertEquals(resultatSiSupera, avaluador.mitjanaSiSupera(estudiantMetodes), 0.01);
    }
    
    //Test parametritzat
    @Test
    public void testMillorEstudiant1() throws Exception {
        estudiants1[0] = estudiant1;
        estudiants1[1] = estudiant2;
        estudiants1[2] = estudiant3;
        estudiants1[3] = estudiant4;
        estudiants1[4] = estudiant5;
        
        assertEquals(esutidantBo.getNombre(), avaluador.millorEstudiantPerNotaMitjana(estudiants1).getNombre());
    }
    
    //Normal
    @Test
    public void testMillorEstudiant2() throws Exception {
        estudiant = new Estudiant("Juan Martinez", 10.0, 10.0, 10.0);
        estudiants[0] = new Estudiant("Juan Martinez", 5.0, 5.0, 5.0);
        estudiants[1] = new Estudiant("Pepe Rodrigez", 5.0, 5.0, 5.0);
        estudiants[2] = new Estudiant("Jorge Javier", 5.0, 5.0, 5.0);
        estudiants[3] = new Estudiant("Anna Martinez", 5.0, 5.0, 5.0);
        estudiants[4] = new Estudiant("Alex Casado", 5.0, 5.0, 5.0);
        estudiants[5] = new Estudiant("Rodrigo Jimenez", 5.0, 5.0, 5.0);

        assertEquals(estudiant.getNombre(), avaluador.millorEstudiantPerNotaMitjana(estudiants).getNombre());
    }
    
    @Test
    public void testMitjana() throws Exception {
        assertEquals(resultatMitjana, avaluador.mitjana(estudiantMetodes), 0.01);
    }
    
    @Test
    public void testMitjanaWithNulls() throws Exception {
        exception.expect(Exception.class);
        exception.expectCause(CoreMatchers.isA(IllegalAccessException.class));
        exception.expectMessage("Estudiant no pot ser null");
        assertEquals(6.0, avaluador.mitjana(null),0.01);
    }
    
}
