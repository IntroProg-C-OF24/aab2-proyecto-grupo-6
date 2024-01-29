package proyectofinalb2;

import java.util.Scanner;
import java.text.DecimalFormat;

public class ProyectoFinalB2 {

    public static void main(String[] args) {
        Scanner put = new Scanner(System.in);
        String nombrePelicula = "", sala = null, nombreHora = "", nombreCombo = "";
        int comprarBoletos, comprarSnacks, nBoletos, pelicula, hora, fil, col, snack, combo, limFil = 5, limCol = 5, pcombo = 0;
        boolean opcionValida = true, asientoLibre = true, seguircomprando = true;
        double precioXboleto = 4, precioxCombo = 0, totalCombo = 0;
        String opcion;
        String asientos[][] = new String[limFil][limCol];
        System.out.println("****************************");
        System.out.println("DESEA COMPRAR BOLETOS?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        comprarBoletos = put.nextInt(); //si no se compran, se pasa directamente a snacks
        System.out.println("****************************");
        if (comprarBoletos == 1) {
            System.out.println("CUANTOS BOLETOS QUIERE?");
            nBoletos = put.nextInt();
            String facturaAsientos[] = new String[nBoletos];  //se crea en base al numero de boletos comprados
            System.out.println("ELIJA LA PELICULA");
            System.out.println("[1] SPIDERMAN (8$) (estreno)");
            System.out.println("[2] LEGO (4$)");
            System.out.println("[3] BARBIE (4$)");
            pelicula = put.nextInt(); //
            while (opcionValida) {
                switch (pelicula) {
                    case 1:
                        nombrePelicula = "SPIDERMAN";
                        sala = "A";
                        precioXboleto = (precioXboleto * 2);   //al ser estreno se duplica el precio por boleto
                        opcionValida = false;
                        break;
                    case 2:
                        nombrePelicula = "LEGO";
                        sala = "B";
                        opcionValida = false;
                        break;
                    case 3:
                        nombrePelicula = "BARBIE";
                        sala = "C";
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
            System.out.println("[1] 16h00 (descuento - 25%)");
            System.out.println("[2] 18h00");
            System.out.println("[3] 20h00 (tarifa adicional + 25%)");
            System.out.println("[4] 22h00");
            hora = put.nextInt();
            while (opcionValida) {
                switch (hora) {
                    case 1:
                        nombreHora = "16h00";
                        precioXboleto = precioXboleto - (precioXboleto * 0.25); //se reduce el precio por boleto por el descuento de la tarde
                        opcionValida = false;
                        break;
                    case 2:
                        nombreHora = "18h00";
                        opcionValida = false;
                        break;
                    case 3:
                        nombreHora = "20h00";
                        precioXboleto = precioXboleto + (precioXboleto * 0.25);  //se aumenta el precio por boleto por la tarifa adicional de hora pico
                        opcionValida = false;
                        break;
                    case 4:
                        nombreHora = "22h00";
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
                    System.out.println("-ELIJA SU FILA");
                    fil = put.nextInt();
                    System.out.println("-ELIJA SU COLUMNA");
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
                        for (int k = 0; k < limFil; k++) {
                            for (int j = 0; j < limCol; j++) {
                                System.out.print(asientos[k][j] + "\t");
                            }
                            System.out.println("");
                        }
                    }
                }
            }

            System.out.println(facturaPelicula(facturaAsientos, nBoletos, precioXboleto, nombrePelicula, nombreHora, sala));

        }
        System.out.println("****************************");
        System.out.println("DESEA COMPRAR SNACKS?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        comprarSnacks = put.nextInt();
        System.out.println("****************************");
        while (seguircomprando) {
            if (comprarSnacks == 1) {
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
                        nombreCombo += "COMBO[1] ";
                        if (nombrePelicula.equals("SPIDERMAN")) {//SI SE ESCOGE LA PELICULA SPIDERMAN DESCUENTO
                            System.out.println("*******************************************************************************");
                            System.out.println("PARA LA FUNCION SPIDERMAN TENEMOS UN DESCUENTO DE 10% PARA EL COMBO [1]");
                            System.out.println("*******************************************************************************");
                            precioxCombo = 3;
                            precioxCombo = precioxCombo - (precioxCombo * 0.10);

                        } else if (nombrePelicula.equals("BARBIE")) {
                            System.out.println("*******************************************************************************");
                            System.out.println("PARA LA FUNCION BARBIE TENEMOS UN DESCUENTO DE 15% PARA EL COMBO [1]");
                            System.out.println("*******************************************************************************");
                            precioxCombo = 3;
                            precioxCombo = precioxCombo - (precioxCombo * 0.15);
                        } else {
                            precioxCombo = 3;
                        }
                        break;
                    case 2:
                        nombreCombo += "COMBO[2] ";
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
                        nombreCombo += "COMBO[3] ";
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
                        nombreCombo += "COMBO[4] ";
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
                        nombreCombo += "SNACK ";
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
        System.out.println(facturaSnack(totalCombo, nombreCombo));
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
                + "Precio por Boleto: " + precioXboleto + "\n"
                + "Pelicula: " + nombrePelicula + "\n"
                + "Hora: " + nombreHora + "\n"
                + "Total: " + (nBoletos * precioXboleto) + "\n"
                + "IVA: " + ivaDecim + "\n"
                + "Total a Pagar: " + totalPagarPeliculaDecim + "\n"
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

    public static String facturaSnack(double totalCombo, String nombreCombo) {
        String facturaSn = "";
        DecimalFormat df = new DecimalFormat("#.##"); //es una clase que permite reducir valores decimales
        double iva = (totalCombo * 0.12), total = (totalCombo + iva);
        String totalDecim = df.format(totalCombo);
        String ivaDecim = df.format(iva);
        String totalPagarSnacksDecim = df.format(total);  //se guardan los datos en variables con los decimales reducidos
        facturaSn += "==================== FACTURA ====================" + "\n"
                + "Orden:" + nombreCombo + "\n"
                + "IVA: " + ivaDecim + "\n"
                + "TOTAL: " + totalDecim + "\n"
                + "TOTAL A PAGAR: " + totalPagarSnacksDecim + "\n"
                + "=================================================" + "\n\n\n\n\n";

        return facturaSn;
    }
}
