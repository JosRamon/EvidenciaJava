package model;
/*@Ramon*/

public class Enfermera extends Usuario {

    private String speciality;

    public Enfermera(String nombre, String correo) {
        super(nombre, correo);
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: IMSS");
        System.out.println("Especialidades: Cardiologia, Cirugia");
    }


    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
