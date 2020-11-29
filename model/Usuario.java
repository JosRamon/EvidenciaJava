package model;
/*@Ramon*/

public abstract class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String Direccion;
    private String Celular;

    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getcorreo() {
        return correo;
    }

    public void setcorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String address) {
        this.Direccion = address;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        if (Celular.length() > 8){
            System.out.println("Telefono maximo de 8 digitos por favor");
        }else if(Celular.length() == 8){
            this.Celular = Celular;
        }
    }

    @Override
    public String toString() {
        return "model.Usuario: " + nombre + ", correo: "+correo+
                "\nDireccion: "+Direccion+". Telefono: "+Celular;
    }

    public abstract void showDataUser();

}
