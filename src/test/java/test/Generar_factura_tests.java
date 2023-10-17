/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Clases.Datos;
import Clases.Producto;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.util.Random;
import java.util.Stack;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Esclender
 */
public class Generar_factura_tests {
    private static Datos misDatos;
    String nombre = "JUAN CARLOS ZULUAGA RAMIREZ";
    Stack<Stack> productos = new Stack();
    
    
   public static void setDatos(Datos data) {
        misDatos = data;
    }
    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
        
   }
    
    public String expectedFactura(int FN) {
       String expectedFactura = 
        "***********************************************************************************************\n" +
        "CLIENTE: " + nombre + "\n"+
        "N° FACTURA: " + FN + "\n" +
        "FECHA: " + LocalDate.now() + "\n" +
        "PROVEDOR: MJ-STORE\n" +
        "-----------------------------------------------------------------------------------------------------------------------\n" +
        "CODIGO           PRODUCTO             PRECIO                                                             CANTIDAD\n" +
        "-----------------------------------------------------------------------------------------------------------------------\n" +
        "1             Pijamas de algodon    S/ 25                                                                                    10\n" +
        "-----------------------------------------------------------------------------------------------------------------------\n" +
        "                                                                                                                          TOTAL       S/250\n" +
        "***********************************************************************************************\n";
       return expectedFactura;
   } 
    
   @Test
   public void GenerarFactura() {
        Stack product1 = new Stack() ;//STACK DE LOS PRODUCTOS
        product1.add(0);
        product1.add("10");
        
        Stack cliente = new Stack();//STACK DE CLIENTE
        cliente.add(nombre);
        
        productos.add(cliente);
        productos.add(product1);
        Stack response = misDatos.generarFactura(productos);
        String expectedResponse = expectedFactura((int) response.get(1));
        
        
        
        assertEquals(expectedResponse, response.get(0)  );
   }
    
}
