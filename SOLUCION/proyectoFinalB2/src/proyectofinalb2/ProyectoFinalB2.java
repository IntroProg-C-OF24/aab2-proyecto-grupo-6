package proyectofinalb2;

import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Formatter;

public class ProyectoFinalB2 {

    public static void main(String[] args) {

        Scanner put = new Scanner(System.in);

        String nombrePelicula = "", sala = null, nombreHora = "", orden = "", nombreDia = "";
        int comprar, nBoletos, pelicula, hora, fil, col, snack, combo, limFil = 5, limCol = 5, pcombo = 0, dia, clienteNuevo, contador = 0, continuar;
        boolean opcionValida = true, asientoLibre = true, seguircomprando = true, otroCliente = true;
        double precioXboleto = 0, precioxCombo = 0, totalCombo = 0;
        String asientos[][] = new String[limFil][limCol];
        String mat[][] = new String[4][4];
        String matC[][] = new String[3][4];
        String nombresRandom[] = {"Pedro", "Carlos", "Juan", "Emilia", "Daniel", "Sebastian", "Manuel", "Maria", "Paula", "Jean"};

        importarDatosPeliculas(mat);
        importarDatosSnacks(matC);
        System.out.println("CUANTOS CLIENTES VA A INGRESAR");
        clienteNuevo = put.nextInt();
        String nombres[] = new String[clienteNuevo];
        for (int i = 0; i < clienteNuevo; i++) {
            int aleat = (int) (Math.random() * 10 + 0);
            nombres[i] = nombresRandom[aleat];
        }
        String datosRegistroCombos[][] = new String[clienteNuevo][3];
        String datosRegistroPelicula[][] = new String[clienteNuevo][4];
        System.out.println("Dia:");
        System.out.println("[1]LUNES");
        System.out.println("[2]MARTES  (boletos a mitad de precio)");
        System.out.println("[3]MIERCOLES");
        System.out.println("[4]JUEVES  (boletos a mitad de precio)");
        System.out.println("[5]VIERNES");
        System.out.println("[6]SABADO");
        System.out.println("[7]DOMINGO  (snacks a mitad de precio)");
        dia = put.nextInt();
        while (opcionValida) {
            switch (dia) {
                case 1:
                    nombreDia = "LUNES";
                    opcionValida = false;
                    break;
                case 2:
                    nombreDia = "MARTES";
                    opcionValida = false;
                    break;
                case 3:
                    nombreDia = "MIERCOLES";
                    opcionValida = false;
                    break;
                case 4:
                    nombreDia = "JUEVES";
                    opcionValida = false;
                    break;
                case 5:
                    nombreDia = "VIERNES";
                    opcionValida = false;
                    break;
                case 6:
                    nombreDia = "SABADO";
                    opcionValida = false;
                    break;
                case 7:
                    nombreDia = "DOMINGO";
                    opcionValida = false;
                    break;
                default:
                    System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!");
                    System.out.println("NO EXISTE ESA OPCION");
                    System.out.println("ELIGE OTRA VEZ");
                    System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n"); //vuelve a preguntar si no existe la respuesta
                    pelicula = put.nextInt();
            }
        }
        while (contador < clienteNuevo) {
            orden = "";
            System.out.println("****************************");
            System.out.println("DESEA COMPRAR BOLETOS?");
            System.out.println("[1] Si");
            System.out.println("[2] No");
            comprar = put.nextInt(); //si no se compran, se pasa directamente a snacks
            System.out.println("****************************");
            if (comprar == 1) {
                System.out.println("CUANTOS BOLETOS QUIERE?");
                nBoletos = put.nextInt();
                System.out.println("****************************");
                String facturaAsientos[] = new String[nBoletos];  //se crea en base al numero de boletos comprados
                System.out.println("ELIJA SU PELICULA");
                System.out.println("1 " + mat[0][0] + "[$" + mat[0][1] + "]" + " (estreno)");
                System.out.println("2 " + mat[1][0] + "[$" + mat[1][1] + "]");
                System.out.println("3 " + mat[2][0] + "[$" + mat[2][1] + "]");
                System.out.println("4 " + mat[3][0] + "[$" + mat[3][1] + "]" + " (ultima semana)");
                pelicula = put.nextInt();
                opcionValida = true;

                while (opcionValida) {
                    switch (pelicula) {
                        case 1:
                            if ((dia == 2) || (dia == 4)) {
                                precioXboleto = Integer.valueOf(mat[0][2]);
                            } else {
                                precioXboleto = Integer.valueOf(mat[0][1]);
                            }
                            nombrePelicula = mat[0][0];
                            sala = "A";
                            opcionValida = false;
                            break;
                        case 2:
                            if ((dia == 2) || (dia == 4)) {
                                precioXboleto = Integer.valueOf(mat[1][2]);
                            } else {
                                precioXboleto = Integer.valueOf(mat[1][1]);
                            }
                            nombrePelicula = mat[1][0];
                            sala = "B";
                            opcionValida = false;
                            break;
                        case 3:
                            if ((dia == 2) || (dia == 4)) {
                                precioXboleto = Integer.valueOf(mat[2][2]);
                            } else {
                                precioXboleto = Integer.valueOf(mat[2][1]);
                            }
                            nombrePelicula = mat[2][0];
                            sala = "C";
                            opcionValida = false;
                            break;
                        case 4:
                            if ((dia == 2) || (dia == 4)) {
                                precioXboleto = Integer.valueOf(mat[3][2]);
                            } else {
                                precioXboleto = Integer.valueOf(mat[3][1]);
                            }
                            nombrePelicula = mat[3][0];
                            sala = "D";
                            opcionValida = false;
                            break;
                        default:
                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!");
                            System.out.println("NO EXISTE ESA OPCION");
                            System.out.println("ELIGE OTRA VEZ");
                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n"); //vuelve a preguntar si no existe la respuesta
                            pelicula = put.nextInt();

                    }

                }
                System.out.println("****************************");
                opcionValida = true;
                System.out.println("ELIJA LA HORA");
                System.out.println("[1] " + mat[0][3] + " (descuento -25%)");
                System.out.println("[2] " + mat[1][3]);
                System.out.println("[3] " + mat[2][3] + " (tarifa adicional +25%)");
                System.out.println("[4] " + mat[3][3]);
                hora = put.nextInt();
                while (opcionValida) {
                    switch (hora) {
                        case 1:
                            nombreHora = mat[0][3];
                            precioXboleto = precioXboleto - (precioXboleto * 0.25); //se reduce el precio por boleto por el descuento de la tarde
                            opcionValida = false;
                            break;
                        case 2:
                            nombreHora = mat[1][3];
                            opcionValida = false;
                            break;
                        case 3:
                            nombreHora = mat[2][3];
                            precioXboleto = precioXboleto + (precioXboleto * 0.25);  //se aumenta el precio por boleto por la tarifa adicional de hora pico
                            opcionValida = false;
                            break;
                        case 4:
                            nombreHora = mat[3][3];
                            opcionValida = false;
                            break;
                        default:
                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!");
                            System.out.println("NO EXISTE ESA OPCION");
                            System.out.println("ELIGE OTRA VEZ");
                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si no existe la respuesta
                            hora = put.nextInt();

                    }
                }
                System.out.println("****************************");
                crearSala(limFil, limCol, asientos); // se llenan los asientos con  " - "  
                for (int i = 0; i < nBoletos; i++) {
                    asientoLibre = true;

                    while (asientoLibre) {
                        System.out.println("----------------------");
                        System.out.println("ELIJA EL ASIENTO " + (i + 1));
                        System.out.println("-ELIJA SU FILA  -  [1-5]");
                        fil = put.nextInt();
                        System.out.println("-ELIJA SU COLUMNA  -  [1-5]");
                        col = put.nextInt();
                        System.out.println("----------------------");
                        if (asientos[fil - 1][col - 1] == "X") {
                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                        } else {
                            asientos[fil - 1][col - 1] = "X";
                            asientoLibre = false;
                            facturaAsientos[i] = fil + "-" + col;
                            System.out.println(dibujarAsientos(limFil, limCol, asientos));
                        }
                    }
                }
                System.out.println(facturaPelicula(facturaAsientos, nBoletos, precioXboleto, nombrePelicula, nombreHora, sala, nombreDia, clienteNuevo, contador, datosRegistroPelicula));
            }
            System.out.println("****************************");
            System.out.println("DESEA COMPRAR SNACKS?");
            System.out.println("[1] Si");
            System.out.println("[2] No");
            comprar = put.nextInt();
            System.out.println("****************************");

            if (comprar == 1) {
                totalCombo = 0;
                do {
                    System.out.println("******************************************");
                    System.out.println("ESCOJA SU OPCION DE COMBO");
                    System.out.println(matC[0][0] + " " + matC[0][1] + " [$" + matC[0][2] + "]");
                    System.out.println(matC[1][0] + " " + matC[1][1] + " [$" + matC[1][2] + "]");
                    System.out.println(matC[2][0] + " " + matC[2][1] + " [$" + matC[2][2] + "]");
                    
                    System.out.println("******************************************");
                    combo = put.nextInt();
                    switch (combo) {
                        case 1:
                            orden += (matC[0][0] + " ");
                            precioxCombo = Integer.valueOf(matC[0][2]);
                            if ((nombrePelicula.equals(mat[0][0])) || (nombrePelicula.equals(mat[1][0]))) {//SI SE ESCOGE LA PELICULA SPIDERMAN O BARBIE DESCUENTO
                                System.out.println("*********************************************************");
                                System.out.println("LAS FUNCIONES " + mat[0][0] + " Y " + mat[1][0] + " TIENE UN DESCUENTO PARA EL " + matC[0][0]);
                                System.out.println("*********************************************************");

                                precioxCombo = Integer.valueOf(matC[0][3]);

                            }
                            if (dia == 7) {
                                precioxCombo = (precioxCombo / 2);
                            }
                            opcionValida = false;
                            break;
                        case 2:
                            orden += (matC[1][0] + " ");
                            precioxCombo = Integer.valueOf(matC[1][2]);
                            if (nombrePelicula.equals(mat[2][0])) {
                                System.out.println("*******************************************************************************");
                                System.out.println("LA FUNCION LEGO TIENE UN DESCUENTO PARA EL " + mat[1][0]);
                                System.out.println("*******************************************************************************");

                                precioxCombo = Integer.valueOf(matC[1][3]);
                            }
                            if (dia == 7) {
                                precioxCombo = (precioxCombo / 2);
                            }
                            opcionValida = false;
                            break;
                        case 3:
                            orden += (matC[2][0] + " ");
                            precioxCombo = Integer.valueOf(matC[2][2]);
                            if (nombreHora.equals(mat[3][3])) {
                                System.out.println("*******************************************************************************");
                                System.out.println("POR SER LA ULTIMA FUNCION 22h00 SE APLICA DESCUENTO EN EL COMBO");
                                System.out.println("*******************************************************************************");
                                precioxCombo = Integer.valueOf(matC[2][3]);
                            }
                            if (dia == 7) {
                                precioxCombo = (precioxCombo / 2);
                            }
                            opcionValida = false;
                            break;
                    }

                    System.out.println("******************************************");
                    totalCombo += precioxCombo;
                    System.out.println("DESEA COMPRAR OTRO COMBO?");
                    System.out.println("[1] Si");
                    System.out.println("[2] No");
                    continuar = put.nextInt();

                } while (continuar == 1);
                System.out.println(facturaSnack(totalCombo, orden, datosRegistroCombos, contador));
            }
            contador++;

        }
        exportarRegistroPeliculas(datosRegistroPelicula, clienteNuevo, nombreDia, nombres);
        exportarRegistroSnacks(clienteNuevo, orden, nombreDia, datosRegistroCombos, nombres);

    }

