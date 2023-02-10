import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @author Ester Mota y Dylan Fiego
 */

public class Retofinal_fiego_mota_metodos {
    static String[][] aProductos = new String[11][6];
    static String[][] aPedidos = new String[100][8];
    static Scanner sc = new Scanner(System.in);
    static SimpleDateFormat Fechaactual = new SimpleDateFormat("dd/MM/yyyy");
    static Date data = new Date();

    static boolean LoginBroke = true;
    static String[][] sUsuarios = new String[10][2];

    static int iContador = 3;
    static String sNuevoNombreUsuario = "";
    static String sNuevaContrasenaUsuario = "";

    static String sIdProductoProducto = "";
    static String sPrecioProducto = "";
    static String sCajonesProducto = "";
    static String sObservacionesProducto = "";

    static String mProducto = "";
    static String sUnidades = "";

    static int idPedidosContador = 1;
    static int iUnidadesRestantes = 0;

    static double dPrecio = 0;
    static double dPrecioTotal = 0;

    static String sPedidoActualizar = "";
    static int iNumeroFilaPedido = 0;
    static boolean bPedidoEncontrado = false;

    static String sUnidadesProductoActualizar = "";
    static String sNuevoProductoActualizar = "";

    public static void main(String[] args) {
        pdRellenarArray();
    }

    public static void pdRellenarArray() {
        // modelos placas
        aProductos[0][0] = "Modelo";
        aProductos[1][0] = "46";
        aProductos[2][0] = "48";
        aProductos[3][0] = "49";
        aProductos[4][0] = "50";
        aProductos[5][0] = "51";
        aProductos[6][0] = "52";
        aProductos[7][0] = "53";
        aProductos[8][0] = "54";
        aProductos[9][0] = "64";
        aProductos[10][0] = "69"; 

        // Cajones placas
        aProductos[0][1] = "Cajones";
        aProductos[1][1] = "7";
        aProductos[2][1] = "1";
        aProductos[3][1] = "4";
        aProductos[4][1] = "6";
        aProductos[5][1] = "1";
        aProductos[6][1] = "2";
        aProductos[7][1] = "3";
        aProductos[8][1] = "8";
        aProductos[9][1] = "5";
        aProductos[10][1] = "10"; 

        // Precio placas
        aProductos[0][2] = "Precio";
        aProductos[1][2] = "30";
        aProductos[2][2] = "20";
        aProductos[3][2] = "10";
        aProductos[4][2] = "10";
        aProductos[5][2] = "5";
        aProductos[6][2] = "10";
        aProductos[7][2] = "5";
        aProductos[8][2] = "5";
        aProductos[9][2] = "10";
        aProductos[10][2] = "10";  

        // Cantidad placas
        aProductos[0][3] = 
        aProductos[1][3] = "Contiene 24 Unidades";
        aProductos[2][3] = "Contiene 96 Unidades";
        aProductos[3][3] = "Contiene 96 Unidades";
        aProductos[4][3] = "Contiene 24 Unidades";
        aProductos[5][3] = "Contiene 24 Unidades";
        aProductos[6][3] = "Contiene 24 Unidades";
        aProductos[7][3] = "Contiene 24 Unidades";
        aProductos[8][3] = "Contiene 24 Unidades";
        aProductos[9][3] = "Contiene 24 Unidades";
        aProductos[10][3] = "Contiene 150 Unidades"; 
        
        // Usuarios login
        sUsuarios[0][0] = "dylan";
        sUsuarios[1][0] = "aaron";
        sUsuarios[2][0] = "marc";

        // Contraseña login
        sUsuarios[0][1] = "dylan123";
        sUsuarios[1][1] = "aaron123";
        sUsuarios[2][1] = "marc123";

        pdLogin();
    }

