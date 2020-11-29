package ui;

import model.Doctor;
/*@Ramon*/

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MenuPacientes {

    public static void mostrarMenuPaciente(){
        int response = 0;
        do {

            System.out.println("\n\n");
            System.out.println("<<Paciente>>");
            System.out.println("¡Bienvenido!: " + Menu.patinetLogged);
            System.out.println("1. Reservar cita");
            System.out.println("2. Mis citas");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    mostrarMenuReservaciones();
                    break;
                case 2:
                    break;
                case 0:
                    Menu.mostrarMenu();
                    break;
            }


        }while (response!=0);
    }

    private static void mostrarMenuReservaciones(){
        int response = 0;
        do {
            System.out.println("<<Reservar una cita>>");
            System.out.println("<<Seleccionar fecha>>");

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < MenuDoctores.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = MenuDoctores.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor>  doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), MenuDoctores.doctorsAvailableAppointments.get(i));

                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getnombre() +
                    ". Fecha: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Horario: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirmar cita: \n1. si \n2. cambiar fecha");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                Menu.patinetLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());

                mostrarMenuPaciente();
            }


        }while (response!= 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("<<Mis citas>>");
            if (Menu.patinetLogged.getAppointmentDoctors().size() == 0){
                System.out.println("No tengo citas");
                break;
            }

            for (int i = 0; i < Menu.patinetLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Fecha: " + Menu.patinetLogged.getAppointmentDoctors().get(i).getDate() +
                        " Hora: " + Menu.patinetLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + Menu.patinetLogged.getAppointmentDoctors().get(i).getDoctor().getnombre()
                        );
            }

            System.out.println("0. Regresar");
        }while (response!=0);
    }
}
