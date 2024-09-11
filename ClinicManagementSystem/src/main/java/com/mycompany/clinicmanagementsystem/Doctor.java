/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicmanagementsystem;

/**
 *
 * @author MIFFY
 */



import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MIFFY
 */
abstract class Doctor {
 
   private final String id;
    private final String name;
    private final Map<String, String> schedule; 

    public Doctor(String id, String name) {
        this.id = id;
        this.name = name;
        this.schedule = new HashMap<>();
        initializeDefaultSchedule();
    }

    private void initializeDefaultSchedule() {
        schedule.put("Sunday", "9 AM - 12 PM");
        schedule.put("Monday", "10 AM - 4 PM");
        schedule.put("Tuesday", "9 AM - 3 PM");
        schedule.put("Wednesday", "10 AM - 5 PM");
        schedule.put("Thursday", "9 AM - 2 PM");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getSpecialization();

    public abstract void displayAvailability();

    public void displaySchedule() {
        System.out.println("Weekly Schedule for " + getName() + ":");
        for (Map.Entry<String, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(String id, String name) {
        super(id, name);
    }

    @Override
    public String getSpecialization() {
        return "General Practitioner";
    }

    @Override
    public void displayAvailability() {
        System.out.println(getName() + " (GP): Available for walk-ins. Weekly schedule:");
        displaySchedule();
    }
}

class Specialist extends Doctor {
    private String specialization;

    public Specialist(String id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void displayAvailability() {
        System.out.println(getName() + " (" + specialization + "): Available by appointment only. Weekly schedule:");
        displaySchedule();
    }
}