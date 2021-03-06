package com.ifmo.ddj.Exam;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public abstract class Membership {
    protected Client client;
    protected LocalDateTime startRegistration; //когда человек пришел на ресепнш и приложил абонемент
    protected LocalDateTime endRegistration; //когда абонемент перестает действовать
    protected int choose; //число от 0 до 2
    protected String whereClient;
    Fitness fitness;

    protected Membership(LocalDateTime endRegistration, Client client, Fitness fitness) {
        Objects.requireNonNull(client, "client не должен быть null");
        Objects.requireNonNull(fitness, "fitness не должен быть null");
        this.startRegistration = LocalDateTime.now();
        if (endRegistration.isBefore(startRegistration))
            throw new IllegalArgumentException("Дата окончания абонемента не может"
                    + " быть раньше чем дата начала регистрации");
        this.client = client;
        this.fitness = fitness;
        this.endRegistration = endRegistration;
    }

    protected Membership(Client client) {
        Objects.requireNonNull(client, "client не должен быть null");
        this.client = client;
    }

    public Fitness getFitness() {
        return fitness;
    }

    protected boolean checkAccess(LocalTime startWorkingHour, LocalTime endWorkingHour) {
        String rejection = "";
        LocalTime startTime = LocalTime.now();
        LocalDateTime startDateTime = LocalDateTime.now();

        if (startTime.isAfter(startWorkingHour) && startTime.isBefore(endWorkingHour)) {
            if (startDateTime.isAfter(this.startRegistration) && startDateTime.isBefore(this.endRegistration))
                return true;
            else rejection = client.getName() + " " + client.getSurname()
                    + ", срок действия Вашего абонемента истек или еще не начался";
        } else rejection = client.getName() + " " + client.getSurname()
                + ", Вы не можете посещать клуб в это время. Приходите с "
                + startWorkingHour.toString()
                + " до " + endWorkingHour.toString();
        System.out.println(client.getName() + " " + client.getSurname() + ", вход закрыт. Причина отказа: " + rejection);
        return false;
    }

    protected void random() {
        choose = (int) (Math.random() * 3);
    }
}
