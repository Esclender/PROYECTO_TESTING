/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Clases.Datos;
import Clases.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Esclender
 */
public class Grabar_usuario_test {
   private static Datos misDatos;
   private final String path1 = "Data/usuario.txt";
   private final String path2 = "Data/usuarios2.txt";
   private final String idUsuario = "elugo";
   private final String nombres = "Esclender Aantonio";
   private final String apellidos = "Lugo Silva";
   private final String clave = "1234";
   private final int perfil = 1;
   private final String idUsuario2 = "cramirez";
   private final String nombres2 = "christian";
   private final String apellidos2 = "ramirez";
   private final String clave2 = "12345";
   private final int perfil2 = 1;
   Usuario miUsuario = new Usuario(idUsuario, nombres, 
           apellidos, clave, perfil);
   Usuario miUsuario2 = new Usuario(idUsuario2, nombres2, 
           apellidos2, clave2, perfil2);
   
   
   public static void setDatos(Datos data) {
        misDatos = data;
   }
   
   public static void set(Datos data) {
        misDatos = data;
   }

    
   @BeforeAll
   public static void SetUp() {
        Datos db = new Datos();
        setDatos(db);
   }
   
   
   
   @Test
     public void OrdenCorrecto() throws IllegalArgumentException, 
               IllegalAccessException, FileNotFoundException, IOException{
         //4885763Esclender AantonioLugo Silva12341
          misDatos.GrabarUsuario(miUsuario, path1);
          
          File archivo = new File("Data/usuario.txt");
          FileReader fr = new FileReader(archivo);
          BufferedReader br = new BufferedReader(fr);

          String linea1 = br.readLine();
          String linea2 = br.readLine(); // Lee la segunda línea
          br.close();
          
          
          String reponse = linea1 + linea2;
          String expected = "4885763Esclender AantonioLugo Silva12341";
          System.out.println(reponse);
          
          assertTrue(!expected.contains(reponse));
     } 
   
   @Test
     public void UsuariosUnicaVezEscrito() throws IllegalArgumentException, 
               IllegalAccessException, FileNotFoundException, IOException{
         //
          misDatos.GrabarUsuario(miUsuario, path1);
          
          File archivo = new File("Data/usuario.txt");
          FileReader fr = new FileReader(archivo);
          BufferedReader br = new BufferedReader(fr);

          String linea1 = br.readLine();
          String linea2 = br.readLine(); // Lee la segunda línea
          br.close();
          
          
          String reponse = linea1 + linea2;
          String expected = "cramirez|christian|ramirez|12345|1null";
          
          assertTrue(!expected.contains(reponse));
     } 
     
     @Test
     public void dobleRegistro() throws IllegalArgumentException, 
               IllegalAccessException, FileNotFoundException, IOException{
         //4885763Esclender AantonioLugo Silva12341
          misDatos.GrabarUsuario(miUsuario, path1);
          misDatos.GrabarUsuario(miUsuario2, path1);
          misDatos.GrabarUsuario(miUsuario2, path1);
          
          File archivo = new File("Data/usuario.txt");
          FileReader fr = new FileReader(archivo);
          BufferedReader br = new BufferedReader(fr);

          String linea1 = br.readLine();
          String linea2 = br.readLine(); 
          String linea3 = br.readLine(); 
          br.close();
          
          
          String reponse = linea1 + "\n" + linea2 + "\n" + linea3;
          String expected = "cramirez|christian|ramirez|12345|1" +"\n"
                  + "elugo|Esclender Aantonio|Lugo Silva|1234|1" +"\n"
                  + "elugo|Esclender Aantonio|Lugo Silva|1234|1";
          System.out.println(reponse+" doble");
          
          assertEquals(expected, reponse);
     } 
     
     @Test
     public void saltoDeLinea() throws IllegalArgumentException, 
               IllegalAccessException, FileNotFoundException, IOException{
         //4885763Esclender AantonioLugo Silva12341
         misDatos.GrabarUsuario(miUsuario2, path1);
          misDatos.GrabarUsuario(miUsuario, path1);
          
          File archivo = new File("Data/usuario.txt");
          FileReader fr = new FileReader(archivo);
          BufferedReader br = new BufferedReader(fr);

          String linea1 = br.readLine();
          String linea2 = br.readLine();
          br.close();
          
          String reponse = linea1 + "\n" + linea2 ;
          String expected = "cramirez|christian|ramirez|12345|1" +"\n"
                 + "elugo|Esclender Aantonio|Lugo Silva|1234|1|" ;
          
          assertEquals(expected, reponse);
     } 
   
     @Test
     public  void GrabarUsuario() throws IllegalArgumentException, 
               IllegalAccessException, FileNotFoundException, IOException{
          misDatos.GrabarUsuario(miUsuario, path2);
          File archivo = new File("Data/usuario.txt");
          FileReader fr = new FileReader(archivo);
          BufferedReader br = new BufferedReader(fr);

          String linea1 = br.readLine(); // Lee la primera línea
          String linea2 = br.readLine(); // Lee la segunda línea
          System.out.println(linea2);

          String expected = "elugo|Esclender Aantonio|Lugo Silva|1234|1";
          assertEquals(expected, linea2);
     }    
     
     @AfterAll
     public static void eliminarRegistros() throws IOException{
        FileWriter fw = null;
        PrintWriter pw = null;
        String registro = "";
        
        File archivo = new File("Data/usuario.txt");
        fw = new FileWriter(archivo);
        pw = new PrintWriter(fw, true);
        pw.println(registro );
     }
     
}
