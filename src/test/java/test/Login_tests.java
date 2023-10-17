package test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Clases.Datos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

/**
 *
 * @author Esclender
 */

public class Login_tests {
    private static Datos misDatos;
    String usuarioValido = "cramirez";
    String claveValida = "12345";
    String usuarioInvalido = "usuarioInvalido";
    String claveInvalida = "7895";
    String usuarioEspecialCarac = "usuario@scas/*";
    String claveEscpecialCarac = "7855";

    public static void setDatos(Datos data) {
        misDatos = data;
    }

    
    @BeforeAll
    public static void SetUp() {
        Datos db = new Datos();

        setDatos(db);
    }
    
    
    
    @DisplayName("Campos nullos")
    @Test
    public void isNullValidated() {
        try{
            boolean isNullUser = misDatos.validarLogin(null, null);
            boolean isNullPassword = misDatos.validarLogin(usuarioValido, null);
        }catch(RuntimeException exc){
            String message = exc.getMessage();
            assertTrue(message.equals("Usuario no valido") || message.equals("Password no valido"));
        }
    }
    
    @DisplayName("Campos con caracteres especiales")
    @Test
    public void EspecialCaracters() {
        
        try{
            boolean isEspecial = misDatos.validarLogin(usuarioEspecialCarac, claveEscpecialCarac);
            System.out.println(isEspecial);
        }catch(RuntimeException exc){
            String message = exc.getMessage();
            assertTrue(message.equals("Caracteres especiales en usuario no valido") );
        }
    }

    
    @DisplayName("Login con credenciales validas...")
    @Test
    public void LoginValido() {
        boolean isValidUser = misDatos.validarLogin(usuarioValido, claveValida);
        
        assertTrue(isValidUser);
    }
    
    @DisplayName("Login con credenciales invalidas...")
    @Test
    public void LoginInvalido() {
        boolean isInvalidUser = !misDatos.validarLogin(usuarioInvalido, claveInvalida);

        assertTrue(isInvalidUser);
    }
    
}
