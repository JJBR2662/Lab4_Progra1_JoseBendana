package lab4progra1josebendaña;

import java.util.Scanner;
import java.util.Random;

public class Lab4Progra1JoseBendaña {

    public static void main(String[] args) {
        Scanner menu = new Scanner (System.in);
        int eje;
        do{
            System.out.println("1. Fallout words");
            System.out.println("2. Rodatcripne");
            System.out.println("3. Alpha");
            System.out.println();
            System.out.print("Ingrese el ejercicio que quiere evaluar[1,2 o 3]: ");
            eje = menu.nextInt();
            switch(eje){
                case 1:
                    fallout();
                    break;
                case 2:
                    rodatcripne();
                    break;
                case 3:
                    Scanner alpha = new Scanner(System.in);
                    System.out.print("Ingrese la cadena que quiera evaluar: ");
                    String cadena = alpha.nextLine();
                    is_alpha(cadena);
                    break;
                    
                default:
                    System.out.println("Solo se puede del 1-3");
                    break;
            }
        }while(eje>0 && eje<=3);
    }
    public static void fallout (){
        Scanner fallout = new Scanner(System.in);
        System.out.println("1.  Comer       6.  Unida");
        System.out.println("2.  Jugar       7.  Venti");
        System.out.println("3.  Salta       8.  Llama");
        System.out.println("4.  Llora       9.  Eevee");
        System.out.println("5.  Muere       10. Local");
        String palabra="";
        int numpa = new Random().nextInt((10 - 1) + 1) + 1;
        int i=1;
        String copia="";
        int acumespacios=0;
        int acumhay=0;
        switch(numpa){
            case 1:
                palabra = "Comer";
                break;
            case 2:
                palabra = "Jugar";
                break;
            case 3:
                palabra ="Salta";
                break;
            case 4:
                palabra ="Llora";
                break;
            case 5:
                palabra ="Muere";
                break;
            case 6:
                palabra ="Unida";
                break;
            case 7:
                palabra ="Venti";
                break;
            case 8:
                palabra ="Llama";
                break;
            case 9:
                palabra ="Eevee";
                break;
            default:
                palabra ="Local";
                break;
        }
        //todo lo de arria es solo para sacar el random y asignarle la palabra
        for (i = 1; i <= 3; i++) {
            // este for es para los 3 intentos
            System.out.print("Ingrese la palabra: ");
            String opcion = fallout.nextLine();
            if (opcion.equals(palabra)){
                System.out.println("¡Acceso concedido!");
                System.out.println();
                i=26;
            }else{
               int largo = palabra.length();
                for (int j = 0; j <= largo-1; j++) {
                    // este for es para evaluar los caracteres
                    char car = palabra.charAt(j);
                    char car2 = opcion.charAt(j);
                    boolean tener;
                    if(car==car2){
                       acumespacios++;    
                    }
                    for (int k = 0; k <= largo-1; k++){
                        char car3 = opcion.charAt(k);
                        if (car==car3){
                            copia = copia+car3;
                            if(car3==copia.charAt(copia.length()-1)){
                                acumhay++;
                            }else{
                                acumhay--;
                            }
                        }
                    }
                }
                if (acumhay==1){
                    System.out.println("1 letra correcta");
                }else{
                    int alternativo = (acumhay-1);
                    if (alternativo<0){
                        alternativo=0;
                    }
                    System.out.println(alternativo+" letras correctas");
                }
                if (acumespacios==1){
                    System.out.println("1 posicion correcta");
                }else{
                    System.out.println(acumespacios+" posiciones correctas");
                }
            }
            acumespacios=0;
            acumhay=0;
        }
        if (i == 4){
            System.out.println("Usted no ha podido hackearme jajajajaja");
            System.out.println("La respuesta correcta era "+palabra);
            System.out.println();
        }
    }
    
    public static void rodatcripne(){
        Scanner rodat = new Scanner(System.in);
        System.out.print("Ingrese su contrasena: ");
        String palabra = rodat.nextLine();
        palabra = palabra.toLowerCase();
        int largo;
        String alreves = "";
        String sample = "";
        String acumulador = "";
        String buena = "";
        for (largo = palabra.length() - 1; largo >= 0; largo--) {
            char caracter = palabra.charAt(largo);
            acumulador = acumulador + caracter;
            alreves = acumulador;
        }
        sample = alreves.toLowerCase();
        for (int i = 0; i < sample.length(); i++){
            if (i%2!=0){
                int letranum = new Random().nextInt((9 - 0) + 1) + 0;
                buena += letranum;
            }else{
                buena += sample.charAt(i);
            }   
        }
        System.out.println(buena);
    }
    
    public static void is_alpha(String cadena){
        int cuantas = cadena.length();
        boolean esta=true;
        for (int i = 0 ; i <= cuantas -1; i++) {
            //aqui hago el for para que evalue cada caracter de la cadena
            char caracter = cadena.charAt(i);
            int valor=(int) caracter;
            if ((valor >= 65 && valor<=90)||valor>=97&&valor<=122) {
                esta = true;
            }else{
                esta = false;
                System.out.println("La cadena contiene caracteres que no son letras");
                break;
            }  
        }
        if (esta){
            System.out.println("La cadena sólo contiene letras.");
        }
    }
}
