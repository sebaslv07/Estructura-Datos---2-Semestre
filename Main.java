package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static Stack<Integer> llenarStack(Stack<Integer> numeros, Scanner scan){
        System.out.println("Ingresa el numero");
        int number = scan.nextInt();
        numeros.push(number);
        System.out.println("Stack: "+numeros);
        return numeros;
    }
    
    public static int encontrarMaximo(Stack<Integer> numeros) { 
        Stack<Integer> auxiliar = new Stack<>();
        int maximo = numeros.peek(); 
        
        while (!numeros.isEmpty()) {
            int actual = numeros.pop();
            if (actual > maximo) {
                maximo = actual;
            }
            auxiliar.push(actual);
        }
        
        while (!auxiliar.isEmpty()) {
        	numeros.push(auxiliar.pop());
        }
        
        return maximo;
    }
    
    public static int encontrarMinimo(Stack<Integer> numeros) {
        Stack<Integer> auxiliar = new Stack<>();
        int minimo = numeros.peek(); 
        
        while (!numeros.isEmpty()) {
            int actual = numeros.pop();
            if (actual < minimo) {
            	minimo = actual;
            }
            auxiliar.push(actual);
        }
        
        while (!auxiliar.isEmpty()) {
        	numeros.push(auxiliar.pop());
        }
        
        return minimo;
    }
    
    public static int sumarElementos(Stack<Integer> numeros) {
        if (numeros.isEmpty()) {
            return 0;
        }
        
        Stack<Integer> auxiliar = new Stack<>();
        int suma = 0;
        
        while (!numeros.isEmpty()) {
            int actual = numeros.pop();
            suma += actual;
            auxiliar.push(actual);
        }
        
        while (!auxiliar.isEmpty()) {
        	numeros.push(auxiliar.pop());
        }
        
        return suma;
    }
    
    public static void buscarElemento(Stack<Integer> numeros, Scanner scan) {
        
        System.out.print("Ingrese el elemento a buscar: ");
        int elemento = scan.nextInt();
        
        Stack<Integer> auxiliar = new Stack<>();
        boolean encontrado = false;
        
        while (!numeros.isEmpty()) {
            int actual = numeros.pop();
            if (actual == elemento) {
                encontrado = true;
            }
            auxiliar.push(actual);
        }
        
        while (!auxiliar.isEmpty()) {
        	numeros.push(auxiliar.pop());
        }
        
        if (encontrado) {
            System.out.println("El elemento " + elemento + " SI esta presente en el stack");
        } else {
            System.out.println("El elemento " + elemento + " NO esta presente en el stack");
        }
    }
    
    public static void eliminarDuplicados(Stack<Integer> numeros) {
        if (numeros.isEmpty()) {
            System.out.println("El stack está vacío");
            return;
        }
        
        Stack<Integer> auxiliar = new Stack<>();
        Stack<Integer> unicos = new Stack<>();
        
        while (!numeros.isEmpty()) {
            auxiliar.push(numeros.pop());
        }
        
        while (!auxiliar.isEmpty()) {
            int actual = auxiliar.pop();
            
            boolean duplicado = false;
            Stack<Integer> temp = new Stack<>();
            
            while (!unicos.isEmpty()) {
                int elemento = unicos.pop();
                if (elemento == actual) {
                    duplicado = true;
                }
                temp.push(elemento);
            }
            
            while (!temp.isEmpty()) {
                unicos.push(temp.pop());
            }
            
            if (!duplicado) {
                unicos.push(actual);
            }
        }
        
        while (!unicos.isEmpty()) {
        	numeros.push(unicos.pop());
        }
        
        System.out.println("Duplicados eliminados");
        System.out.println("Stack: "+numeros);
    }
    
    public static void main(String[] args) {

        Stack<Integer> numeros= new Stack<>();
        Scanner scan = new Scanner(System.in);
        boolean exit = true;
        do {
            System.out.println("1. Agregar un numero al Stack");
            System.out.println("2. Encontrar el numero maximo y el numero minimo");
            System.out.println("3. Sumar los elementos del Stack");
            System.out.println("4. Verficar si hay un elemento en el Stack");
            System.out.println("5. Eliminar elementos duplicados");
            System.out.println("6. Exit");
            int option = scan.nextInt();
            switch(option) {
            case 1:
                llenarStack(numeros,scan);
                System.out.println("Size: "+numeros.size());
                break;
            case 2:
            	System.out.println("El numero maximo del Stack: " + encontrarMaximo(numeros));
            	System.out.println("El numero minimo del Stack: " + encontrarMinimo(numeros));
                break;

            case 3:
            	System.out.println("Total de la suma: " + sumarElementos(numeros));
                break;
                
            case 4:
            	buscarElemento(numeros, scan);
                break;
                
            case 5:
            	
            	eliminarDuplicados(numeros);
                break;
            case 6:
                exit = false;
                System.out.println("Cerrando Programa...");
                System.out.println("¡Adios!");
                break;
            }


        }while(exit);

    }

}