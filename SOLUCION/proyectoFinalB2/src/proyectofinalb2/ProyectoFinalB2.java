package proyectofinalb2;

import java.io.File;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ProyectoFinalB2 {

    public static void main(String[] args) {

        Scanner put = new Scanner(System.in);
        int dia;
        System.out.println("Dia:");
        System.out.println("[1]LUNES");
        System.out.println("[2]MARTES   (boletos a mitad de precio)");
        System.out.println("[3]MIERCOLES");
        System.out.println("[4]JUEVES");
        System.out.println("[5]VIERNES");
        System.out.println("[6]SABADO");
        System.out.println("[7]DOMINGO");
        dia = put.nextInt();

        String nombrePelicula = "", sala = null, nombreHora = "", orden = "";
        int comprar, nBoletos, pelicula, hora, fil, col, snack, combo, limFil = 5, limCol = 5, pcombo = 0;
        boolean opcionValida = true, asientoLibre = true, seguircomprando = true;
        double precioXboleto = 0, precioxCombo = 0, totalCombo = 0;
        String opcion;
        String asientos[][] = new String[limFil][limCol];
        System.out.println("****************************");
        System.out.println("DESEA COMPRAR BOLETOS?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        comprar = put.nextInt(); //si no se compran, se pasa directamente a snacks
        System.out.println("****************************");
        if (comprar == 1) {
            System.out.println("CUANTOS BOLETOS QUIERE?");
            nBoletos = put.nextInt();
            String facturaAsientos[] = new String[nBoletos];  //se crea en base al numero de boletos comprados
            String mat[][] = new String[4][4];
            transportarDatosDocumento(mat);
            System.out.println("ELIJA SU PELICULA");
            System.out.println("1 " + mat[0][0] + "[$" + mat[0][1] + "]" + " (estreno)");
            System.out.println("2 " + mat[1][0] + "[$" + mat[1][1] + "]");
            System.out.println("3 " + mat[2][0] + "[$" + mat[2][1] + "]");
            System.out.println("4 " + mat[3][0] + "[$" + mat[3][1] + "]" + " (ultima semana)");
            pelicula = put.nextInt();
            while (opcionValida) {
                switch (pelicula) {
                    case 1:
                        if (dia == 2) {
                            precioXboleto = Integer.valueOf(mat[0][2]);
                        } else {
                            precioXboleto = Integer.valueOf(mat[0][1]);
                        }
                        nombrePelicula = mat[0][0];
                        sala = "A";
                        opcionValida = false;
                        break;
                    case 2:
                        if (dia == 2) {
                            precioXboleto = Integer.valueOf(mat[1][2]);
                        } else {
                            precioXboleto = Integer.valueOf(mat[1][1]);
                        }
                        nombrePelicula = mat[1][0];
                        sala = "B";
                        opcionValida = false;
                        break;
                    case 3:
                        if (dia == 2) {
                            precioXboleto = Integer.valueOf(mat[2][2]);
                        } else {
                            precioXboleto = Integer.valueOf(mat[2][1]);
                        }
                        nombrePelicula = mat[2][0];
                        sala = "C";
                        opcionValida = false;
                        break;
                    case 4:
                        if (dia == 2) {
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
            System.out.println("[1] "+mat[0][3]+" (descuento -25%)");
            System.out.println("[2] "+mat[1][3]);
            System.out.println("[3] "+mat[2][3]+" (tarifa adicional +25%)");
            System.out.println("[4] "+mat[3][3]);
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
                        System.out.println(presentarAsientos( limFil,  limCol, asientos));
                    }
                }
            }
            System.out.println(facturaPelicula(facturaAsientos, nBoletos, precioXboleto, nombrePelicula, nombreHora, sala));
        }
        System.out.println("****************************");
        System.out.println("DESEA COMPRAR SNACKS?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        comprar = put.nextInt();
        System.out.println("****************************");
        while (seguircomprando) {
            if (comprar == 1) {
                System.out.println("******************************************");
                System.out.println("ESCOJA SU OPCION DE COMBO");
                System.out.println("[1] COMBO(Bebida con Canguil)($3)");
                System.out.println("[2] COMBO(Bebida con Canguil y un Raspado)($7)");
                System.out.println("[3] COMBO(Nachos con Burrito y Raspado )($9)");
                System.out.println("[4] COMBO PERSONALIZADO");
                System.out.println("[5] SNACKS");
                System.out.println("******************************************");
                combo = put.nextInt();

                switch (combo) {
                    case 1:
                        orden += "COMBO[1] ";
                        precioxCombo = 3;
                        if (nombrePelicula.equals("SPIDERMAN")) {//SI SE ESCOGE LA PELICULA SPIDERMAN DESCUENTO
                            System.out.println("*******************************************************************************");
                            System.out.println("PARA LA FUNCION SPIDERMAN TENEMOS UN DESCUENTO DE 10% PARA EL COMBO [1]");
                            System.out.println("*******************************************************************************");

                            precioxCombo = precioxCombo - (precioxCombo * 0.10);

                        } else if (nombrePelicula.equals("BARBIE")) {
                            System.out.println("*******************************************************************************");
                            System.out.println("PARA LA FUNCION BARBIE TENEMOS UN DESCUENTO DE 15% PARA EL COMBO [1]");
                            System.out.println("*******************************************************************************");

                            precioxCombo = precioxCombo - (precioxCombo * 0.15);
                        }
                        break;
                    case 2:
                        orden += "COMBO[2] ";
                        if (nombrePelicula.equals("LEGO")) {
                            System.out.println("*******************************************************************************");
                            System.out.println("PARA LA FUNCION LEGO TENEMOS UN DESCUENTO DE 25% PARA EL COMBO[2]");
                            System.out.println("*******************************************************************************");
                            precioxCombo = 7;
                            precioxCombo = precioxCombo - (precioxCombo * 0.25);
                        } else {
                            precioxCombo = 7;
                        }
                        break;
                    case 3:
                        orden += "COMBO[3] ";
                        if (nombreHora.equals("22h00")) {
                            System.out.println("*******************************************************************************");
                            System.out.println("POR SER LA ULTIMA FUNCION 22h00 SE APLICA DESCUENTO DE 50% EN EL COMBO");
                            System.out.println("*******************************************************************************");
                            precioxCombo = 9;
                            precioxCombo = precioxCombo - (precioxCombo * 0.5);//METODO O FUNCION PARA HACER ESTOS CALCULOS
                        } else {
                            precioxCombo = 9;
                        }
                        break;
                    case 4:
                        orden += "COMBO[4] ";
                        System.out.println("*************************************");
                        System.out.println("PERSONALISE SU COMBO");// AQUI UN PARAMETRO PARA INCREMENTAR EL COMBO SEEGUN PRECIO INDIVIDUAL
                        System.out.println("[1] CANGUIL($2.50)");
                        System.out.println("[2] NACHOS ($3)");
                        System.out.println("[3] RASPADO ($2.75)");
                        System.out.println("[4] BURRITO ($3.25)");
                        System.out.println("[5] BEBIDA ($1)");
                        System.out.println("************************************");
                        pcombo = put.nextInt();
                        switch (pcombo) {
                            case 1:
                                precioxCombo = 2.50;
                                break;
                            case 2:
                                precioxCombo = 3;

                                break;
                            case 3:
                                precioxCombo = 2.75;

                                break;
                            case 4:
                                precioxCombo = 3.25;

                                break;
                            case 5:
                                precioxCombo = 1;

                                break;
                        }
                        break;

                    case 5:
                        orden += "SNACK ";
                        System.out.println("ESCOJA SU SNACK");
                        System.out.println("[1] CHOCOLATE JET ($0.75)");
                        System.out.println("[2] DORITOS ($1.25)");
                        System.out.println("[3] M&M'S ($1.50)");
                        System.out.println("[4] GALLETAS OREO ($0.50)");
                        snack = put.nextInt();
                        switch (snack) {
                            case 1:
                                precioxCombo = 0.75;
                                break;
                            case 2:
                                precioxCombo = 1.25;
                                break;
                            case 3:
                                precioxCombo = 1.50;
                                break;
                            case 4:
                                precioxCombo = 0.50;
                                break;
                        }

                        break;
                    default:
                        System.out.println("\n" + "!-!-!-!-!-!-!-!-!-!-!-!-!");
                        System.out.println("NO EXISTE ESA OPCION");
                        System.out.println("ELIGE OTRA VEZ");
                        System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!" + "\n");
                        combo = put.nextInt();

                }

            }
            System.out.println("DESEA COMPRAR OTRO COMBO/SNACK? SI/NO");
            opcion = put.next();
            if (opcion.equals("NO")) {
                seguircomprando = false;
            }
            System.out.println("******************************************");
            totalCombo += precioxCombo;

        }

        //SALGO DEL WHILE y incremento
        System.out.println(facturaSnack(totalCombo, orden));
    }

    

    public static String presentarAsientos(int limFil, int limCol, String asientos[][]) {
        String dibujoAsientos="";
        for (int k = 0; k < limFil; k++) {
            for (int j = 0; j < limCol; j++) {
                dibujoAsientos+=(asientos[k][j] + "\t");
            }
            dibujoAsientos+=("\n");
        }
        return dibujoAsientos;
    }
    public static void transportarDatosDocumento(String mat[][]) {
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

    public static void crearSala(int limFil, int limCol, String asientos[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientos[i][j] = "-";
            }
        }
    }

    public static String facturaPelicula(String facturaAsientos[], int nBoletos, double precioXboleto, String nombrePelicula, String nombreHora, String sala) {
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
        return boletos;
    }
    public static String facturaSnack(double totalCombo, String orden) {
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

        return facturaSn;
    }
}
