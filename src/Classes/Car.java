/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Random;

/**
 *
 * @author Juan Diego
 */
public class Car {
    
    private int id;
    private int carroceriaQuality;
    private int chasisQuality;
    private int motorQuality;
    private int ruedasQuality;
    private int overallQuality;
    private int model;
    private int waitCount;
    public String state;
    public String company;
    private Random random = new Random();
    
    public Car (int id) {
        this.id = id;
        this.state = "waiting";

        if (Math.random()*100>=40) {
            this.carroceriaQuality = 1;
        } else {
            this.carroceriaQuality = 0;
        }

        if (Math.random()*100>=30) {
            this.chasisQuality = 1;
        } else {
            this.chasisQuality = 0;
        }

        if (Math.random()*100>=50) {
            this.motorQuality = 1;
        } else {
            this.motorQuality = 0;
        }

        if (Math.random()*100>=60) {
            this.ruedasQuality = 1;
        } else {
            this.ruedasQuality = 0;
        }  

        this.overallQuality = this.carroceriaQuality*60 + this.chasisQuality*50 + this.motorQuality*100 + this.ruedasQuality*80;
        
        model = random.nextInt(5) + 1;
        
        this.waitCount = 0;

    }

    public int getId() {
        return id;
    }

    public int getOverallQuality() {
        return overallQuality;
    }
    
    public int getWaitCount() {
        return waitCount;
    }
    
    public void raiseWaitCount(){
        waitCount++;
    }
    
    public void resetWaitCount() {
        waitCount = 0;
    }
    
    public String getState(){
        return state;
    }

    public int getCarroceriaQuality() {
        return carroceriaQuality;
    }

    public int getChasisQuality() {
        return chasisQuality;
    }

    public int getMotorQuality() {
        return motorQuality;
    }

    public int getRuedasQuality() {
        return ruedasQuality;
    }

    public int getModel() {
        return model;
    }
    
}
