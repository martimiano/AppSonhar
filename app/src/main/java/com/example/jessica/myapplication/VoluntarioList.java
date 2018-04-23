package com.example.jessica.myapplication;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jessica on 22/04/2018.
 */

public class VoluntarioList {


    List<Voluntario> voluntarios = new LinkedList<Voluntario>();
    Connection connection = new Connection();

    public void getVoluntarios(){
        try {
            voluntarios = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> returnAllProgramas(){
        List<String> programas = new LinkedList<String>();
        for(Voluntario voluntario:voluntarios){
            if(!programas.contains(voluntario.getPrograma())){
                programas.add(voluntario.getPrograma());
            }

        }
        return programas;
    }

    public List<String> returnVoluntariosByPrograma(String programa){
        List<String> found = new LinkedList<String>();
        for(Voluntario voluntario: voluntarios){
            if(voluntario.getPrograma().equals(programa)) found.add(voluntario.getLocal());
        }
        return found;
    }

    public String returnNome(String programa, String local){
        for(Voluntario voluntario: voluntarios){
            if(voluntario.getPrograma().equals(programa) && voluntario.getLocal().equals(local)) return voluntario.getNome();
        }
        return "Sorry...";
    }

}
