package ui;

import model.Doctor;
import model.Patient;
/*@Ramon*/

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patinetLogged;

    public static void mostrarMenu(){
        System.out.println("Mis citas");
        System.out.println("Selecciona una opcion");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Paciente");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema");
                    break;
                default:
                    System.out.println("Selecciona una opcion correcta");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Jose Ramon", "ramon@hotmail.com"));
        doctors.add(new Doctor("Sharon Denisse", "sharon@hotmail.com"));
        doctors.add(new Doctor("Pancho Villa", "pancho@hotmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Vanessa Lisbet", "vanessa@hotmail.com"));
        patients.add(new Patient("Karina Belen", "karina@hotmail.com"));
        patients.add(new Patient("Joaquina Lara", "joaquina@hotmail.com"));


        boolean emailCorrect = false;
        do {
            System.out.println("Ingresa tu correo: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor d: doctors){
                    if (d.getcorreo().equals(email)){
                        emailCorrect = true;

                        doctorLogged = d;
                        MenuDoctores.mostrarMenuDoctores();
                    }
                }
            }

            if (userType == 2){
                for (Patient p: patients){
                    if (p.getcorreo().equals(email)){
                        emailCorrect = true;
                        patinetLogged = p;
                        //showPatientMenu
                    }
                }
            }


        }while (!emailCorrect);

    }

    static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Paciente");
            System.out.println("1. Reservar una cita");
            System.out.println("2. Mis citas");
            System.out.println("0. Regresar");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("<<Reservar una cita>>");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("<<Mis Citas");
                    break;
                case 0:
                    mostrarMenu();
                    break;
            }
        }while (response != 0);
    }
}
