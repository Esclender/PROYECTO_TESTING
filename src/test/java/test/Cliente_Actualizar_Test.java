/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Clases.Cliente;
import Clases.Datos;
import Clases.Usuario;
import java.nio.file.AccessDeniedException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Esclender
 */
public class Cliente_Actualizar_Test {
   private static Datos misDatos;
   private final String idUsuario ="cramirez";
   private final String idCliente = "4885963";
   private final String InvalidoidCliente = "58906936";
   private final int tipoIdentificacion = 1;
   private final String nombres = "Esclender Antonio";
   private final String apellidos = "Lugo Silva";
   private final String direccion = "JR FLROIDA 47";
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
   @DisplayName("Tipo de usuario valido")
   public void usuarioValido(){
       System.out.println();
       Usuario miUsuario = misDatos.getUsuarios()[0];
       boolean response = miUsuario.getPerfil() == 1;
       assertTrue(response);
   }
   
   @Test
   @DisplayName("Actualizar info de un cliente, con id invalido")
   public void ClienteInvalido(){
       String response = misDatos.actualizarCliente(InvalidoidCliente, idUsuario, miCliente);
       assertEquals("No encontrado", response );
   }
   
   @Test
   @DisplayName("Actualizar info de un cliente")
   public void ActualizarCliente(){
       String response = misDatos.actualizarCliente(idCliente, idUsuario, miCliente);
       assertEquals("Actualizado exitosamente", response );
   }
   
}