    public static void pdLogin() {

        System.out.print("Indiqueme el nombre del usuario: ");
        String sNombreUsuario = sc.next();
        System.out.print("Indiqueme la contraseña del usuario: ");
        String sContrasenaUsuario = sc.next();
        for (int i = 0; i < sUsuarios.length; i++) {
            for (int j = 0; j < sUsuarios.length; j++) {
                if (sNombreUsuario.equals(sUsuarios[i][0]) || sContrasenaUsuario.equals(sUsuarios[i][1])){
                    System.out.println("¡Bienvenido " + sNombreUsuario + "!");
                    pdIniciarPrograma();
                }else{
                    System.out.println("Por favor, vuelva a probar.");
                    pdLogin();
                }
            }
        }
    }

    public static void pdIniciarPrograma() {
        boolean aSalir = true;
        int aMenu = 0;
        // Menu juego
        while (aSalir) {
            System.out.println("Escoja un modo: ");
            System.out.println("1. Ver productos");
            System.out.println("2. Nuevo pedido");
            System.out.println("3. Actualizar pedido");
            System.out.println("4. Ver pedidos");
            System.out.println("5. Salir");
            aMenu = sc.nextInt();

            // Apartados del menu
            switch (aMenu) {
                // Juego
                case 1:
                    // mostrar la ARRAY;
                    pdMostrarArray();
                    break;

                case 2:
                    // Generar pedido;
                    pdGenerarPedido();
                    if (Integer.parseInt(sCajonesProducto) >= Integer.parseInt(sUnidades)) {
                    } else {
                        System.out.println("No tenemos tantas unidades");
                    }
                    break;
                case 3:
                    // Actualizar pedido;
                    pdActualizarPedido();

                    break;
                case 4:
                    // Ver pedidos;
                    pdVerPedido();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lo siento, opción no válida.");
                    break;
            }
        }
    }

    public static void pdMostrarArray() {
        
        System.out.print("id_producto\tCajones\tPrecio\tObservaciones");
        for (int i = 0; i < aProductos.length; i++) { // bucle salta filas
            System.out.println(""); // vacio;
            for (int j = 0; j < aProductos[i].length; j++) { // bucle salta columnas
                if (aProductos[i][j] != null) {
                    // Si la puntuacion es null no aparece
                    System.out.print("\t" + aProductos[i][j]);
                }
            }
        }
        System.out.println("\n");
    }

    public static void pdGenerarPedido() {
        System.out.println("¿Qué producto desea?");
        mProducto = sc.next();
        System.out.println("¿Cuántas unidades desea?");
        sUnidades = sc.next();

        pdObtenerDatos();

        pdRestarUnidades();

        pdSolicitarUnidades();

        pdCalculoIVA();

        pdRellenoDatos();
    }

    public static void pdObtenerDatos() {
        // lee de tabla productos para encontrar datos
        for (int i = 0; i < aProductos.length; i++) { // bucle salta filas
            for (int j = 0; j < aProductos[i].length; j++) { // bucle salta columnas
                // System.out.println(aProductos[i][j]);
                if (aProductos[i][1] != null) {
                    if (aProductos[i][0].equals(mProducto)) {
                        // OBTENER DATOS
                        sIdProductoProducto = aProductos[i][0];
                        sCajonesProducto = aProductos[i][1];
                        sPrecioProducto = aProductos[i][2];
                        sObservacionesProducto = aProductos[i][3];

                    }
                }
            }
        }
    }

    public static void pdRestarUnidades() {
        // Resta de unidades
        if (Integer.parseInt(sCajonesProducto) >= Integer.parseInt(sUnidades)) {
            iUnidadesRestantes = Integer.parseInt(sCajonesProducto)
                    - Integer.parseInt(sUnidades);
        }
    }

    public static void pdSolicitarUnidades() {
        // Busca en el array el modelo solicitado y las unidades
        for (int i = 0; i < aProductos.length; i++) { // bucle salta filas
            for (int j = 0; j < aProductos[i].length; j++) { // bucle salta columnas
                if (aProductos[i][1] != null) {
                    if (aProductos[i][1].equals(mProducto)) {
                        // MODIFICAR DATOS
                        aProductos[i][2] = Integer.toString(iUnidadesRestantes);
                    }
                }
            }
        }
    }

