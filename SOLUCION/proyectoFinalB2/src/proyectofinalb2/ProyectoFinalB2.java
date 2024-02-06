package proyectofinalb2;

import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Formatter;

public class ProyectoFinalB2 {

    public static void main(String[] args) {

        Scanner put = new Scanner(System.in);

        String nombrePelicula = "", sala = "", nombreHora = "", orden = "", nombreDia = "";
        int comprar, nBoletos, pelicula, hora, fil, col, combo, limFil = 5, limCol = 5, maxClientes = 400, nuevoCliente, dia, clienteNuevo = 0, contador = 0;
        boolean opcionValida = true, asientoLibre = true, otroCliente = true;
        double precioXboleto = 0, precioxCombo = 0, totalCombo = 0;
        String asientosA16[][] = new String[limFil][limCol]; //SE INICIALIZAN LAS MATRICES DE LAS SALAS
        String asientosA18[][] = new String[limFil][limCol];
        String asientosA20[][] = new String[limFil][limCol];
        String asientosA22[][] = new String[limFil][limCol];

        String asientosB16[][] = new String[limFil][limCol];
        String asientosB18[][] = new String[limFil][limCol];
        String asientosB20[][] = new String[limFil][limCol];
        String asientosB22[][] = new String[limFil][limCol];

        String asientosC16[][] = new String[limFil][limCol];
        String asientosC18[][] = new String[limFil][limCol];
        String asientosC20[][] = new String[limFil][limCol];
        String asientosC22[][] = new String[limFil][limCol];

        String asientosD16[][] = new String[limFil][limCol];
        String asientosD18[][] = new String[limFil][limCol];
        String asientosD20[][] = new String[limFil][limCol];
        String asientosD22[][] = new String[limFil][limCol];

        String mat[][] = new String[4][4];
        String matC[][] = new String[3][4];
        String nombresRandom[] = {"Pedro", "Carlos", "Juan", "Emilia", "Daniel", "Sebastian", "Manuel", "Maria", "Paula", "Jean"};

        crearSalaA16(limFil, limCol, asientosA16); //SE INVOCAN LOS METODOS PARA LLENAR LAS MATRICES DE LAS SALAS
        crearSalaA18(limFil, limCol, asientosA18);
        crearSalaA20(limFil, limCol, asientosA20);
        crearSalaA22(limFil, limCol, asientosA22);

        crearSalaB16(limFil, limCol, asientosB16);
        crearSalaB18(limFil, limCol, asientosB18);
        crearSalaB20(limFil, limCol, asientosB20);
        crearSalaB22(limFil, limCol, asientosB22);

        crearSalaC16(limFil, limCol, asientosC16);
        crearSalaC18(limFil, limCol, asientosC18);
        crearSalaC20(limFil, limCol, asientosC20);
        crearSalaC22(limFil, limCol, asientosC22);

        crearSalaD16(limFil, limCol, asientosD16);
        crearSalaD18(limFil, limCol, asientosD18);
        crearSalaD20(limFil, limCol, asientosD20);
        crearSalaD22(limFil, limCol, asientosD22);

        importarDatosPeliculas(mat);
        importarDatosSnacks(matC);

        String datosRegistroCombos[][] = new String[maxClientes][3];
        String datosRegistroPelicula[][] = new String[maxClientes][4];
        System.out.println("Dia:");
        System.out.println("[1]LUNES");
        System.out.println("[2]MARTES  (boletos a mitad de precio)");
        System.out.println("[3]MIERCOLES");
        System.out.println("[4]JUEVES  (boletos a mitad de precio)");
        System.out.println("[5]VIERNES");
        System.out.println("[6]SABADO");
        System.out.println("[7]DOMINGO  (snacks a mitad de precio)");
        dia = put.nextInt();
        do {
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
                        switch (pelicula) {
                            case 1:
                                switch (hora) {
                                    case 1:
                                        if (asientosA16[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosA16[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 2:
                                        if (asientosA18[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosA18[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 3:
                                        if (asientosA20[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosA20[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 4:
                                        if (asientosA22[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosA22[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                }
                                break;
                            case 2:
                                switch (hora) {
                                    case 1:
                                        if (asientosB16[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosB16[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 2:
                                        if (asientosB18[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosB18[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 3:
                                        if (asientosB20[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosB20[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 4:
                                        if (asientosB22[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosB22[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                }
                                break;
                            case 3:
                                switch (hora) {
                                    case 1:
                                        if (asientosC16[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosC16[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 2:
                                        if (asientosC18[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosC18[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 3:
                                        if (asientosC20[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosC20[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 4:
                                        if (asientosC22[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosC22[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                switch (hora) {
                                    case 1:
                                        if (asientosD16[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosD16[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 2:
                                        if (asientosD18[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosD18[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 3:
                                        if (asientosD20[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosD20[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                    case 4:
                                        if (asientosD22[fil - 1][col - 1] == "X") {
                                            System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                                            System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                                            System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");   //vuelve a preguntar si detecta que ya esta ocupado
                                        } else {
                                            asientosD22[fil - 1][col - 1] = "X";
                                            asientoLibre = false;
                                            facturaAsientos[i] = fil + "-" + col;
                                            System.out.println(dibujarAsientos(limFil, limCol, asientosA16, asientosA18, asientosA20, asientosA22, asientosB16, asientosB18, asientosB20, asientosB22, asientosC16, asientosC18, asientosC20, asientosC22, asientosD16, asientosD18, asientosD20, asientosD22, pelicula, hora));
                                        }
                                        break;
                                }
                                break;
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
                            if ((nombrePelicula.equals(mat[0][0])) || (nombrePelicula.equals(mat[1][0]))) {
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
                                System.out.println("LA FUNCION " + mat[1][0] + " TIENE UN DESCUENTO PARA EL " + mat[1][0]);
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
                    comprar = put.nextInt();

                } while (comprar == 1);
                System.out.println(facturaSnack(totalCombo, orden, datosRegistroCombos, contador));
            }
            contador++;
            clienteNuevo++;
            System.out.println("DESEA INGRESAR OTRO CLIENTE?");
            System.out.println("[1] Si");
            System.out.println("[2] No");
            nuevoCliente = put.nextInt(); 
            if (nuevoCliente == 2) {
                otroCliente = false;
            }
            if (clienteNuevo >= maxClientes) {
                System.out.println("AFORO MAXIMO ALCANZADO");
                otroCliente = false;
            }
        } while (otroCliente); // SI SE ESCRIBE 2 O SE REGISTRAN MAS DE 400 CLIENTES, SE CIERRA EL CICLO
        String nombres[] = new String[clienteNuevo]; 
        for (int i = 0; i < clienteNuevo; i++) {//SE LLENA EL ARREGLO DE NOMBRES 
            int aleat = (int) (Math.random() * 10 + 0);
            nombres[i] = nombresRandom[aleat];
        } 
        System.out.println("-----------CLIENTES HOY: " + clienteNuevo + "-----------");
        exportarRegistroPeliculas(datosRegistroPelicula, clienteNuevo, nombreDia, nombres);
        exportarRegistroSnacks(clienteNuevo, orden, nombreDia, datosRegistroCombos, nombres);

    }

    public static void crearSalaA16(int limFil, int limCol, String asientosA16[][]) { //SE LLENAN LAS SALAS CON "-" PARA REPRESENTAR QUE ESTAN VACIAS
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosA16[i][j] = "-";
            }
        }
    }

    public static void crearSalaA18(int limFil, int limCol, String asientosA18[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosA18[i][j] = "-";
            }
        }
    }

    public static void crearSalaA20(int limFil, int limCol, String asientosA20[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosA20[i][j] = "-";
            }
        }
    }

    public static void crearSalaA22(int limFil, int limCol, String asientosA22[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosA22[i][j] = "-";
            }
        }
    }

    public static void crearSalaB16(int limFil, int limCol, String asientosB16[][]) {//SE LLENAN LAS SALAS CON "-" PARA REPRESENTAR QUE ESTAN VACIAS
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosB16[i][j] = "-";
            }
        }
    }

    public static void crearSalaB18(int limFil, int limCol, String asientosB18[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosB18[i][j] = "-";
            }
        }
    }

    public static void crearSalaB20(int limFil, int limCol, String asientosB20[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosB20[i][j] = "-";
            }
        }
    }

    public static void crearSalaB22(int limFil, int limCol, String asientosB22[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosB22[i][j] = "-";
            }
        }
    }

    public static void crearSalaC16(int limFil, int limCol, String asientosC16[][]) {//SE LLENAN LAS SALAS CON "-" PARA REPRESENTAR QUE ESTAN VACIAS
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosC16[i][j] = "-";
            }
        }
    }

    public static void crearSalaC18(int limFil, int limCol, String asientosC18[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosC18[i][j] = "-";
            }
        }
    }

    public static void crearSalaC20(int limFil, int limCol, String asientosC20[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosC20[i][j] = "-";
            }
        }
    }

    public static void crearSalaC22(int limFil, int limCol, String asientosC22[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosC22[i][j] = "-";
            }
        }
    }

    public static void crearSalaD16(int limFil, int limCol, String asientosD16[][]) {//SE LLENAN LAS SALAS CON "-" PARA REPRESENTAR QUE ESTAN VACIAS
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosD16[i][j] = "-";
            }
        }
    }

    public static void crearSalaD18(int limFil, int limCol, String asientosD18[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosD18[i][j] = "-";
            }
        }
    }

    public static void crearSalaD20(int limFil, int limCol, String asientosD20[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosD20[i][j] = "-";
            }
        }
    }

    public static void crearSalaD22(int limFil, int limCol, String asientosD22[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosD22[i][j] = "-";
            }
        }
    }

    public static String dibujarAsientos(int limFil, int limCol, String asientosA16[][], String asientosA18[][], String asientosA20[][], String asientosA22[][], 
            String asientosB16[][], String asientosB18[][], String asientosB20[][], String asientosB22[][], 
            String asientosC16[][], String asientosC18[][], String asientosC20[][], String asientosC22[][], 
            String asientosD16[][], String asientosD18[][], String asientosD20[][], String asientosD22[][], 
            int pelicula, int hora) {
        String dibujoAsientos = "";
        switch (pelicula) {
            case 1:
                switch (hora) {
                    case 1:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosA16[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 2:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosA18[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 3:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosA20[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 4:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosA22[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;

                }
                break;
            case 2:
                switch (hora) {
                    case 1:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosB16[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 2:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosB18[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 3:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosB20[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 4:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosB22[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;

                }
                break;
            case 3:
                switch (hora) {
                    case 1:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosC16[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 2:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosC18[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 3:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosC20[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 4:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosC22[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;

                }
                break;
            case 4:
                switch (hora) {
                    case 1:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosD16[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 2:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosD18[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 3:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosD20[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;
                    case 4:

                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                dibujoAsientos += (asientosD22[k][j] + "\t");
                            }
                            dibujoAsientos += ("\n");
                        }
                        break;

                }
                break;

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
/*
run:
Dia:
[1]LUNES
[2]MARTES  (boletos a mitad de precio)
[3]MIERCOLES
[4]JUEVES  (boletos a mitad de precio)
[5]VIERNES
[6]SABADO
[7]DOMINGO  (snacks a mitad de precio)
3
****************************
DESEA COMPRAR BOLETOS?
[1] Si
[2] No
1
****************************
CUANTOS BOLETOS QUIERE?
1
****************************
ELIJA SU PELICULA
1 SPIDERMAN[$8] (estreno)
2 LEGO[$4]
3 BARBIE[$4]
4 MATRIX[$2] (ultima semana)
1
****************************
ELIJA LA HORA
[1] 16h00 (descuento -25%)
[2] 18h00
[3] 20h00 (tarifa adicional +25%)
[4] 22h00
1
****************************
----------------------
ELIJA EL ASIENTO 1
-ELIJA SU FILA  -  [1-5]
1
-ELIJA SU COLUMNA  -  [1-5]
1
----------------------
X	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	

==================== FACTURA ====================
Numero de Boletos: 1
Precio por Boleto: $6.0
Pelicula: SPIDERMAN
Hora: 16h00
Total: $6.0
IVA: 0,72
Total a Pagar: $6,72
=================================================




==================== BOLETO 1 ====================
Pelicula: SPIDERMAN
Hora: 16h00
Sala: A
Asiento: 1-1
==================================================



****************************
DESEA COMPRAR SNACKS?
[1] Si
[2] No
1
****************************
******************************************
ESCOJA SU OPCION DE COMBO
[1]COMBO Bebida_con_Canguil [$3]
[2]COMBO Bebida_con_Canguil_y_un_Raspado [$7]
[3]COMBO Nachos_con_burrito_y_un_Raspado [$9]
******************************************
1
*********************************************************
LAS FUNCIONES SPIDERMAN Y LEGO TIENE UN DESCUENTO PARA EL [1]COMBO
*********************************************************
******************************************
DESEA COMPRAR OTRO COMBO?
[1] Si
[2] No
2
==================== FACTURA ====================
Orden:[1]COMBO 
IVA: 0,12
TOTAL: $1
TOTAL A PAGAR: $1,12
=================================================





DESEA INGRESAR OTRO CLIENTE?
[1] Si
[2] No
1
****************************
DESEA COMPRAR BOLETOS?
[1] Si
[2] No
1
****************************
CUANTOS BOLETOS QUIERE?
2
****************************
ELIJA SU PELICULA
1 SPIDERMAN[$8] (estreno)
2 LEGO[$4]
3 BARBIE[$4]
4 MATRIX[$2] (ultima semana)
2
****************************
ELIJA LA HORA
[1] 16h00 (descuento -25%)
[2] 18h00
[3] 20h00 (tarifa adicional +25%)
[4] 22h00
1
****************************
----------------------
ELIJA EL ASIENTO 1
-ELIJA SU FILA  -  [1-5]
1
-ELIJA SU COLUMNA  -  [1-5]
1
----------------------
X	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	

----------------------
ELIJA EL ASIENTO 2
-ELIJA SU FILA  -  [1-5]
2
-ELIJA SU COLUMNA  -  [1-5]
2
----------------------
X	-	-	-	-	
-	X	-	-	-	
-	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	

==================== FACTURA ====================
Numero de Boletos: 2
Precio por Boleto: $3.0
Pelicula: LEGO
Hora: 16h00
Total: $6.0
IVA: 0,72
Total a Pagar: $6,72
=================================================




==================== BOLETO 1 ====================
Pelicula: LEGO
Hora: 16h00
Sala: B
Asiento: 1-1
==================================================


==================== BOLETO 2 ====================
Pelicula: LEGO
Hora: 16h00
Sala: B
Asiento: 2-2
==================================================



****************************
DESEA COMPRAR SNACKS?
[1] Si
[2] No
2
****************************
DESEA INGRESAR OTRO CLIENTE?
[1] Si
[2] No
1
****************************
DESEA COMPRAR BOLETOS?
[1] Si
[2] No
1
****************************
CUANTOS BOLETOS QUIERE?
1
****************************
ELIJA SU PELICULA
1 SPIDERMAN[$8] (estreno)
2 LEGO[$4]
3 BARBIE[$4]
4 MATRIX[$2] (ultima semana)
1
****************************
ELIJA LA HORA
[1] 16h00 (descuento -25%)
[2] 18h00
[3] 20h00 (tarifa adicional +25%)
[4] 22h00
1
****************************
----------------------
ELIJA EL ASIENTO 1
-ELIJA SU FILA  -  [1-5]
1
-ELIJA SU COLUMNA  -  [1-5]
1
----------------------

!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!
ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO
!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!

----------------------
ELIJA EL ASIENTO 1
-ELIJA SU FILA  -  [1-5]
4
-ELIJA SU COLUMNA  -  [1-5]
4
----------------------
X	-	-	-	-	
-	-	-	-	-	
-	-	-	-	-	
-	-	-	X	-	
-	-	-	-	-	

==================== FACTURA ====================
Numero de Boletos: 1
Precio por Boleto: $6.0
Pelicula: SPIDERMAN
Hora: 16h00
Total: $6.0
IVA: 0,72
Total a Pagar: $6,72
=================================================




==================== BOLETO 1 ====================
Pelicula: SPIDERMAN
Hora: 16h00
Sala: A
Asiento: 4-4
==================================================



****************************
DESEA COMPRAR SNACKS?
[1] Si
[2] No
2
****************************
DESEA INGRESAR OTRO CLIENTE?
[1] Si
[2] No
1
****************************
DESEA COMPRAR BOLETOS?
[1] Si
[2] No
2
****************************
****************************
DESEA COMPRAR SNACKS?
[1] Si
[2] No
1
****************************
******************************************
ESCOJA SU OPCION DE COMBO
[1]COMBO Bebida_con_Canguil [$3]
[2]COMBO Bebida_con_Canguil_y_un_Raspado [$7]
[3]COMBO Nachos_con_burrito_y_un_Raspado [$9]
******************************************
3
******************************************
DESEA COMPRAR OTRO COMBO?
[1] Si
[2] No
1
******************************************
ESCOJA SU OPCION DE COMBO
[1]COMBO Bebida_con_Canguil [$3]
[2]COMBO Bebida_con_Canguil_y_un_Raspado [$7]
[3]COMBO Nachos_con_burrito_y_un_Raspado [$9]
******************************************
2
******************************************
DESEA COMPRAR OTRO COMBO?
[1] Si
[2] No
1
******************************************
ESCOJA SU OPCION DE COMBO
[1]COMBO Bebida_con_Canguil [$3]
[2]COMBO Bebida_con_Canguil_y_un_Raspado [$7]
[3]COMBO Nachos_con_burrito_y_un_Raspado [$9]
******************************************
1
*********************************************************
LAS FUNCIONES SPIDERMAN Y LEGO TIENE UN DESCUENTO PARA EL [1]COMBO
*********************************************************
******************************************
DESEA COMPRAR OTRO COMBO?
[1] Si
[2] No
2
==================== FACTURA ====================
Orden:[3]COMBO [2]COMBO [1]COMBO 
IVA: 2,04
TOTAL: $17
TOTAL A PAGAR: $19,04
=================================================





DESEA INGRESAR OTRO CLIENTE?
[1] Si
[2] No
2
-----------CLIENTES HOY: 4-----------
BUILD SUCCESSFUL (total time: 1 minute 39 seconds)
*/