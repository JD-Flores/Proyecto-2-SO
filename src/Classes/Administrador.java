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
    public int BCarsCount;
    public int LCarsCount;
    public int VCount;

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
        
        this.BCarsCount = 0;
        this.LCarsCount = 0;
        this.VCount = 0;
    }
    
    public void createBugattiCar(){
        availableId++;
        Car car = new Car(availableId);
        int quality = car.getOverallQuality();
        if (quality >= 200) {
            cola1Bugatti.add(car);
        } else if (quality > 150 && quality < 200) {
            cola2Bugatti.add(car);
        } else {
            cola3Bugatti.add(car);
        }
        BCarsCount++;
    }
    public void createLamborghiniCar(){
        availableId++;
        Car car = new Car(availableId);
        int quality = car.getOverallQuality();
        if (quality >= 200) {
            cola1Lamborghini.add(car);
        } else if (quality > 150 && quality < 200) {
            cola2Lamborghini.add(car);
        } else {
            cola3Lamborghini.add(car);
        }
        LCarsCount++;
        
    }
    public void raiseVehicleCount(){
        
        for (int i = 0; i<cola1Bugatti.size(); i++) {
            Car car = cola1Bugatti.poll();
            car.raiseWaitCount();
            if(car.getWaitCount()==8){
                car.resetWaitCount();
            } else {
                cola1Bugatti.add(car);
            }
        }
        
        for (int i = 0; i<cola2Bugatti.size(); i++) {
            Car car = cola2Bugatti.poll();
            car.raiseWaitCount();
            if(car.getWaitCount()==8){
                car.resetWaitCount();
                cola1Bugatti.add(car);
            } else {
                cola2Bugatti.add(car);
            }
        }
        
        for (int i = 0; i<cola3Bugatti.size(); i++) {
            Car car = cola3Bugatti.poll();
            car.raiseWaitCount();
            if(car.getWaitCount()==8){
                car.resetWaitCount();
                cola2Bugatti.add(car);
            } else {
                cola3Bugatti.add(car);
            }
        }
        
        for (int i = 0; i<cola1Lamborghini.size(); i++) {
            Car car = cola1Lamborghini.poll();
            car.raiseWaitCount();
            if(car.getWaitCount()==8){
                car.resetWaitCount();
            } else {
                cola1Lamborghini.add(car);
            }
        }
        
        for (int i = 0; i<cola2Lamborghini.size(); i++) {
            Car car = cola2Lamborghini.poll();
            car.raiseWaitCount();
            if(car.getWaitCount()==8){
                car.resetWaitCount();
                cola1Lamborghini.add(car);
            } else {
                cola2Lamborghini.add(car);
            }
        }
        
        for (int i = 0; i<cola3Lamborghini.size(); i++) {
            Car car = cola3Lamborghini.poll();
            car.raiseWaitCount();
            if(car.getWaitCount()==8){
                car.resetWaitCount();
                cola2Lamborghini.add(car);
            } else {
                cola3Lamborghini.add(car);
            }
        }
        

    }
    
    @Override
    public void run() {
        /*
        Crear 10 carros antes de empezar
        */
        int BCount = 0;
        int LCount = 0;
        
        while (BCount<10) {
            createBugattiCar();
            BCount++;
        }
        
        while (LCount<10) {
            createLamborghiniCar();
            LCount++;
        }
        
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("B" + BCarsCount  + "L" + LCarsCount);
            if (!cola1Bugatti.isEmpty()) {
                currentBugattiCar = cola1Bugatti.remove();
            } else if (cola1Bugatti.isEmpty() && !cola2Bugatti.isEmpty()) {
                currentBugattiCar = cola2Bugatti.remove();
            } else if (cola1Bugatti.isEmpty() && cola2Bugatti.isEmpty() && !cola3Bugatti.isEmpty()) {
                currentBugattiCar = cola3Bugatti.remove();

            } else {
                System.out.println("No hay más vehículos de Bugatti");
                currentBugattiCar = null;
            }
            
            if (!cola1Lamborghini.isEmpty()) {
                currentLamborghiniCar = cola1Lamborghini.remove();
            } else if (cola1Lamborghini.isEmpty() && !cola2Lamborghini.isEmpty()) {
                currentLamborghiniCar = cola2Lamborghini.remove();
            } else if (cola1Lamborghini.isEmpty() && cola2Lamborghini.isEmpty() && !cola3Lamborghini.isEmpty()) {
                currentLamborghiniCar = cola3Lamborghini.remove();
            } else {
                System.out.println("No hay más vehículos de Lamborghini");
                currentLamborghiniCar = null;
            }
            /*en realidad debe crear dos carros y mandarlos a las colas que les correspondan dependiendo de su calidad
                O sea, si carroCreado.overallQuality > 200, cola 1
                else if carroCreado.overallQuality > 150, cola 2
                etc
                (valores de prueba, hay que probar los valores que hagan que se distribuyan entre las 3 colas)
            */
            System.out.println("Administrador");
            
            //currentBugattiCar y currentLamborghiniCar deben ser carros extraidos de las colas 1 de ambas marcas
            VCount ++;
            if(VCount == 2) {
                VCount = 0;
                createBugattiCar();
                createLamborghiniCar();

                System.out.println("Se insertaron 2 carros");
            }
            if (currentBugattiCar != null && currentLamborghiniCar != null) {
                this.ai.race(currentBugattiCar, currentLamborghiniCar);
                raiseVehicleCount();
                
            } else {
                System.out.println("No hay suficientes carros para testear");
            }
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