    public static void pdCalculoIVA() {
        // Calculo + IVA;
        dPrecio = Double.parseDouble(sPrecioProducto) * Double.parseDouble(sUnidades);
        dPrecioTotal = dPrecio * 1.21;
    }

    public static void pdRellenoDatos() {
        // Relleno de datos para el pedido;
        aPedidos[idPedidosContador][0] = "PED00" + idPedidosContador;
        aPedidos[idPedidosContador][1] = sIdProductoProducto; // IDPRODUCTO
        aPedidos[idPedidosContador][2] = sUnidades; // UNIDADES --> lo pone el usuario
        aPedidos[idPedidosContador][3] = sPrecioProducto; // PRECIO --> Sale de productos
        aPedidos[idPedidosContador][4] = sObservacionesProducto; // OBSERVACIONES --> Sale de productos
        aPedidos[idPedidosContador][5] = String.valueOf(Fechaactual.format(data));
        aPedidos[idPedidosContador][6] = String.valueOf(dPrecio); // BASE IMPONIBLE --> unidades * precio
        aPedidos[idPedidosContador][7] = String.valueOf(dPrecioTotal); // PRECIO TOTAL --> Base imponible + 21%IVA

        idPedidosContador++;
    }

    public static void pdActualizarPedido() {
        try{
            System.out.println("Introduce número de pedido: ");
            sPedidoActualizar = sc.next();
            pdRellenarPedidos();
            if (pdPedidoEncontrado()) {
                pdUnidades();
                pdProductoActualizarEncontrado();
                System.out.println("AQUI");
                if (Integer.parseInt(sCajonesProducto) >= Integer.parseInt(sUnidadesProductoActualizar)) {

                    System.out.println("AQUI 2");
                    //pdUnidades();
                    System.out.println("AQUI 3");
                    // pdProductoActualizarEncontrado();
                    pdCalculoIVApedidos();
                    System.out.println("AQUI 4");
                    pdRellenarProductos();
                    System.out.println("AQUI 5");
                    System.out.println("¡Pedido actualizado correctamente!");

                } else {
                    System.out.println("No tenemos tantas unidades");
                }
            } else {
                System.out.println("El número de pedido no se ha encontrado");
            }
        } catch (Exception e){
            System.out.println("Error, pruebe otra vez(pdActualizarPedido)");
        }
    }

    public static void pdRellenarPedidos() {
        for (int i = 0; i < aPedidos.length; i++) { // bucle salta filas
            for (int j = 0; j < aPedidos[i].length; j++) { // bucle salta columnas
                // System.out.println(aProductos[i][j]);
                if (aPedidos[i][1] != null) {
                    if (aPedidos[i][0].equals(sPedidoActualizar)) {
                        // OBTENER DATOS
                        iNumeroFilaPedido = i;
                        bPedidoEncontrado = true;
                    }
                }
            }
        }
        sIdProductoProducto = "";
        sCajonesProducto = "";
        sPrecioProducto = "";
        sObservacionesProducto = "";
    }

