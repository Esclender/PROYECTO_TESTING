/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Clases.Datos;
import Clases.Producto;
import Formularios.frmFactura;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Esclender
 */
public class Facturas_tests {
    private static Datos misDatos;
    Stack products = new Stack();
    
   public static void setDatos(Datos data) {
        misDatos = data;
    }
    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
   }
    
    @Test
    public void AgregarProductosEnFactura() {
        String expectedResponse = "Tus productos: \n" + "Pijamas de algodon\n" ;
        products.add("Pijamas de algodon");
        products.add("Pijama de Seda");
        
        assertEquals(expectedResponse, 
                misDatos.agregarProductoEnFactura(products));
    }
    
    
}
