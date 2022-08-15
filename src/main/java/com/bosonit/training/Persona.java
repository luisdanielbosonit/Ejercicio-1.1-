package com.bosonit.training;


import java.util.Optional;
import java.util.stream.Stream;

public class Persona {
    private String nombre, ciudad;
    private Optional<Integer> edad;
    private Integer edadInt;

    public static Stream<Object> stream() {
        return null;
    }

      public Persona() {
        }

    public Persona(String nombre, String ciudad, Optional<Integer> edad, Integer edadInt) {
        this.nombre = nombre;
        this.ciudad = ciudad;

        this.edadInt = edadInt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getEdadInt() {
        return edadInt;
    }

    public void setEdadInt(Integer edadInt) {
        this.edadInt = edadInt;
    }

    @Override
    public String toString() {
        return
                "Nombre: " + nombre + '\'' + "Ciudad: '" + ciudad + '\'' + "Edad: " + edadInt;
    }


}
