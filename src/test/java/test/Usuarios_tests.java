package test;

import Clases.Datos;
import Clases.Usuario;
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
public class Usuarios_tests {
   private static Datos misDatos;
   private final String idUsuario = "4885763";
   private final String nombres = "Esclender Aantonio";
   private final String apellidos = "Lugo Silva";
   private final String clave = "1234";
   private final int perfil = 1;
   Usuario miUsuario = new Usuario(idUsuario, nombres, 
           apellidos, clave, perfil);
   
   public static void setDatos(Datos data) {
        misDatos = data;
   }

    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
   }
   
   @Test
   public void AgregarUsuario() {
       String msg = misDatos.agregarUsuario(miUsuario);
       assertEquals("Usuario agregado", msg);
   }
   
   @Test
   public void ActualizarUsuario() {
       misDatos.agregarUsuario(miUsuario);
       int pos = misDatos.posicionUsuario(idUsuario);
       
       String msg = misDatos.modificarUsuario(miUsuario, pos);
       assertEquals("Usuario modificado correctamente", msg);
   }
   
   @Test
   public void EliminarUsuario() {     
       misDatos.agregarUsuario(miUsuario);
       int pos = misDatos.posicionUsuario(idUsuario);
       
       String msg = misDatos.borrarUsuario(pos);
       assertEquals("Usuario borrado correctamente", msg);
   }
   
   
}
