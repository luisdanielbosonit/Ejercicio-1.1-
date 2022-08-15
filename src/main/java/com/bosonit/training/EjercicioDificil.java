package com.bosonit.training;

import com.bosonit.training.exception.BosonitException;
import com.bosonit.training.exception.FileNotAvailableException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EjercicioDificil {

    List<Persona> peopleList = new ArrayList<Persona>();

            public void leer ()  throws BosonitException, IOException {

                //List<Persona> peopleList = new ArrayList<Persona>();
                Path path =  Paths.get("C:\\Users\\luisdaniel.acosta\\IdeaProjects\\Hello-World1\\src\\main\\java\\Fichero");
                    try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
                        String line = bufferedReader.readLine();
                        while (line != null) {
                            String[] person = line.split(":");
                            Persona people = new Persona();
                            if(person.length>0){
                                people.setNombre(person[0]);
                            }
                            if(person.length>=2) {
                                people.setCiudad(person[1]);
                            }
                            try {
                                if (person[1].equals("")) {
                                    person[1] = null;
                                }

                                Optional<String> op= Optional.ofNullable(person[1]);
                                String variablecity =op.orElse("unknown city" );
                                people.setCiudad(variablecity);

                            }catch (Exception e){
                                Optional<String> op= Optional.empty();
                            }
                            people.setEdadInt(person.length > 2 ? Integer.parseInt(person[2]) : 0);

                            peopleList.add(people);
                            line = bufferedReader.readLine();

                        }
                        System.out.println("=============Lectura del fichero======================");
                       peopleList.forEach(p -> System.out.println("Nombre: " + p.getNombre() + " Ciudad: " + p.getCiudad() + "  Edad:  " + p.getEdadInt()));

                    } catch (IOException e) {
                        throw new FileNotAvailableException("Failed to read file.", e);
                    }

                }

           public void readytofilter(){
                System.out.println("===============mayor a 25==================");
                peopleList.stream().filter(edad-> edad.getEdadInt()<25).filter((c)->c.getEdadInt()!=0).forEach(System.out::println);

                System.out.println("*============people starting with the letter A===================*");
                peopleList.stream().filter((p)->!p.getNombre().startsWith("A")).forEach(System.out::println);

                System.out.println("*============================Madrid City==============  ============*");
                Optional<Persona> personMadrid = peopleList.stream().filter((p)-> p.getEdadInt() <25).filter((p)-> p.getEdadInt() >0).filter((p)->p.getCiudad().equals("Madrid")).findFirst();
               if (personMadrid.isPresent()) {
                    System.out.println(personMadrid.get());
                } else {
                    System.out.println("non-existent");
                }
                System.out.println("Filtrar por menor de 25 y ciudad Barcelona");
                System.out.println("*=========================================*");
                Optional<Persona> personOptionalBarcelona = peopleList.stream().filter((p)-> p.getEdadInt() <25).filter((p)-> p.getEdadInt() >0).filter((p)->p.getCiudad().equals("Barcelona")).findFirst();
                if (personOptionalBarcelona.isPresent()) {
                    System.out.println(personOptionalBarcelona.get());
                } else {
                    System.out.println("non-existent");
                }
            }
}