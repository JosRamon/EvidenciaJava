package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;
/*@Ramon*/

public class MenuDoctores {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void mostrarMenuDoctores(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctores");
            System.out.println("¡Bienvenido! " + Menu.doctorLogged.getnombre());
            System.out.println("1. Añadir cita disponible");
            System.out.println("2. Mis citas");
            System.out.println("0. Cerrar sesion");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    mostrarMenuCitasdisponibles();
                    break;
                case 2:
                    break;
                case 0:
                    Menu.mostrarMenu();
                    break;


            }

        }while (response != 0);
    }


    private static void mostrarMenuCitasdisponibles(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("<<Añadir cita disponible>>");
            System.out.println("<<Seleccionar mes>>");

            for (int i = 0; i < 3; i++) {
                int j =  i + 1;
                System.out.println(j + ". " + Menu.MONTHS[i]);
            }
            System.out.println("0. Regresar");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected + " . " + Menu.MONTHS[monthSelected-1]);

                System.out.println("Insertar fecha disponible: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Tu fecha es: " + date + "\n1. Correcto \n2. Cambiar Fecha");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Inserte la hora disponible para la fecha" + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("El horario es: " + time + "\n1. Correcto \n2. Cambiar horario");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);

                Menu.doctorLogged.addAvailableAppointment(date,time);
                consultarCitasDisponiblesDoctores(Menu.doctorLogged);


            }else if(response == 0){
                mostrarMenuDoctores();
            }

        }while (response != 0);
    }


    private static void consultarCitasDisponiblesDoctores(Doctor doctor)
    {
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor))
        {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
