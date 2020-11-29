package model;
/*@Ramon*/

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Usuario {
    //Atributos
    private String birthday;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<CitaDoctores> appointmentDoctors = new ArrayList<>();
    private ArrayList<CitaEnfermera> appointmentNurses = new ArrayList<>();

    public ArrayList<CitaDoctores> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        CitaDoctores appointmentDoctor = new CitaDoctores(this, doctor);
        appointmentDoctor.schedule(date,time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<CitaEnfermera> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<CitaEnfermera> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    public Patient(String nombre, String correo){
        super(nombre,correo);

    }


    public void setWeight(double weight) {
        this.weight = weight;
    }


    public String getWeight(){
        return this.weight + " kilogramos.";
    }


    public String getHeight() {
        return height + " metros.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEdad: " + birthday + "\n Peso: " +getWeight()+ "\n Altura:"+getHeight()+"\nSangre:"+blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completo");

    }

}