    public static void crearSala(int limFil, int limCol, String asientos[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientos[i][j] = "-";
            }
        }
    }

    public static String dibujarAsientos(int limFil, int limCol, String asientos[][]) {
        String dibujoAsientos = "";
        for (int k = 0; k < limFil; k++) {
            for (int j = 0; j < limCol; j++) {
                dibujoAsientos += (asientos[k][j] + "\t");
            }
            dibujoAsientos += ("\n");
        }
        return dibujoAsientos;
    }

    public static void importarDatosPeliculas(String mat[][]) {
        try {
            Scanner leer = new Scanner(new File("pelicula.csv"));
            int h = 0;
            while (leer.hasNext()) {
                String datos[] = leer.nextLine().split(";");
                mat[h][0] = datos[0];
                mat[h][1] = datos[1];
                mat[h][2] = datos[2];
                mat[h][3] = datos[3];
                h++;
            }
        } catch (Exception e) {
        }
    }

    public static void importarDatosSnacks(String matC[][]) {
        try {
            Scanner leer = new Scanner(new File("combos.csv"));
            int i = 0;
            while (leer.hasNext()) {
                String datos[] = leer.nextLine().split(";");
                matC[i][0] = datos[0];
                matC[i][1] = datos[1];
                matC[i][2] = datos[2];
                matC[i][3] = datos[3];
                i++;
            }
        } catch (Exception e) {
        }
    }

    public static String facturaPelicula(String facturaAsientos[], int nBoletos, double precioXboleto, String nombrePelicula, String nombreHora, String sala, String nombreDia, int clienteNuevo, int contador, String datosRegistroPelicula[][]) {
        String boletos = "";
        DecimalFormat df = new DecimalFormat("#.##"); //es una clase que permite reducir valores decimales
        double iva = ((nBoletos * precioXboleto) * 0.12), totalPagarPelicula = ((nBoletos * precioXboleto) + iva);
        String ivaDecim = df.format(iva);
        String totalPagarPeliculaDecim = df.format(totalPagarPelicula);  //se guardan los datos en variables con los decimales reducidos
        boletos += "==================== FACTURA ====================" + "\n"
                + "Numero de Boletos: " + nBoletos + "\n"
                + "Precio por Boleto: $" + precioXboleto + "\n"
                + "Pelicula: " + nombrePelicula + "\n"
                + "Hora: " + nombreHora + "\n"
                + "Total: $" + (nBoletos * precioXboleto) + "\n"
                + "IVA: " + ivaDecim + "\n"
                + "Total a Pagar: $" + totalPagarPeliculaDecim + "\n"
                + "=================================================" + "\n\n\n\n\n";
        for (int i = 0; i < nBoletos; i++) {
            boletos += "==================== BOLETO " + (i + 1) + " ====================" + "\n"
                    + "Pelicula: " + nombrePelicula + "\n"
                    + "Hora: " + nombreHora + "\n"
                    + "Sala: " + sala + "\n"
                    + "Asiento: " + facturaAsientos[i] + "\n"
                    + "==================================================" + "\n\n\n";
        }
        datosRegistroPelicula[contador][0] = nombreHora;
        datosRegistroPelicula[contador][1] = nombrePelicula;
        datosRegistroPelicula[contador][2] = (String.valueOf(nBoletos) + " boletos");
        datosRegistroPelicula[contador][3] = totalPagarPeliculaDecim;
        return boletos;
    }

    public static String facturaSnack(double totalCombo, String orden, String datosRegistroCombos[][], int contador) {
        String facturaSn = "";
        DecimalFormat df = new DecimalFormat("#.##"); //es una clase que permite reducir valores decimales
        double iva = (totalCombo * 0.12), total = (totalCombo + iva);
        String totalDecim = df.format(totalCombo);
        String ivaDecim = df.format(iva);
        String totalPagarSnacksDecim = df.format(total);  //se guardan los datos en variables con los decimales reducidos

        facturaSn += "==================== FACTURA ====================" + "\n"
                + "Orden:" + orden + "\n"
                + "IVA: " + ivaDecim + "\n"
                + "TOTAL: $" + totalDecim + "\n"
                + "TOTAL A PAGAR: $" + totalPagarSnacksDecim + "\n"
                + "=================================================" + "\n\n\n\n\n";

        datosRegistroCombos[contador][0] = orden;
        datosRegistroCombos[contador][1] = totalPagarSnacksDecim;

        return facturaSn;
    }

    public static void exportarRegistroSnacks(int clienteNuevo, String orden, String nombreDia, String datosRegistroCombos[][], String nombres[]) {
        try {
            Formatter escritura = new Formatter("registroSnacks.csv");
            escritura.format("%s;%s;%s;%s; \n", "NOMBRE", "PEDIDO", "TOTAL", "DIA");
            for (int i = 0; i < clienteNuevo; i++) {
                int aleat = (int) (Math.random() * 10 + 0);
                escritura.format("%s;%s;%s;%s; \n", nombres[i], datosRegistroCombos[i][0], ("$" + datosRegistroCombos[i][1]), nombreDia);
            }
            escritura.close();

        } catch (Exception e) {
        }
    }

    public static void exportarRegistroPeliculas(String datosRegistroPelicula[][], int clienteNuevo, String nombreDia, String nombres[]) {
        try {
            Formatter escritura = new Formatter("registroPelis.csv");
            escritura.format("%s;%s;%s;%s;%s;%s; \n", "NOMBRE", "HORA", "PELICULA", "NUM BOL", "TOTAL", "DIA");
            for (int i = 0; i < clienteNuevo; i++) {
                escritura.format("%s;%s;%s;%s;%s;%s\n", nombres[i], datosRegistroPelicula[i][0], datosRegistroPelicula[i][1], datosRegistroPelicula[i][2], ("$" + datosRegistroPelicula[i][3]), nombreDia);

            }
            escritura.close();

        } catch (Exception e) {
        }
    }

}