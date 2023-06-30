/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.LinkedList;
import java.util.Objects;
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
    public Car currentLamborghiniCar;
    public Car result;
    public int BCarsCount;
    public int LCarsCount;
    public int VCount;

    public Queue<Car> bugattiWinners;
    public Queue<Car> lamborghiniWinners;

    private Queue<Car> cola1Bugatti;
    private Queue<Car> cola2Bugatti;
    private Queue<Car> cola3Bugatti;
    private Queue<Car> colaRefuerzoBugatti;

    private Queue<Car> cola1Lamborghini;
    private Queue<Car> cola2Lamborghini;
    private Queue<Car> cola3Lamborghini;
    private Queue<Car> colaRefuerzoLamborghini;

    private String cola1BugattiText = "";
    private String cola2BugattiText = "";
    private String cola3BugattiText = "";
    private String colaRefuerzoBugattiText = "";

    private String cola1LamborghiniText = "";
    private String cola2LamborghiniText = "";
    private String cola3LamborghiniText = "";
    private String colaRefuerzoLamborghiniText = "";

    public Administrador(Procesador ai) {
        this.availableId = 0;
        this.ai = ai;

        this.cola1Bugatti = new LinkedList();
        this.cola2Bugatti = new LinkedList();
        this.cola3Bugatti = new LinkedList();
        this.colaRefuerzoBugatti = new LinkedList();

        this.cola1Lamborghini = new LinkedList();
        this.cola2Lamborghini = new LinkedList();
        this.cola3Lamborghini = new LinkedList();
        this.colaRefuerzoLamborghini = new LinkedList();

        this.bugattiWinners = new LinkedList();
        this.lamborghiniWinners = new LinkedList();

        this.BCarsCount = 0;
        this.LCarsCount = 0;
        this.VCount = 0;
    }

    public void createBugattiCar() {
        availableId++;
        Car car = new Car(availableId);
        car.company = "Bugatti";
        int quality = car.getOverallQuality();
        if (quality >= 180) {
            cola1Bugatti.add(car);
            cola1BugattiText = cola1BugattiText + " B" + car.getId() + " ";
        } else if (quality > 120 && quality < 180) {
            cola2Bugatti.add(car);
            cola2BugattiText = cola2BugattiText + " B" + car.getId() + " ";
        } else {
            cola3Bugatti.add(car);
            cola3BugattiText = cola3BugattiText + " B" + car.getId() + " ";
        }
        BCarsCount++;
    }

    public void createLamborghiniCar() {
        availableId++;
        Car car = new Car(availableId);
        car.company = "Lamborghini";
        int quality = car.getOverallQuality();
        if (quality >= 180) {
            cola1Lamborghini.add(car);
            cola1LamborghiniText = cola1LamborghiniText + " L" + car.getId() + " ";
        } else if (quality > 120 && quality < 180) {
            cola2Lamborghini.add(car);
            cola2LamborghiniText = cola2LamborghiniText + " L" + car.getId() + " ";
        } else {
            cola3Lamborghini.add(car);
            cola3LamborghiniText = cola3LamborghiniText + " L" + car.getId() + " ";
        }
        LCarsCount++;

    }

    public void raiseVehicleCount() {

        for (int i = 0; i < cola1Bugatti.size(); i++) {
            Car car = cola1Bugatti.poll();
            car.raiseWaitCount();
            if (car.getWaitCount() == 8) {
                car.resetWaitCount();
            } else {
                cola1Bugatti.add(car);
            }
        }

        for (int i = 0; i < cola2Bugatti.size(); i++) {
            Car car = cola2Bugatti.poll();
            car.raiseWaitCount();
            if (car.getWaitCount() == 8) {
                car.resetWaitCount();
                cola1Bugatti.add(car);
                cola2BugattiText = cola2BugattiText.substring(Integer.toString(car.getId()).length() + 3);

                cola1BugattiText = cola1BugattiText + " B" + car.getId() + " ";
            } else {
                cola2Bugatti.add(car);
            }
        }

        for (int i = 0; i < cola3Bugatti.size(); i++) {
            Car car = cola3Bugatti.poll();
            car.raiseWaitCount();
            if (car.getWaitCount() == 8) {
                car.resetWaitCount();
                cola2Bugatti.add(car);
                cola3BugattiText = cola3BugattiText.substring(Integer.toString(car.getId()).length() + 3);

                cola2BugattiText = cola2BugattiText + " B" + car.getId() + " ";
            } else {
                cola3Bugatti.add(car);
            }
        }

        for (int i = 0; i < cola1Lamborghini.size(); i++) {
            Car car = cola1Lamborghini.poll();
            car.raiseWaitCount();
            if (car.getWaitCount() == 8) {
                car.resetWaitCount();
            } else {
                cola1Lamborghini.add(car);
            }
        }

        for (int i = 0; i < cola2Lamborghini.size(); i++) {
            Car car = cola2Lamborghini.poll();
            car.raiseWaitCount();
            if (car.getWaitCount() == 8) {
                car.resetWaitCount();
                cola1Lamborghini.add(car);
                cola2LamborghiniText = cola2LamborghiniText.substring(Integer.toString(car.getId()).length() + 3);

                cola1LamborghiniText = cola1LamborghiniText + " L" + car.getId() + " ";
            } else {
                cola2Lamborghini.add(car);
            }
        }

        for (int i = 0; i < cola3Lamborghini.size(); i++) {
            Car car = cola3Lamborghini.poll();
            car.raiseWaitCount();
            if (car.getWaitCount() == 8) {
                car.resetWaitCount();
                cola2Lamborghini.add(car);
                cola3LamborghiniText = cola3LamborghiniText.substring(Integer.toString(car.getId()).length() + 3);

                cola2LamborghiniText = cola2LamborghiniText + " L" + car.getId() + " ";
            } else {
                cola3Lamborghini.add(car);
            }
        }
    }

    public void reforzarCarros() {
        double random = Math.random() * 100;
        if (random <= 40) {

            if (!colaRefuerzoBugatti.isEmpty()) {
                Car car = colaRefuerzoBugatti.poll();
                if (!Objects.isNull(car)) {
                    colaRefuerzoBugattiText = colaRefuerzoBugattiText
                            .substring(Integer.toString(car.getId()).length() + 3);
                }
                car.state = "waiting";
                cola1Bugatti.add(car);
                cola1BugattiText = cola1BugattiText + " B" + car.getId() + " ";
            }

            if (!colaRefuerzoLamborghini.isEmpty()) {
                Car car = colaRefuerzoLamborghini.poll();
                if (!Objects.isNull(car)) {
                    colaRefuerzoLamborghiniText = colaRefuerzoLamborghiniText
                            .substring(Integer.toString(car.getId()).length() + 3);
                }
                car.state = "waiting";
                cola1Lamborghini.add(car);
                cola1LamborghiniText = cola1LamborghiniText + " L" + car.getId() + " ";
            }

        }

    }

    public void escogerCarros() {
        if (!cola1Bugatti.isEmpty()) {
            currentBugattiCar = cola1Bugatti.remove();
            cola1BugattiText = cola1BugattiText.substring(Integer.toString(currentBugattiCar.getId()).length() + 3);
        } else if (cola1Bugatti.isEmpty() && !cola2Bugatti.isEmpty()) {
            currentBugattiCar = cola2Bugatti.remove();
            cola2BugattiText = cola2BugattiText.substring(Integer.toString(currentBugattiCar.getId()).length() + 3);

        } else if (cola1Bugatti.isEmpty() && cola2Bugatti.isEmpty() && !cola3Bugatti.isEmpty()) {
            currentBugattiCar = cola3Bugatti.remove();
            cola3BugattiText = cola3BugattiText.substring(Integer.toString(currentBugattiCar.getId()).length() + 3);

        } else {
            System.out.println("No hay más vehículos de Bugatti");
            currentBugattiCar = null;
        }

        if (!cola1Lamborghini.isEmpty()) {
            currentLamborghiniCar = cola1Lamborghini.remove();

            cola1LamborghiniText = cola1LamborghiniText
                    .substring(Integer.toString(currentLamborghiniCar.getId()).length() + 3);

        } else if (cola1Lamborghini.isEmpty() && !cola2Lamborghini.isEmpty()) {
            currentLamborghiniCar = cola2Lamborghini.remove();
            cola2LamborghiniText = cola2LamborghiniText
                    .substring(Integer.toString(currentLamborghiniCar.getId()).length() + 3);

        } else if (cola1Lamborghini.isEmpty() && cola2Lamborghini.isEmpty() && !cola3Lamborghini.isEmpty()) {
            currentLamborghiniCar = cola3Lamborghini.remove();
            cola3LamborghiniText = cola3LamborghiniText
                    .substring(Integer.toString(currentLamborghiniCar.getId()).length() + 3);

        } else {
            System.out.println("No hay más vehículos de Lamborghini");
            currentLamborghiniCar = null;
        }
    }

    public void crearCarros() {
        VCount++;
        if (VCount == 2) {
            VCount = 0;
            createBugattiCar();
            createLamborghiniCar();

            System.out.println("Se insertaron 2 carros");
        }
    }

    @Override
    public void run() {
        /*
         * Crear 10 carros antes de empezar
         */
        int BCount = 0;
        int LCount = 0;

        while (BCount < 10) {
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            createBugattiCar();
            BCount++;
        }

        while (LCount < 10) {
            try {
                sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            createLamborghiniCar();
            LCount++;
        }

        while (true) {
            while (Global.play) {
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                }

                escogerCarros();

                System.out.println("Administrador");

                crearCarros();

                reforzarCarros();

                if (currentBugattiCar != null && currentLamborghiniCar != null) {

                    result = this.ai.race(currentBugattiCar, currentLamborghiniCar);
                    this.ai.state = "Mostrando resultados";
                    try {
                        sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    raiseVehicleCount();

                    if (result.state.equals("winner")) {

                        if (result.company.equals("Bugatti")) {
                            bugattiWinners.add(result);
                        } else {
                            lamborghiniWinners.add(result);
                        }

                    } else if (result.state.equals("tie")) {
                        currentBugattiCar.state = "waiting";
                        currentLamborghiniCar.state = "waiting";
                        cola1Bugatti.add(currentBugattiCar);
                        cola1BugattiText = cola1BugattiText + " B" + currentBugattiCar.getId() + " ";
                        cola1Lamborghini.add(currentLamborghiniCar);
                        cola1LamborghiniText = cola1LamborghiniText + " L" + currentLamborghiniCar.getId() + " ";

                    } else if (result.state.equals("repair")) {

                        colaRefuerzoBugatti.add(currentBugattiCar);
                        colaRefuerzoBugattiText = colaRefuerzoBugattiText + " B" + currentBugattiCar.getId() + " ";
                        colaRefuerzoLamborghini.add(currentLamborghiniCar);
                        colaRefuerzoLamborghiniText = colaRefuerzoLamborghiniText + " L" + currentLamborghiniCar.getId()
                                + " ";

                    } else {
                        System.out.println("Se ha producido un error en la carrera");
                    }
                    this.ai.state = "Esperando";

                } else {
                    System.out.println("No hay suficientes carros para testear");
                }
            }
        }
    }

    public Car getCurrentBugattiCar() {
        return currentBugattiCar;
    }

    public Car getCurrentLamborghiniCar() {
        return currentLamborghiniCar;
    }

    public String getCola1BugattiText() {
        return cola1BugattiText;
    }

    public String getCola2BugattiText() {
        return cola2BugattiText;
    }

    public String getCola3BugattiText() {
        return cola3BugattiText;
    }

    public String getColaRefuerzoBugattiText() {
        return colaRefuerzoBugattiText;
    }

    public String getCola1LamborghiniText() {
        return cola1LamborghiniText;
    }

    public String getCola2LamborghiniText() {
        return cola2LamborghiniText;
    }

    public String getCola3LamborghiniText() {
        return cola3LamborghiniText;
    }

    public String getColaRefuerzoLamborghiniText() {
        return colaRefuerzoLamborghiniText;
    }

}
