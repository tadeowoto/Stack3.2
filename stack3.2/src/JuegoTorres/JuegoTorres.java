package JuegoTorres;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amiev
 */
public class JuegoTorres {
    private PilaInt pila1 = new PilaInt(5);
    private PilaInt pila2 = new PilaInt(5);
    private PilaInt pila3 = new PilaInt(5);
    private Scanner leer= new Scanner(System.in);

    public JuegoTorres() {
        int j = 5; 
        for(int i = 5; i > 0; i--){
            pila1.push(i);
        }
    }
     
    public void mover(int orig, int dest){
        
    }
    
    public void menu(){
        System.out.println("¿Qué desea hacer?");
        System.out.println("1- Mover disco");
        System.out.println("2- Salir del juego");
        int op1 = leer.nextInt();
        if(op1 == 1){
            System.out.println("¿De qué pila desea mover?");
            System.out.println("1- pila 1");
            System.out.println("2- pila 2");
            System.out.println("3- pila 3");
            int op2 = leer.nextInt();
            System.out.println("¿A qué pila desea mover?");//agregar ver elemento en el menú
            System.out.println("1- pila 1");
            System.out.println("2- pila 2");
            System.out.println("3- pila 3");
            int op3 = leer.nextInt(); 
            mover(op2, op3);
        } 
    }
}
