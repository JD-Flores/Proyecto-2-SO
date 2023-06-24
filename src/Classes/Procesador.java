/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Diego
 */
public class Procesador extends Thread {
    
    private int processingTime;
    public String state;
    private double raceResult;
    private Car winner;
    private Random random = new Random();
    
    public Procesador (int processingTimeInMs){
        this.processingTime = processingTimeInMs;
        this.state = "Esperando";
    }
    
    public Car chooseWinner(Car bugattiCar, Car lamborghiniCar) {
        
        //Se elige el ganador dependiendo de su calidad total. Si tienen la misma calidad, se elige al azar
        
        if (bugattiCar.getOverallQuality()>lamborghiniCar.getOverallQuality()) {
            System.out.println("    Ganador: B"+ Integer.toString(bugattiCar.getId()));
            return bugattiCar;
        } else if (lamborghiniCar.getOverallQuality()>bugattiCar.getOverallQuality()) {
            System.out.println("    Ganador: L"+ Integer.toString(lamborghiniCar.getId()));
            return lamborghiniCar;
        } else {
            if (random.nextBoolean()) {
                System.out.println("    Ganador: B"+ Integer.toString(bugattiCar.getId()));
                return bugattiCar;
            } else {
                System.out.println("    Ganador: L"+ Integer.toString(lamborghiniCar.getId()));
                return lamborghiniCar;
            }
        }
    }
    
    public void race(Car bugattiCar, Car lamborghiniCar){
        try {
            sleep(processingTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Carrera: B"+ Integer.toString(bugattiCar.getId()) +" vs L"+ Integer.toString(lamborghiniCar.getId()));
        System.out.println("    Calidad: "+ Integer.toString(bugattiCar.getOverallQuality()) +" vs "+ Integer.toString(lamborghiniCar.getOverallQuality()));
        
        raceResult = Math.random()*100;
        if (raceResult>=60){
            winner = chooseWinner(bugattiCar, lamborghiniCar);
        } else if (raceResult >=33) {
            System.out.println("    Empate");
        } else {
            System.out.println("    No se puede llevar a cabo la carrera");
        }
    }
}