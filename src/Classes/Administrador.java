/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Diego
 */
public class Administrador extends Thread {
    
    private Procesador ai;
    private int availableId;
    public Car currentBugattiCar;
    private Car currentLamborghiniCar;

    private Queue<Car> cola1Bugatti;
    private Queue<Car> cola2Bugatti;
    private Queue<Car> cola3Bugatti;
    private Queue<Car> colaRefuerzoBugatti;
    
    private Queue<Car> cola1Lamborghini;
    private Queue<Car> cola2Lamborghini;
    private Queue<Car> cola3Lamborghini;
    private Queue<Car> colaRefuerzoLamborghini;
    
    public Administrador (Procesador ai) {
        this.availableId = 0;
        this.ai = ai;

        this.cola1Bugatti = new LinkedList<>();
        this.cola2Bugatti = new LinkedList<>();
        this.cola3Bugatti = new LinkedList<>();
        this.colaRefuerzoBugatti = new LinkedList<>();

        this.cola1Lamborghini = new LinkedList<>();
        this.cola2Lamborghini = new LinkedList<>();
        this.cola3Lamborghini = new LinkedList<>();
        this.colaRefuerzoLamborghini = new LinkedList<>();
    }
    
    public Car createCar(int id){
        availableId++;
        return new Car(availableId);
    }
    
    @Override
    public void run() {
        /*
        Crear 10 carros antes de empezar
        */
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.currentBugattiCar = createCar(availableId);
            this.currentLamborghiniCar = createCar(availableId);
            //en realidad debe crear dos carros y mandarlos a las colas que les correspondan dependiendo de su calidad
            System.out.println("Administrador");
            
            //currentBugattiCar y currentLamborghiniCar deben ser carros extraidos de las colas 1 de ambas marcas
            this.ai.race(currentBugattiCar, currentLamborghiniCar);
        }
    }

    public Queue<Car> getCola1Bugatti() {
        return cola1Bugatti;
    }

    public Queue<Car> getCola2Bugatti() {
        return cola2Bugatti;
    }

    public Queue<Car> getCola3Bugatti() {
        return cola3Bugatti;
    }

    public Queue<Car> getColaRefuerzoBugatti() {
        return colaRefuerzoBugatti;
    }

    public Queue<Car> getCola1Lamborghini() {
        return cola1Lamborghini;
    }

    public Queue<Car> getCola2Lamborghini() {
        return cola2Lamborghini;
    }

    public Queue<Car> getCola3Lamborghini() {
        return cola3Lamborghini;
    }

    public Queue<Car> getColaRefuerzoLamborghini() {
        return colaRefuerzoLamborghini;
    }
    
    
}
