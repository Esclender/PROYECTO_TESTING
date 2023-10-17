package test;


import Clases.Datos;
import Clases.Producto;
import Formularios.frmClientes;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class Productos_tests {
   private static Datos misDatos;
   private static final frmClientes misClientes = new frmClientes();
   private final String idProducto = "147";
   private final String descripcion = "Pijama de algodon" ;
   private final int precio = 120;
   private final int IGV = 1; // 0=0%, 1=10%, 2=16%
   private String nota;
   Producto miProducto = new Producto(idProducto,descripcion,precio,IGV,nota);
   
   public static void setDatos(Datos data) {
        misDatos = data;
   }

    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
        misClientes.setDatos(misDatos);
   }
   
   @Test
   public void AgregarProducto() {
       String msg = misDatos.agregarProducto(miProducto);
       assertEquals("Producto agregado correctamente", msg);
   }
   
   @Test
   public void ActualizarProducto() {
       misDatos.agregarProducto(miProducto);
       int pos = misDatos.posicionProducto(idProducto);
       
       String msg = misDatos.modificarProducto(miProducto, pos);
       assertEquals("Producto modificado correctamente", msg);
   }
   
   @Test
   public void EliminarProducto() {     
       misDatos.agregarProducto(miProducto);
       int pos = misDatos.posicionProducto(idProducto);
       
       String msg = misDatos.borrarProducto(pos);
       assertEquals("Producto borrado correctamente", msg);
   }
   
}
