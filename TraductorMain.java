import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * 
 * @author José Rodrigo Barrera García Carnet: 20807 
 * Universidad del Valle de Guatemala
 * Cada uno de los codigos fueron tomados encuenta de los ejemplos brindados por Douglas
 *Al igual que cada uno de los archivos de texto colocados en esta hoja de trabajo
 */
public class TraductorMain {
	
	/*Declaramos de manera publica las variables de las cuales
	 * nos serviran para almacenar el tipo de idioma en el que se 
	 * encuentra el texto original, y en donde el usuario indicara a que 
	 * idioma se va a traducir. Dichos valores serán llevados a ComparableWords
	 * */
    public static String Idioma;
    public static String IdiomaTraducido;

    public static void main(String[] args) {
    	//Creamos las instancias de nuestras clases
        Scanner entrada = new Scanner(System.in);
        BinaryTree<ComparableWords> Arbol = new BinaryTree<ComparableWords>();
        //Creamos los iteradores de nuestros bucles y opciones de menu
        int opciones=0,opciones2=0;
        boolean Iterador = false;
        boolean Iterador2=false;
        
        /* while que nos servirá para controlar el primer menú
         * en donde el usuario ingresa en que idioma se encuentra inicialmente el archivo 
         * de texto.
         */
        while (!Iterador){
        	try {
        		 
        		System.out.println("Bienvenido a mi traductor por medio de arboles :D\n");
        	     System.out.println("Ingrese el idioma en el que se encuentra inicialmente el texto: ");
        	     System.out.println("\n1 Ingles\n2 Español\n3 Frances");
        	        
                opciones=entrada.nextInt();
            switch(opciones) {
            	case 1:
            		Idioma="ingles";
            		Iterador=true;
            		break;
            	case 2:
            		Idioma="español"; //Por medio de Switch tomamos la opción que ingrese el usuario y la almacenamos en una variable
            		Iterador=true;
            		break;
            	case 3:
            		Idioma="frances";
            		Iterador=true;
            	default:
            		System.out.println("Lo sentimos, sobrepaso el número de opciones");
            		break;
            		}
             
        }catch (Exception e) {
        	
        	System.out.println("El valor ingresado no es numerico\n");
        	entrada.next();
        
        	}
        
        }

    
        entrada.nextLine();
        Iterador2=false;
        
        /*While que nos servira para controlar el segundo menú en donde el usuario deberá 
         * elegir la opción del idioma al que desea traducir el texto.
         */
        while (!Iterador2){
        	try {
        	     System.out.println("Ingrese una opción a la cual desea traducir el texto: ");
        	     System.out.println("\n1 Ingles\n2 Español\n3 Frances");
        	        
                opciones2=entrada.nextInt();
            switch(opciones2) {
            	case 1:
            		IdiomaTraducido="ingles";
            		Iterador2=true;
            		break;
            	case 2:
            		IdiomaTraducido="español";
            		Iterador2=true;
            		break;
            	case 3:
            		IdiomaTraducido="frances";
            		Iterador2=true;
            		break;
            	default:
            		System.out.println("Lo sentimos, sobrepaso el número de opciones");
            		break;
            		}
             
        }catch (Exception e) {
        	
        	System.out.println("El valor ingresado no es numerico\n");
        	entrada.next();
        
        	}
        }
        
        /*Parte encargada de leer diccionario, para de esa forma tener las palabras
         * con las que comprararemos nuestra frase
         * */
        try {
            File myObj = new File("Diccionario.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.split(",");
                ComparableWords word = new ComparableWords(words[0],words[1],words[2]);
              
                Arbol.add(word);
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        /*Parte encargada de leer el archivo el cual nosotros 
         * queremos traducir.
         */
        try {
            File myObj = new File("texto.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("\nTexto original a traducir :");
                System.out.println(data);
                data=data.replace("*","");
                String[] words = data.split(" ");
                for (int i=0;i<words.length;i++){
                    if (Arbol.locate(new ComparableWords(words[i])) != null){
                        words[i] = Arbol.locate(new ComparableWords(words[i])).value.getWord(IdiomaTraducido);
                    }
                }
                //Funcion que nos devuelve el texto traducido.
                data = String.join(" ",words);
                System.out.println("\nTexto traducido:");
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
