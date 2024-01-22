package proyectofinalb2;
import java.util.Scanner;
public class ProyectoFinalB2 {
    public static void main(String[] args) {
        Scanner put=new Scanner(System.in);
        String nombrePelicula=null, sala=null, nombreHora=null, asientosCadena=null;
        int comprarBoletos, comprarSnacks, nBoletos, pelicula, hora, fil, col, combo, snack, limFil=5, limCol=5;
        boolean opcionValida = true, asientoLibre = true;
        double precioXboleto=4;
        String asientos[][] = new String [limFil][limCol];
        System.out.println("****************************");
        System.out.println("DESEA COMPRAR BOLETOS?");
        System.out.println("[1] Si");
        System.out.println("[2] No");
        comprarBoletos = put.nextInt();
        System.out.println("****************************");
        if(comprarBoletos==1){
            System.out.println("CUANTOS BOLETOS QUIERE?");
            nBoletos = put.nextInt();
            String facturaAsientos[]=new String[nBoletos];
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
                        precioXboleto=(precioXboleto*2);
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
                        System.out.println("\n"+"!-!-!-!-!-!-!-!-!-!-!-!-!");
                        System.out.println("NO EXISTE ESA OPCION");
                        System.out.println("ELIGE OTRA VEZ");
                        System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!"+"\n");
                        pelicula = put.nextInt();
                        
                }
            }
            System.out.println("****************************");
            opcionValida = true;
            System.out.println("ELIJA LA HORA");
            System.out.println("[1] 16h00 (descuento)");
            System.out.println("[2] 18h00");
            System.out.println("[3] 20h00 (tarifa adicional)");
            System.out.println("[4] 22h00");
            hora = put.nextInt();
            while(opcionValida){
                switch(hora){
                    case 1:
                        nombreHora="16h00";
                        precioXboleto=precioXboleto-(precioXboleto*0.25);
                        opcionValida = false;
                        break;
                    case 2:
                        nombreHora="18h00";
                        opcionValida = false;
                        break;
                    case 3:
                        nombreHora="20h00";
                        precioXboleto=precioXboleto+(precioXboleto*0.25);
                        opcionValida = false;
                        break;
                    case 4:
                        nombreHora="22h00";
                        opcionValida = false;
                        break;
                    default:
                        System.out.println("\n"+"!-!-!-!-!-!-!-!-!-!-!-!-!");
                        System.out.println("NO EXISTE ESA OPCION");
                        System.out.println("ELIGE OTRA VEZ");
                        System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!"+"\n");
                        hora = put.nextInt();
                        
                }
            }
            System.out.println("****************************");
            crearSala(limFil,limCol,asientos);
            for (int i = 0; i < nBoletos; i++) {
                asientoLibre=true;
                while(asientoLibre){
                    System.out.println("----------------------");
                    System.out.println("ELIJA SUS ASIENTOS");
                    System.out.println("-ELIJA SU FILA");
                    fil = put.nextInt();
                    System.out.println("-ELIJA SU COLUMNA");
                    col = put.nextInt();
                    System.out.println("----------------------");
                    if(asientos[fil-1][col-1]=="X"){
                        System.out.println("\n"+"!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!");
                        System.out.println("ESE ASIENTO YA ESTA OCUPADO, PRUEBA CON OTRO");
                        System.out.println("!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!-!"+"\n");
                    }else{  
                        asientos[fil-1][col-1] = "X";
                        asientoLibre=false;
                        facturaAsientos[i]=fil+"-"+col;
                    }
                }
            }
            
            System.out.println(facturaPelicula( facturaAsientos,  nBoletos, precioXboleto, nombrePelicula, nombreHora, sala ));
            
        }
    }
    public static void crearSala(int limFil, int limCol, String asientos[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientos[i][j]="";
            }
        }
    }
    
    public static String facturaPelicula (String facturaAsientos[], int nBoletos, double precioXboleto, String nombrePelicula, String nombreHora, String sala ){
        String boletos="";
        boletos+="==================== FACTURA ===================="+"\n"+
                "Numero de Boletos: "+nBoletos+"\n"+
                "Precio por Boleto: "+precioXboleto+"\n"+
                "Pelicula: "+nombrePelicula+"\n"+
                "Hora: "+nombreHora+"\n"+
                "Total a Pagar: "+(nBoletos*precioXboleto)+"\n"+
                "================================================="+"\n\n\n\n\n";
        for (int i = 0; i < nBoletos; i++) {
            boletos+="==================== BOLETO "+(i+1)+" ===================="+"\n"+
                    "Pelicula: "+nombrePelicula+"\n"+
                    "Hora: "+nombreHora+"\n"+
                    "Sala: "+sala+"\n"+
                    "Asiento: "+facturaAsientos[i]+"\n"+
                    "=================================================="+"\n\n\n";
        }
        return boletos;
    }
    /*
    public static String presentarAsientos(int limFil, int limCol, String asientosCadena, String asientos[][]) {
        for (int i = 0; i < limFil; i++) {
            for (int j = 0; j < limCol; j++) {
                asientosCadena += String.format(asientos[i][j]+"\t|\t");
            }
            asientosCadena += String.format(asientosCadena+"\n");
        }
        return asientosCadena;
    } 
    */
}