package com.bosonit.training;

import com.bosonit.training.exception.BosonitException;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws BosonitException, IOException {

        EjercicioDificil listaSalida=new EjercicioDificil();

        listaSalida.leer();
        listaSalida.readytofilter();



    }

}


        //Interface miInterface ;

       //miInterface= new Metodos();

/*
        try {
            //miInterface.PrintList(miInterface.OpenFile());
            miInterface.readFile();
        } /*catch (FileNotFoundException e) {
            e.printStackTrace();*/
 /*       catch (IOException e) {
             System.out.println("error");
        }
    }
}*/
