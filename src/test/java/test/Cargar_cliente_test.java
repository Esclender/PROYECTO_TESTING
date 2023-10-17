package test;

import Clases.Datos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Esclender
 */
public class Cargar_cliente_test {
    private static Datos misDatos;
    String usuarioValido = "cramirez";
    String claveValida = "12345";
    
    public static void setDatos(Datos data) {
        misDatos = data;
    }

    
    @BeforeAll
    public static void SetUp() {
        Datos db = new Datos();

        setDatos(db);
    }
    
    @Test
    public void isNotArray(){
        assertTrue( !misDatos.cargarCliente().getClass().isArray());
    }
    
    @Test
    public void isString(){
        assertTrue(String.class == misDatos.cargarCliente().getClass());//
    }
    
    
    
    
    @Test
    public void CargarUsuarios(){
        String expectedResponse = 
                "4885963|1|Juan Carlos|Zuluaga ramirez|Lt 5 mz S|123-1234|1|1974/09/23|2014/12/10\n" +
                "5789610|2|Esclender Lugo|Zuluaga ramirez|Lt 5 mz S|123-1234|1|1974/09/23|2014/12/10\n" +
                "7896312|1|GERSON ARCENTALES|Zuluaga ramirez|Lt 5 mz S|123-1234|1|1974/09/23|2014/12/10" +"\n";
        
        assertEquals(expectedResponse, misDatos.cargarCliente());
    }
}
