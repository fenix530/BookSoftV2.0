
package booksoftv2.pkg0;

import java.util.Scanner;
import java.sql.*;

public class BookSoftV20 {
    
        public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in);
        int n=0,p=0;
        String x,nombre,autor,año,codigo,cantidad,area;
        int cantidad1,id=0;
        boolean salir=true,areaV=true;
        
        String user = "usuariocrm";
        String password="12345";
        String user2 = "fenix530"; //db4free.net
        String password2="15131e";//db4free.net
        ResultSet resultado;
        try
        {     
            System.out.println("Intentando Conectar a la base de datos...");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/crm", user, password);//local
            //Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net/contactosdao", user2, password2); //online        
             System.out.println("Conexion Exitosa...");
             Statement estado=con.createStatement();
            do
            {
            System.out.println("Programa Administracion de Libros");
            System.out.println("");
            System.out.println("1. Ingresar Libro");
            System.out.println("2. Actualizar Libro");
            System.out.println("3. Eliminar Libro");
            System.out.println("4. Buscar Libro");
            System.out.println("5. Prestar Libro");
            System.out.println("6. Devolver Libro");
            System.out.println("7. Lista de Prestamos");
            System.out.println("8. Salir");
            System.out.println("");
            System.out.print("Seleccione la Opcion Deseada: ");
            x=teclado.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
            switch (x)
            {
                case "1":
                    System.out.println("Ingrese el Nombre del Libro");
                    nombre=teclado.next();              
                    System.out.println("Ingrese El Autor del Libro");
                    autor=teclado.next();
                    System.out.println("Ingrese El año de Publicacion");
                    año=teclado.next();;
                    System.out.println("Ingrese el Codigo");
                    codigo=teclado.next();
                    System.out.println("Ingrese la Cantidad de libros");
                    cantidad=teclado.next();
                    cantidad1=Integer.parseInt(cantidad);
                    do
                    {
                        System.out.println("Selccione el Area del Libro");
                        System.out.println("");
                        System.out.println("1.Qumica");
                        System.out.println("2.Fisica");
                        System.out.println("3.Tecnologia");
                        System.out.println("4.Calculo");
                        System.out.println("5.Programacion");
                        System.out.println("");
                        System.out.println("El Area del Libro es: ");
                        area=teclado.next();
                        switch (area)
                                {
                            case "1":
                                area="Qumica";
                                areaV=false;
                                break;
                            case "2":
                                area="Fisica";
                                areaV=false;
                                break;
                            case "3":
                                area="Tecnologia";
                                areaV=false;
                                break;
                            case "4":
                                area="Calculo";
                                areaV=false;
                                break;
                            case "5":
                                area="Programacion";
                                areaV=false;
                                break;
                            default:
                                System.out.println("Ingrese una Opcion Coreecta");
                                break;
                        }                            
                        }
                    while(areaV);
                    estado.execute("INSERT INTO `libro` (`ID`, `Nombre`, `autor`, `año`, `codigo`, `area`, `Cantidad`, `Prestamo`) VALUES (NULL,'"+nombre+"','"+autor+"','"+año+"','"+codigo+"','"+area+"','"+cantidad1+"','0')");
                    System.out.println("Libro Ingresado Con Exito, Presione Enter para volver al Menu Anterior");
                    id=0;
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "2":
                    System.out.println("Ingrese el nombre del Libro que desea Actualizar");
                    nombre=teclado.nextLine();
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+nombre+"'");
                    while(resultado.next())//imprimiendo Base de datos
                    {
                        id=resultado.getInt("ID");                                                  
                    }
                    if(id>0)
                    {
                        System.out.println("Ingrese el Nombre del Libro");
                        nombre=teclado.next();              
                        System.out.println("Ingrese El Autor del Libro");
                        autor=teclado.next();
                        System.out.println("Ingrese El año de Publicacion");
                        año=teclado.next();;
                        System.out.println("Ingrese el Codigo");
                        codigo=teclado.next();
                        System.out.println("Ingrese la Cantidad de libros");
                        cantidad=teclado.next();
                        cantidad1=Integer.parseInt(cantidad);
                        do
                    {
                        System.out.println("Selccione el Area del Libro");
                        System.out.println("");
                        System.out.println("1.Qumica");
                        System.out.println("2.Fisica");
                        System.out.println("3.Tecnologia");
                        System.out.println("4.Calculo");
                        System.out.println("5.Programacion");
                        System.out.println("");
                        System.out.println("El Area del Libro es: ");
                        area=teclado.next();
                        switch (area)
                                {
                            case "1":
                                area="Qumica";
                                areaV=false;
                                break;
                            case "2":
                                area="Fisica";
                                areaV=false;
                                break;
                            case "3":
                                area="Tecnologia";
                                areaV=false;
                                break;
                            case "4":
                                area="Calculo";
                                areaV=false;
                                break;
                            case "5":
                                area="Programacion";
                                areaV=false;
                                break;
                            default:
                                System.out.println("Ingrese una Opcion Coreecta");
                                break;
                        }                            
                        }
                    while(areaV);
                    estado.execute("UPDATE `libro` SET `Nombre`='"+nombre+"',`autor`='"+autor+"',`año`='"+año+"',`codigo`='"+codigo+"',`area`='"+area+"',`Cantidad`='"+cantidad1+"' WHERE `ID` LIKE "+id+"");                   
                    }
                    else
                        System.out.println("El Libro NO exites, por favor Ingereselo Primero...");
                    System.out.println("");
                    System.out.println("Presione ENTER para volver al Menu ANterior.");
                    id=0;
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "3":
                    System.out.println("Ingrese el nombre del Libro que desea Eliminar");
                    nombre=teclado.next();
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+nombre+"'");
                    while(resultado.next())//imprimiendo Base de datos
                    {
                        id=resultado.getInt("ID");                                                  
                    } 
                    if(id>0)
                    {
                        estado.execute("DELETE FROM `libro` WHERE `ID` LIKE "+id);
                        System.out.println("Libro Eliminado...");
                    }
                    else
                        System.out.println("El Libro no existe, Imposible Eliminar");
                    System.out.println("Presione ENTER para volver al Menu ANterior.");
                    id=0;
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "4":
                    System.out.println("Ingrese el nombre del Libro que desea Buscar");
                    nombre=teclado.next();
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+nombre+"'");
                    while(resultado.next())
                    {
                        id=resultado.getInt("ID");                                                  
                    }
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+nombre+"'");
                    if(id>0)
                    {
                        while(resultado.next())
                        {
                            System.out.println(" Nombre: "+resultado.getString("Nombre")+"\n Autor: "+resultado.getString("autor")+"\n Año de Publicacion: "+resultado.getString("año")+"\n Codigo: "+resultado.getString("codigo")+"\n Area: "+resultado.getString("area")+"\n Libros Disponibles: "+resultado.getString("Cantidad")+"\n En Prestamo: "+resultado.getString("Prestamo"));
                        }
                    }
                    else
                    {
                        System.out.println("El Libro no Existe, Ingreselo Por favor Ingreselo");
                    }
                    System.out.println("Presione ENTER para volver al Menu ANterior.");
                    id=0;
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "5":
                    String R="0";
                    boolean pass=true;
                    int a;
                    System.out.println("Ingrese el nombre del Libro que desea Prestar");
                    nombre=teclado.next();
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+nombre+"'");
                    while(resultado.next())
                    {
                        id=resultado.getInt("ID");
                        n=resultado.getInt("Cantidad");
                        p=resultado.getInt("Prestamo");
                    }
                    resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+nombre+"'");
                    if(id>0)
                    {
                        System.out.println("Esto son los datos del Libro");
                        System.out.println("");
                        while(resultado.next())
                        {
                            System.out.println(" Nombre: "+resultado.getString("Nombre")+"\n Autor: "+resultado.getString("autor")+"\n Año de Publicacion: "+resultado.getString("año")+"\n Codigo: "+resultado.getString("codigo")+"\n Area: "+resultado.getString("area")+"\n Libros Disponibles: "+resultado.getString("Cantidad")+"\n En Prestamo: "+resultado.getString("Prestamo"));
                        }
                        System.out.println("");
                        do
                        {
                            System.out.println("Desea Prestar el Libro: ");
                            System.out.println("1.Si");
                            System.out.println("2.No");
                            R=teclado.next();
                            a=Integer.parseInt(R);
                            if(a==1 || a==2)
                                pass=false;
                        }
                        while(pass);
                        if(a==1 && n>0)
                        {
                            System.out.println("");
                            System.out.println("Ingrese el Numero de Su Cedula: ");
                            R=teclado.next();
                            n=n-1;
                            p=p+1;
                            estado.execute("UPDATE `libro` SET `Prestamo`='"+p+"',`Cantidad`='"+n+"' WHERE `ID` LIKE "+id+"");
                            estado.execute("INSERT INTO `prestamo`(`ID`, `Cedula`, `Nombre`) VALUES (NULL,'"+R+"','"+nombre+"')");
                            System.out.println("");
                            System.out.println("Libro Prestado con Exito, Que lo Disfutes");
                        }
                        if(n==0)
                            System.out.println("No hay Libros Disponibles");                        
                    }
                    else
                       System.out.println("Este libro no exite en la Biblioteca");
                    System.out.println("");
                    System.out.println("Presione ENTER para volver al Menu ANterior.");
                    id=0;
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "6":
                    String Dev;
                    System.out.println("Ingrese El Numero de la Cedula con la que el Libro esta Regitrado");
                    Dev=teclado.next();
                    resultado=estado.executeQuery("SELECT * FROM `prestamo` WHERE `Cedula` LIKE '"+Dev+"'");
                    while(resultado.next())
                    {
                        id=resultado.getInt("ID");
                        Dev=resultado.getString("Nombre");
                    }
                    System.out.println(id);
                    if(id>0)
                    {
                        estado.execute("DELETE FROM `prestamo` WHERE `ID` LIKE "+id);
                        resultado=estado.executeQuery("SELECT * FROM `libro` WHERE `Nombre` LIKE '"+Dev+"'");
                        while(resultado.next())
                        {
                            id=resultado.getInt("ID");
                            n=resultado.getInt("Cantidad");
                            p=resultado.getInt("Prestamo");
                        }
                        n=n+1;
                        p=p-1;
                        estado.execute("UPDATE `libro` SET `Prestamo`='"+p+"',`Cantidad`='"+n+"' WHERE `ID` LIKE "+id+"");
                        System.out.println("Libro Devuelto con Exito...");
                    }
                    else
                        System.out.println("No hay Libros En prestamo para este Numero de Cedula");
                    System.out.println("Presione ENTER para volver al Menu ANterior.");
                    id=0;
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "7":
                    resultado=estado.executeQuery("SELECT * FROM `prestamo`");
                    System.out.println("Cedula                  Libro Prestado");
                    while(resultado.next())
                    {                        
                        System.out.println(resultado.getString("Cedula")+"                  "+resultado.getString("Nombre"));
                    }
                    System.out.println("");
                    System.out.println("Presione ENTER para volver al Menu ANterior.");
                    teclado.nextLine();
                    teclado.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                case "8":
                    salir=false;
                    break;
                default:
                    System.out.println("Ingrese una Opcion Coreecta"); 
                    break;                    
            }
            }
            while(salir);
        }
        catch(SQLException ex)
        {
            System.out.println("Error de mysql...");
        }
        catch(Exception e)
        {
            System.out.println("Se ha encontrado un error, que es: "+e.getMessage());
        }
        
    }
    
}

