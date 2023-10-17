package Clases;

import Clases.Utilidades;
import static Clases.Utilidades.isAdmin;
import static Clases.Utilidades.existeProducto;
import static Clases.Utilidades.validarUsuarioSinCaracteresEspeciales;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Stack;
import java.lang.reflect.*;

public class Datos {
    
    private int maxUsuario = 50;
    private int maxProducto = 100;
    private int maxCliente = 100;
    
    private Usuario misUsuarios[] = new Usuario[maxUsuario];
    private Producto misProductos[] = new Producto[maxProducto];
    private Cliente misClientes[] = new Cliente[maxCliente];
    
    private int contUsuarios = 0;
    private int contProductos = 0;
    private int contClientes= 0;
    
    private int numFactura = 0;
    
    
    public Datos() {
        
        
        //cargamos usuarios
        cargarUsuarios();
        
        //cargamos productos
        cargarProductos();
        
        //cargamos clientes
        cargarClientes();
        
    }
    
    public void grabarTodo() {
        grabarUsuarios();
        grabarClientes();
        grabarProductos();
    }
    public void grabarUsuarios() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            fw = new FileWriter("Data/usuario.txt");
            pw = new PrintWriter(fw);
            
            for (int i = 0; i < contUsuarios; i++) {
                pw.println(misUsuarios[i].toString());
            }
            
        } catch (Exception ex1) {
            ex1.printStackTrace();
            
        } finally {
            try {
                if (fw != null)
                    fw.close();

            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        
    }
    public void grabarClientes() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            fw = new FileWriter("Data/clientes.txt");
            pw = new PrintWriter(fw);
            
            for (int i = 0; i < contClientes; i++) {
                pw.println(misClientes[i].toString());
            }
            
        } catch (Exception ex1) {
            ex1.printStackTrace();
            
        } finally {
            try {
                if (fw != null)
                    fw.close();

            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }
    public void grabarProductos() {
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try {
            fw = new FileWriter("Data/productos.txt");
            pw = new PrintWriter(fw);
            
            for (int i = 0; i < contProductos; i++) {
                pw.println(misProductos[i].toString());
            }
            
        } catch (Exception ex1) {
            ex1.printStackTrace();
            
        } finally {
            try {
                if (fw != null)
                    fw.close();

            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
    }
    
    public void cargarUsuarios() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File("Data/usuario.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            
            
            int pos;
            String aux ;
            String linea;
            
            String idUsuario;
            String nombres;
            String apellidos;
            String clave;
            int perfil;
            
            while ( (linea = br.readLine()) != null )   {
                //extraemos id usuario
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idUsuario = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos nombres
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                nombres = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos apellidos
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                apellidos = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos clave y perfil
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                clave = aux;
                linea = linea.substring(pos + 1);
                perfil = new Integer(linea);
                
                Usuario miUsuario;
                miUsuario = new Usuario(idUsuario, nombres, apellidos, clave, perfil);
                misUsuarios[contUsuarios] = miUsuario;
                contUsuarios++;
        
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally   {
            try {
                if (fr != null)
                    fr.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } 
    }
    public void cargarProductos() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File("Data/productos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            int pos;
            String aux ;
            String linea;
            
            String idProducto;
            String descripcion;
            int precio;
            int IGV;
            String nota;
            
            while ( (linea = br.readLine()) != null )   {
                //extraemos id producto
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idProducto = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos descripcion
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                descripcion = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos precio
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                precio = new Integer(aux);
                linea = linea.substring(pos + 1);
                
                 //extraemos igv y nota
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                IGV = new Integer(aux);
                linea = linea.substring(pos + 1);
                nota = linea;
                
                Producto miproProducto;
                miproProducto = new Producto(idProducto, descripcion, precio, IGV, nota);
                misProductos[contProductos] = miproProducto;
                contProductos++;
        
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally   {
            try {
                if (fr != null)
                    fr.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } 
    }
    public void cargarClientes() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivo = new File("Data/clientes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            int pos;
            String aux ;
            String linea;
            
            String idCliente;
            int tipoIdentificacion;
            String nombres;
            String apellidos;
            String direccion;
            String telefono;
            int idDistrito = 0;
            Date fechaNacimiento;
            Date fechaIngreso;
            
            while ( (linea = br.readLine()) != null )   {
                //extraemos id cliente
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idCliente = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos tipo identificacion
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                tipoIdentificacion = new Integer(aux);
                linea = linea.substring(pos + 1);
                
                 //extraemos nombres
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                nombres = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos apellidos
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                apellidos = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos direccion
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                direccion = aux;
                linea = linea.substring(pos + 1);
                
                //extraemos telefono
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                telefono = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos id distrito
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idDistrito = new Integer(aux);
                linea = linea.substring(pos + 1);
                
                //extraemos fecha nac. y fecha registro
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                fechaNacimiento = Utilidades.stringToDate(aux);
                linea = linea.substring(pos + 1);              
                fechaIngreso = Utilidades.stringToDate(linea);
                
                Cliente miCliente;
                miCliente = new Cliente(idCliente, tipoIdentificacion, nombres, apellidos, direccion, telefono, 
                        idDistrito,fechaNacimiento, fechaIngreso);
                misClientes[contClientes] = miCliente;
                contClientes++;
        
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally   {
            try {
                if (fr != null)
                    fr.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } 
    }

    
    
    //usuarios
    public String agregarUsuario(Usuario miUsuario) {
        if (contUsuarios == maxUsuario) {
            return "Se ha alcanzado el numero maximo de usuarios";
        }
        
        misUsuarios[contUsuarios] = miUsuario;
        contUsuarios++;
        return "Usuario agregado";
    }
    public String modificarUsuario(Usuario miUsuario, int pos) { 
        misUsuarios[pos].setNombres(miUsuario.getNombres());
        misUsuarios[pos].setApellidos(miUsuario.getApellidos());
        misUsuarios[pos].setClave(miUsuario.getClave());
        misUsuarios[pos].setPerfil(miUsuario.getPerfil());
        return "Usuario modificado correctamente";
    }
    public String borrarUsuario(int pos) {
        for (int i = pos; i < contUsuarios - 1; i++) {
            misUsuarios[i] = misUsuarios[i + 1];
        }
        contUsuarios--;
        return "Usuario borrado correctamente";
    }
    public boolean validarUsuario(String usuario, String clave) {
        boolean aux = false;
                
        for (int i = 0; i < contUsuarios; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario) && 
                    misUsuarios[i].getClave().equals(clave)) {
                return true;
            }
        }
        
        return false;
    }
    public int getPerfil(String usuario) {
        for (int i = 0; i < contUsuarios; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario)) {
                return misUsuarios[i].getPerfil();
            }
        }
        return -1;
    }
    public int posicionUsuario(String usuario) {
        int aux = -1;
        for (int i = 0; i < contUsuarios; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario)) 
                return i;
        }
        
        return -1;
    }
    public int numeroUsuarios() {
        return contUsuarios;
    }
    public Usuario[] getUsuarios() {
        return misUsuarios;
    }
        
    //productos
    public Producto[] getProductos() {
        return misProductos;
    }
    public int numeroProductos() {
        return contProductos;
    }
    public int posicionProducto(String producto) {
        for (int i = 0; i < contProductos; i++) {
            if (misProductos[i].getIdProducto().equals(producto)) 
                return i;
        }
        
        return -1;
    }
    public String agregarProducto(Producto miProducto) {
        if (contProductos == maxProducto) {
            return "Se ha alcanzado el numbero maximo de usuarios";
        }
        
        misProductos[contProductos] = miProducto;
        contProductos++;
        return "Producto agregado correctamente";
    }
    public String modificarProducto(Producto miProducto, int pos) { 
        misProductos[pos].setDescripcion(miProducto.getDescripcion());
        misProductos[pos].setPrecio(miProducto.getPrecio());
        misProductos[pos].setIGV(miProducto.getIGV());
        misProductos[pos].setNota(miProducto.getNota());
        return "Producto modificado correctamente";
    }
    public String borrarProducto(int pos) {
        for (int i = pos; i < contProductos - 1; i++) {
            misProductos[i] = misProductos[i + 1];
        }
        contProductos--;
        return "Producto borrado correctamente";
    }
    
    //clientes
    public Cliente[] getClientes() {
        return misClientes;
    }
    public int numeroClientes() {
        return contClientes;
    }
    public int posicionCliente(String cliente) {
        int aux = -1;
        for (int i = 0; i < contClientes; i++) {
            if (misClientes[i].getIdCliente().equals(cliente)) 
                return i;
        }
        
        return -1;
    }
    public String clienteEspecifico(String idCliente, String idUsuario ) { //
        
        
        for(int i = 0; i < contUsuarios; i++){
            if (misUsuarios[i].getIdUsuario().equals(idUsuario)) 
                if(!isAdmin(misUsuarios[i].getPerfil()))
                    throw new RuntimeException("Usuario no valido");
                    break;
        }
        
        
        for (int i = 0; i < contClientes; i++) {
            if (misClientes[i].getIdCliente().equals(idCliente)) 
                return misClientes[i].getIdCliente();
        }
        return "No encontrado";
    }
    
    public String actualizarCliente(String idCliente, String idUsuario, Cliente miCliente){

        for (int i = 0; i < contUsuarios; i++) {
            if (misUsuarios[i].getIdUsuario().equals(idUsuario)) {
                if (misUsuarios[i].getPerfil() != 1) 
                   throw new RuntimeException("El usuario no tiene permiso para actualizar el cliente");
                
                break;
            }
        }
        
        int pos = this.posicionCliente(idCliente);
        
        if(pos == -1){
            return "No encontrado";
        }
        
        for (int index = 0; index < contClientes; index++) {
            misClientes[pos].setTipoIdentificacion(miCliente.getTipoIdentificacion());
            misClientes[pos].setNombres(miCliente.getNombres());
            misClientes[pos].setApellidos(miCliente.getApellidos());
            misClientes[pos].setDireccion(miCliente.getDireccion());
            misClientes[pos].setTelefono(miCliente.getTelefono());
            misClientes[pos].setIdDistrito(miCliente.getIdDistrito());
            misClientes[pos].setFechaNacimiento(miCliente.getFechaNacimiento());
        }

        return "Actualizado exitosamente";
    }
    
    /*int pos = this.posicionCliente(idCliente);
        
        if(pos == -1){
            return "No encontrado";
        }
    **/
    
    public String eliminarCliente(String idCliente, String idUsuario) {
        
        for (int i = 0; i < contUsuarios; i++) {
            if (misUsuarios[i].getIdUsuario().equals(idUsuario)) {
                if (misUsuarios[i].getPerfil() != 1) 
                   throw new RuntimeException("El usuario no tiene permiso para actualizar el cliente");
                
                break;
            }
        }
        
        int pos = this.posicionCliente(idCliente);
        
        if(pos == -1){
            return "No encontrado";
        }
        
        
        for (int i = pos; i < contClientes - 1; i++) {
            misClientes[i] = misClientes[i + 1];
        }
        contClientes--;
        return "Cliente borrado correctamente";
    }
    
    public String agregarCliente(Cliente miCliente) {
        if (contClientes == maxCliente) {
            return "Se ha alcanzado el numero maximo de clientes";
        }
        
        misClientes[contClientes] = miCliente;
        contClientes++;
        return "Cliente agregado correctamente";
    }
    public String modificarCliente(Cliente miCliente, int pos) { 
        misClientes[pos].setTipoIdentificacion(miCliente.getTipoIdentificacion());
        misClientes[pos].setNombres(miCliente.getNombres());
        misClientes[pos].setApellidos(miCliente.getApellidos());
        misClientes[pos].setDireccion(miCliente.getDireccion());
        misClientes[pos].setTelefono(miCliente.getTelefono());
        misClientes[pos].setIdDistrito(miCliente.getIdDistrito());
        misClientes[pos].setFechaNacimiento(miCliente.getFechaIngreso());
        misClientes[pos].setFechaIngreso(miCliente.getFechaNacimiento());
        return "Cliente modificado correctamente";
    }
    
    public String borrarCliente(int pos) {
        for (int i = pos; i < contClientes - 1; i++) {
            misClientes[i] = misClientes[i + 1];
        }
        contClientes--;
        return "Cliente borrado correctamente";
    }
    
    public String agregarProductoEnFactura(Stack prudctos) {
        String lista = "";
        int index = 0 ;
        
        for (int i = 0; i < prudctos.size(); i++) {
            boolean isExist = existeProducto((String) prudctos.get(i), misProductos);
            if(isExist){
                lista += prudctos.get(i) + "\n";
            }
         }
        
        return "Tus productos: \n" + lista ;
    }
    
    public Stack generarFactura(Stack<Stack> productos) {
        String lista = "";
        Random rand = new Random();
        int FN = rand.nextInt(1000);
        Stack facturaYfn = new Stack();
        
        Producto[] data = misProductos;
        int total = 0;
        
        lista += "***********************************************************************************************\n";
        lista += "CLIENTE: " + productos.get(0).get(0) + "\n";
        lista +="N° FACTURA: " + FN + "\n";
        lista +="FECHA: " + LocalDate.now() + "\n";
        lista +="PROVEDOR: MJ-STORE\n";
        lista +="-----------------------------------------------------------------------------------------------------------------------\n";
        lista +="CODIGO           PRODUCTO             PRECIO                                                             CANTIDAD\n";
        lista +="-----------------------------------------------------------------------------------------------------------------------\n";
        for(int i = 1; i < productos.size(); i++ ){
            int pIn = (int) productos.get(i).get(0);
            String id = data[pIn].getIdProducto();
            String name = data[pIn].getDescripcion();
            int precio = data[pIn].getPrecio();
            String cantidad = (String) productos.get(i).get(1);
            total += precio * parseInt(cantidad);
            lista += id + "             "  + name + "    S/ " + precio  + "                                                                                    " + cantidad + "\n";
          
        }
        
        lista +="-----------------------------------------------------------------------------------------------------------------------\n";
        lista +="                                                                                                                          TOTAL       ";
        lista +="S/" + total + "\n";
        lista +="***********************************************************************************************\n";
        
        facturaYfn.add(lista);
        facturaYfn.add(FN);
        
        return  facturaYfn ;
    }
    /**for (int i = 0; i < contUsuarios; i++) {
                pw.println(misUsuarios[i].toString());
            }**/
    
    public void GrabarUsuario(Usuario user, String path) throws IllegalArgumentException, IllegalAccessException {
        FileWriter fw = null;
        PrintWriter pw = null;
        String registro = "";
        
        for (Field field : user.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object valor = field.get(user);
            registro += valor + "|";
        }
       
        
        try {
            File archivo = new File(path);

            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw, true);
            for (int i = 0; i < contUsuarios; i++) {
                pw.println(misUsuarios[i].toString());
            }
            pw.println(registro );
            
            misUsuarios[contUsuarios] = user;
            contUsuarios++;
            
            
        } catch (Exception ex1) {
            ex1.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();

            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }
        
    }
    
    public String cargarCliente() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String info = "";
        
        try {
            archivo = new File("Data/clientes.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
            int pos;
            String aux ;
            String linea;
            
            String idCliente;
            int tipoIdentificacion;
            String nombres;
            String apellidos;
            String direccion;
            String telefono;
            int idDistrito = 0;
            Date fechaNacimiento;
            Date fechaIngreso;
            
            while ( (linea = br.readLine()) != null )   {
                //extraemos id cliente
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idCliente = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos tipo identificacion
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                tipoIdentificacion = new Integer(aux);
                linea = linea.substring(pos + 1);
                
                 //extraemos nombres
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                nombres = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos apellidos
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                apellidos = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos direccion
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                direccion = aux;
                linea = linea.substring(pos + 1);
                
                //extraemos telefono
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                telefono = aux;
                linea = linea.substring(pos + 1);
                
                 //extraemos id distrito
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                idDistrito = new Integer(aux);
                linea = linea.substring(pos + 1);
                
                //extraemos fecha nac. y fecha registro
                pos = linea.indexOf('|');
                aux = linea.substring(0, pos);
                fechaNacimiento = Utilidades.stringToDate(aux);
                linea = linea.substring(pos + 1);              
                fechaIngreso = Utilidades.stringToDate(linea);
                
                Cliente miCliente;
                miCliente = new Cliente(idCliente, tipoIdentificacion, nombres, apellidos, direccion, telefono, 
                        idDistrito,fechaNacimiento, fechaIngreso);
                System.out.println(miCliente);
                info += miCliente + "\n";//SE AGREGA LA INFO
                misClientes[contClientes] = miCliente;
                contClientes++;
            }
            
                
            return info;
            
        } catch (Exception e) {
            e.printStackTrace();
        
        } finally   {
            try {
                if (fr != null)
                    fr.close();
                
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } 
        return "";
    }
    
    
    public boolean validarLogin(String usuario, String clave) {
        
        
        if (usuario == null || usuario.isEmpty() || clave == null || clave.isEmpty()) {
            throw new RuntimeException("Usuario no valido");
        }
        
        if (!validarUsuarioSinCaracteresEspeciales(usuario)) {
            throw new RuntimeException("Caracteres especiales en usuario no valido");
        }
        
        if (usuario == null || usuario.isEmpty() || clave == null || clave.isEmpty()) {
            throw new RuntimeException("Password no valido");
        }
        
        for (int i = 0; i < contUsuarios; i++) {
            if (misUsuarios[i].getIdUsuario().equals(usuario) && 
                    misUsuarios[i].getClave().equals(clave)) {
                return true;
            }
        }
        
        return false;
    }
    
     //factura
     public int getNumFac() {
         return numFactura;
     }
     public  void setNumFac(int numFac) {
         this.numFactura = numFac;
     }
}
