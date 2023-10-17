/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Clases.Datos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Esclender
 */
public class Clientes_eliminar_Test {
   private static Datos misDatos;
   private final String idUsuario ="cramirez";
   private final String idUsuarioInvalido ="elugo";
   private final String idCliente = "4885963";
   private final String idClienteInvalido = "5886733";
   
   public static void setDatos(Datos data) {
        misDatos = data;
   }

    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
   }
   
   @Test
   @DisplayName("Eliminar los datos de un cliente")
   public void EliminarCliente(){
       String expectedResponse = "Cliente borrado correctamente";
       
       assertEquals(expectedResponse, misDatos.eliminarCliente(idCliente, idUsuario));
   }
   
   @Test
   @DisplayName("Validacion de credenciales")
   public void usuarioNoPermitido(){
       String expectedResponse = "El usuario no tiene permiso para actualizar el cliente";
       
       assertEquals(expectedResponse, misDatos.eliminarCliente(idCliente, idUsuarioInvalido));       
   } 
   
   @Test
   @DisplayName("Validacion de existencia de cliente")
   public void clienteNoExiste(){
       String expectedResponse = "El cliente no existe";
       
       assertEquals(expectedResponse, misDatos.eliminarCliente(idClienteInvalido, idUsuario));       
   } 
   
   @Test
   @DisplayName("Validacion de existencia de usuario..")
   public void usuarioNoExiste(){
       String expectedResponse = "El usuario no existe";
       
       assertEquals(expectedResponse, misDatos.eliminarCliente(idCliente, idUsuarioInvalido));       
   } 
   
   
}
