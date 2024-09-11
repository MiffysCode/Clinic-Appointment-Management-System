/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clinicmanagementsystem;

/**
 *
 * @author MIFFY
 */
import java.io.*;
import java.util.*;
public class ClinicManagementSystem {
 private static final String DOCTORS_FILE = "doctors.txt";
    private static final String PATIENTS_FILE = "patients.txt";
    private static final String APPOINTMENTS_FILE = "appointments.txt";

    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        List<Appointment> appointments = new ArrayList<>();
        loadDoctors(doctors);
        loadPatients(patients);
        loadAppointments(appointments, doctors, patients);
        if (doctors.isEmpty()) {
            insertDefaultDoctors(doctors);
            saveDoctors(doctors);
        }
        if (patients.isEmpty()) {
            insertDefaultPatients(patients);
            savePatients(patients);
        }
        if (appointments.isEmpty()) {
            insertDefaultAppointments(appointments, doctors, patients);
            saveAppointments(appointments);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n***** Clinic Appointment Management System *****");
            System.out.println("1. View Doctors");
            System.out.println("2. View Doctor Schedule");
            System.out.println("3. Register Patient");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1 -> {
                    for (Doctor doctor : doctors) {
                        System.out.println("Doctor ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Specialization: " + doctor.getSpecialization());
                    }
                }
                case 2 -> {
                    for (Doctor doctor : doctors) {
                        System.out.println("Doctor ID: " + doctor.getId());
                        doctor.displayAvailability();
                    }
                }
                case 3 -> {
                    registerPatient(patients);
                    savePatients(patients);
                }
                case 4 -> {
                    bookAppointment(doctors, patients, appointments);
                    saveAppointments(appointments);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid your choice. Please try again.");
            }
        }
    }

    private static void registerPatient(List<Patient> patients) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        Patient newPatient = new Patient(id, name, age);
        patients.add(newPatient);
        System.out.println("Patient registered successfully.");
    }
    private static void bookAppointment(List<Doctor> doctors, List<Patient> patients, List<Appointment> appointments) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter Patient ID: ");
    String patientId = scanner.nextLine();
    Patient patient = findPatientById(patients, patientId);
    
    if (patient == null) {
        System.out.println("Patient not registered. Please register the patient before booking an appointment.");
        return; 
    }

    System.out.println("Available Doctors:");
    for (Doctor doctor : doctors) {
        System.out.println("Doctor ID: " + doctor.getId() + ", Name: " + doctor.getName());
    }
    
    System.out.print("Enter Doctor ID to book an appointment: ");
    String doctorId = scanner.nextLine();
    Doctor doctor = findDoctorById(doctors, doctorId);

    if (doctor == null) {
        System.out.println("Doctor not found.");
        return; 
    }

    System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
    String date = scanner.nextLine();
    System.out.print("Enter Appointment Time (HH:mm): ");
    String time = scanner.nextLine();

    
    for (Appointment appointment : appointments) {
        if (appointment.getDoctor().getId().equals(doctorId) &&
            appointment.getDate().equals(date) &&
            appointment.getTime().equals(time)) {
            System.out.println("This time slot is not available. Please choose a different time.");
            return;
        }
    }

    Appointment newAppointment = new Appointment(doctor, patient, date, time);
    appointments.add(newAppointment);
    System.out.println("Appointment booked successfully.");
}
    
    private static Patient findPatientById(List<Patient> patients, String patientId) {
        for (Patient patient : patients) {
            if (patient.getId().equals(patientId)) {
                return patient;
            }
        }
        return null;
    }
    private static Doctor findDoctorById(List<Doctor> doctors, String doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId().equals(doctorId)) {
                return doctor;
            }
        }
        return null;
    }
    private static void insertDefaultDoctors(List<Doctor> doctors) {
        doctors.add(new GeneralPractitioner("D1", "Dr. Joy"));
        doctors.add(new Specialist("D2", "Dr. Yeasir", "Cardiologist"));
        doctors.add(new Specialist("D3", "Dr. Jotiy", "Dermatologist"));
        doctors.add(new GeneralPractitioner("D4", "Dr. Sadia"));
        doctors.add(new Specialist("D5", "Dr. Rawnok", "Neurologist"));
    }
    private static void insertDefaultPatients(List<Patient> patients) {
        patients.add(new Patient("P1", "Asma", 30));
        patients.add(new Patient("P2", "Sara", 25));
        patients.add(new Patient("P3", "Akash", 40));
    }
    private static void insertDefaultAppointments(List<Appointment> appointments, List<Doctor> doctors, List<Patient> patients) {
        appointments.add(new Appointment(findDoctorById(doctors, "D1"), findPatientById(patients, "P1"), "2024-09-10", "09:00"));
        appointments.add(new Appointment(findDoctorById(doctors, "D2"), findPatientById(patients, "P2"), "2024-09-11", "10:00"));
        appointments.add(new Appointment(findDoctorById(doctors, "D3"), findPatientById(patients, "P3"), "2024-09-12", "11:00"));
    }
    private static void loadDoctors(List<Doctor> doctors) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DOCTORS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                String specialization = data[2];
                if ("General Practitioner".equals(specialization)) {
                    doctors.add(new GeneralPractitioner(id, name));
                } else {
                    doctors.add(new Specialist(id, name, specialization));
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading doctors: " + e.getMessage());
        }
    }
    private static void loadPatients(List<Patient> patients) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATIENTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);

                patients.add(new Patient(id, name, age));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading patients: " + e.getMessage());
        }
    }
    private static void loadAppointments(List<Appointment> appointments, List<Doctor> doctors, List<Patient> patients) {
    try (BufferedReader reader = new BufferedReader(new FileReader(APPOINTMENTS_FILE))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length < 4) {
                System.out.println("Skipping invalid appointment record: " + line);
                continue; 
            }
            String doctorId = data[0];
            String patientId = data[1];
            String date = data[2];
            String time = data[3];

            Doctor doctor = findDoctorById(doctors, doctorId);
            Patient patient = findPatientById(patients, patientId);

            if (doctor != null && patient != null) {
                appointments.add(new Appointment(doctor, patient, date, time));
            } else {
                System.out.println("Doctor or Patient not found for appointment record: " + line);
            }
        }
    } catch (IOException e) {
        System.out.println("An error occurred while loading appointments: " + e.getMessage());
    }
}
    private static void saveDoctors(List<Doctor> doctors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DOCTORS_FILE))) {
            for (Doctor doctor : doctors) {
                writer.write(doctor.getId() + "," + doctor.getName() + "," + doctor.getSpecialization());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving doctors: " + e.getMessage());
        }
    }

    private static void savePatients(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATIENTS_FILE))) {
            for (Patient patient : patients) {
                writer.write(patient.getId() + "," + patient.getName() + "," + patient.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving patients: " + e.getMessage());
        }
    }
    private static void saveAppointments(List<Appointment> appointments) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(APPOINTMENTS_FILE))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.getDoctor().getId() + "," + appointment.getPatient().getId() + "," + appointment.getDate() + "," + appointment.getTime());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while saving appointments: " + e.getMessage());
        }
    }
}