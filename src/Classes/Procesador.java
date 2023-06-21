/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Diego
 */
public class Procesador extends Thread {
    
    private int processingTime;
    public String state;
    
    public Procesador (int processingTimeInMs){
        this.processingTime = processingTimeInMs;
        this.state = "Esperando";
    }
    
    public void race(Car bugattiCar, Car lamborghiniCar){
        try {
            sleep(processingTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Carrera: "+ Integer.toString(bugattiCar.getId()) +" vs "+ Integer.toString(lamborghiniCar.getId()));
        
    }
}