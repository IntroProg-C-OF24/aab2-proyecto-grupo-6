package proyectofinalb2;
import java.util.Scanner;
public class ProyectoFinalB2 {
    public static void main(String[] args) {
        Scanner put=new Scanner(System.in);
        String nombrePelicula=null, sala=null, nombreHora;
        int comprarBoletos, comprarSnacks, nBoletos, pelicula, hora, fil, col, combo, snack, limFil=5, limCol=5;
        boolean opcionValida = true;
        String asientos[][] = new String [limFil][limCol];
        System.out.println("DESEA COMPRAR BOLETOS?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        comprarBoletos = put.nextInt();
        if(comprarBoletos==1){
            System.out.println("CUANTOS BOLETOS QUIERE?");
            nBoletos = put.nextInt();
            System.out.println("ELIJA LA PELICULA");
            System.out.println("[1] SPIDERMAN (8$) (estreno)");
            System.out.println("[2] LEGO (4$)");
            System.out.println("[3] BARBIE (4$)");
            pelicula = put.nextInt();
            while(opcionValida){
                switch(pelicula){
                    case 1:
                        nombrePelicula="SPIDERMAN";
                        sala="A";
                        opcionValida = false;
                        break;
                    case 2:
                        nombrePelicula="LEGO";
                        sala="B";
                        opcionValida = false;
                        break;
                    case 3:
                        nombrePelicula="BARBIE";
                        sala="C";
                        opcionValida = false;
                        break;
                    default:
                        System.out.println("NO EXISTE ESA OPCION");
                        System.out.println("ELIGE OTRA VEZ");
                        pelicula = put.nextInt();
                }
            }
            opcionValida = true;
            System.out.println("ELIJA LA HORA");
            System.out.println("[1] 16h00 (descuento)");
            System.out.println("[2] 18h00");
            System.out.println("[3] 20h00 (tarifa adicional)");
            System.out.println("[4] 22h00");
            hora = put.nextInt();
            while(opcionValida){
                switch(pelicula){
                    case 1:
                        nombreHora="16h00";
                        opcionValida = false;
                        break;
                    case 2:
                        nombreHora="18h00";
                        opcionValida = false;
                        break;
                    case 3:
                        nombreHora="20h00";
                        opcionValida = false;
                        break;
                    case 4:
                        nombreHora="22h00";
                        opcionValida = false;
                        break;
                    default:
                        System.out.println("NO EXISTE ESA OPCION");
                        System.out.println("ELIGE OTRA VEZ");
                        pelicula = put.nextInt();
                }
            }
            for (int i = 0; i < nBoletos; i++) {
                System.out.println("ELIJA SUS ASIENTOS");
                System.out.println("-ELIJA SU FILA");
                fil = put.nextInt();
                System.out.println("-ELIJA SU COLUMNA");
                col = put.nextInt();
                asientos[fil][col] = "X";
                
            }
        }

    }
    
}
