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
public class Administrador extends Thread {
    
    private Procesador ai;
    
    public Administrador (Procesador ai) {
        this.ai = ai;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            ai.race(new Car(1), new Car(2));
            System.out.println("Administrador");
        }
    }
    
}
