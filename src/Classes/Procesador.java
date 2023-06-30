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
    private int bugattiRaceTimeInSeconds;
    private int lamborghiniRaceTimeInSeconds;
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
        bugattiRaceTimeInSeconds = calculateRaceTime(bugattiCar);
        System.out.println("B"+bugattiCar.getId()+" tiempo: "+ stringTime(bugattiRaceTimeInSeconds));
        lamborghiniRaceTimeInSeconds = calculateRaceTime(lamborghiniCar);        
        System.out.println("L"+lamborghiniCar.getId()+" tiempo: "+ stringTime(lamborghiniRaceTimeInSeconds));
        
        
        if (bugattiRaceTimeInSeconds<lamborghiniRaceTimeInSeconds) {
            System.out.println("    Ganador: B"+ Integer.toString(bugattiCar.getId()));
            return bugattiCar;
        } else if (bugattiRaceTimeInSeconds>lamborghiniRaceTimeInSeconds) {
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

    public String stringTime(int raceTimeTotal) {
        String raceSeconds;
        if (raceTimeTotal%60>=10) {
            raceSeconds = Integer.toString(raceTimeTotal%60);
        }
        else{
            raceSeconds = "0"+raceTimeTotal%60;
        }
        return raceTimeTotal/60+":"+raceSeconds;
    }
    
    public int calculateRaceTime(Car car) {
        int raceTimeTotal = 
                random.nextInt(20)+50-car.getCarroceriaQuality()*30
                + random.nextInt(20)+60-car.getChasisQuality()*20 
                + random.nextInt(30)+120-car.getMotorQuality()*60
                + random.nextInt(30)+80-car.getRuedasQuality()*50
                ;
        return raceTimeTotal;
    }
    
    public Car race(Car bugattiCar, Car lamborghiniCar){
        try {
            sleep(processingTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Carrera: B"+ Integer.toString(bugattiCar.getId()) +" vs L"+ Integer.toString(lamborghiniCar.getId()));
        System.out.println("    Calidad: "+ Integer.toString(bugattiCar.getOverallQuality()) +" vs "+ Integer.toString(lamborghiniCar.getOverallQuality()));
        
        raceResult = random.nextInt(100);
        if (raceResult>=60){
            bugattiCar.state = "racing";
            lamborghiniCar.state = "racing";
            try {
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
            winner = chooseWinner(bugattiCar, lamborghiniCar);
            if (winner == bugattiCar) {
                bugattiCar.state = "winner";
                lamborghiniCar.state = "loser";
            } else {
                bugattiCar.state = "loser";
                lamborghiniCar.state = "winner";
            }
            return winner;
        } else if (raceResult >=33) {
            bugattiCar.state = "tie";
            lamborghiniCar.state = "tie";
            bugattiRaceTimeInSeconds = random.nextInt(260)+150;
            lamborghiniRaceTimeInSeconds = bugattiRaceTimeInSeconds;
            System.out.println("    Empate: "+stringTime(bugattiRaceTimeInSeconds));
            return bugattiCar;
        } else {
            bugattiCar.state = "repair";
            lamborghiniCar.state = "repair";
            System.out.println("    No se puede llevar a cabo la carrera");
            return bugattiCar;
        }
    }

    public int getBugattiRaceTimeInSeconds() {
        return bugattiRaceTimeInSeconds;
    }

    public int getLamborghiniRaceTimeInSeconds() {
        return lamborghiniRaceTimeInSeconds;
    }
    
    
}