    public static boolean pdPedidoEncontrado() {
        boolean bProductoActualizarEncontrado = false;
        String sNuevoProductoActualizar = "";
        try{
            System.out.println("Qué nuevo producto desea introducir?");
            sNuevoProductoActualizar = sc.next();
            for (int i = 0; i < aProductos.length; i++) { // bucle salta filas
                for (int j = 0; j < aProductos[i].length; j++) { // bucle salta columnas
                    // System.out.println(aProductos[i][j]);
                    if (aProductos[i][1] != null) {
                        if (sNuevoProductoActualizar.equals(aProductos[i][0])) {
                            // OBTENER DATOS
                            sIdProductoProducto = aProductos[i][0];
                            sCajonesProducto = aProductos[i][1];
                            sPrecioProducto = aProductos[i][2];
                            sObservacionesProducto = aProductos[i][3];
                            bProductoActualizarEncontrado = true;

                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println("Error, por favor, vuelva a probarlo (pdPedidoEncontrado)");
        }

        return bProductoActualizarEncontrado;
    }

    public static void pdUnidades() {

        System.out.println("¿Cuántas unidades desea?");
        sUnidadesProductoActualizar = sc.next();
    }

    public static void pdProductoActualizarEncontrado() {
        System.out.println("ACT AQUI 1");
        System.out.println("sCajonesProducto: " + sCajonesProducto);
        System.out.println("sUnidadesProductoActualizar: " + sUnidadesProductoActualizar);
        int iUnidadesRestantes = Integer.parseInt(sCajonesProducto) - Integer.parseInt(sUnidadesProductoActualizar);
        System.out.println("iUnidadesRestantes: " + iUnidadesRestantes);
        System.out.println("ACT AQUI 2");
        

        try {
            for (int i = 0; i < aProductos.length; i++) { // bucle salta filas
                System.out.println("ACT AQUI 3");
                for (int j = 0; j < aProductos[i].length; j++) { // bucle salta columnas
                    System.out.println("ACT AQUI 4");
                    // System.out.println(aProductos[i][j]);
                    if (aProductos[i][1] != null) {
                        System.out.println("ACT AQUI 5");
                        if (aProductos[i][0].equals(sNuevoProductoActualizar)) {
                            System.out.println("ACT AQUI 6");
                            // MODIFICAR DATOS
                            aProductos[i][1] = Integer.toString(iUnidadesRestantes);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error, por favor, vuelva a probarlo (pdProductoActualizarEncontrado)");
        }
    }

    public static void pdCalculoIVApedidos() {
        double dPrecio = Double.parseDouble(sPrecioProducto) * Double.parseDouble(sUnidadesProductoActualizar);
        double dPrecioTotal = dPrecio * 1.21;
    }

    public static void pdRellenarProductos() {
        aPedidos[iNumeroFilaPedido][1] = sIdProductoProducto; // IDPRODUCTO
        aPedidos[iNumeroFilaPedido][2] = sUnidadesProductoActualizar; // UNIDADES --> lo pone el usuario
        aPedidos[iNumeroFilaPedido][3] = sPrecioProducto; // PRECIO --> Sale de productos
        aPedidos[iNumeroFilaPedido][4] = sObservacionesProducto; // OBSERVACIONES --> Sale de productos
        aPedidos[iNumeroFilaPedido][5] = String.valueOf(Fechaactual.format(data));
        aPedidos[iNumeroFilaPedido][6] = String.valueOf(dPrecio); // BASE IMPONIBLE --> unidades *
                                                                  // precio
        aPedidos[iNumeroFilaPedido][7] = String.valueOf(dPrecioTotal); // PRECIO TOTAL --> Base
                                                                       // imponible + 21%IVA
    }

    public static void pdVerPedido() {
        System.out.print("\t\tId_pedido\tid_producto\tCajones\t\tPrecio\t\tObservaciones\t\t\tFecha\t\tBase Imponible\t\tTotal con IVA");
        for (int i = 0; i < aPedidos.length; i++) { // bucle salta filas
            if (aPedidos[i][0] != null) {
                System.out.println(""); // vacio;
            }
            for (int j = 0; j < aPedidos[i].length; j++) { // bucle salta columnas
                if (aPedidos[i][j] != null) { // Si esta vacio...
                    // Si la puntuacion es null no aparece
                    System.out.print("\t\t" + aPedidos[i][j]);
                }
            }
        }
        System.out.println("\n");
    }
}


// while (archivo.hasnextline){
//  i++
//  linea = read...
//  array[i] = linea
//  fori {
//     linea = array[i];
//     write(fich, linea)
//  }  
// linea = array[i][0] + ";" + array[i][1];
// }