/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.Objects;

/**
 *
 * @author Juan Diego
 */
public class Cola {
    private Car head;

    public Cola() {

    }

    public Car remove() {
        Car aux;
        if (!this.isEmpty()) {
            aux = this.head;
            this.head = this.head.getNextCar();
            return aux;
        }
        return null;
    }

    public void add(Car head, Car car) {
        if (Objects.isNull(head.getNextCar())) {
            head.setNextCar(car);
        } else {
            add(head.getNextCar(), car);
        }
    }

    public void add(Car car) {
        if (Objects.isNull(this.head.getNextCar())) {
            head.setNextCar(car);
        } else {
            add(head.getNextCar(), car);
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(this.head);
    }

    public Car getHead() {
        return head;
    }

    public void setHead(Car head) {
        this.head = head;
    }

}
