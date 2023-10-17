/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import Clases.Cliente;
import Clases.Datos;
import Clases.Utilidades;
import Formularios.frmClientes;
import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;


/**
 *
 * @author Esclender
 */
public class Cliente_Especifico_Tests {
   private static Datos misDatos;
   private final String idUsuario ="cramirez";
   private final String idCliente = "4885763";
   private final int tipoIdentificacion = 1;
   private final String nombres = "Esclender Antonio";
   private final String apellidos = "Lugo Silva";
   private final String direccion = "JR FLROIDA 47";
   private final String telefono = "928590695";
   private final int idDistrito = 24;
   private final Date fechaNacimiento = new Date(2004,8,8);
   private final Date fechaIngreso = new Date();
   private final String telefonoActualizado = "958695230";
   Cliente miCliente = new Cliente(idCliente, tipoIdentificacion, 
                nombres, apellidos, direccion, telefonoActualizado, 
                idDistrito, fechaNacimiento, fechaIngreso);

   
   public static void setDatos(Datos data) {
        misDatos = data;
   }

    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
   }

   @Test
   @DisplayName("Id de cliente valido")
   public void idClienteValido(){
       String isString = ((Object)idCliente).getClass().getSimpleName();
       
       assertTrue("String".equals(isString));       
   }   
   
   
   @Test
   @DisplayName("Id de Usuario valido")
   public void idUsuarioValido(){
       String isString = ((Object)idUsuario).getClass().getSimpleName();
       
       assertTrue("String".equals(isString));       
   }  
   
   @Test
   @DisplayName("Rol de usuario es reconocido como admin")
   public void isValidRol(){
       boolean isAdmin = Utilidades.isAdmin(1);
       
       assertTrue(isAdmin);       
   }    
   
   
   @Test
   @DisplayName("Obtener cliente especifico")
   public void obtenerCliente(){
       String idClienteExpected = miCliente.getIdCliente();
       
       assertEquals(idClienteExpected, misDatos.clienteEspecifico(idCliente, idUsuario));       
   }  
   
   
   
   
   
}
