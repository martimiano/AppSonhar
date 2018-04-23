package com.example.jessica.myapplication;

import java.util.LinkedList;
import java.util.List;

public class CriancaList {

    List<Crianca> criancas = new LinkedList<Crianca>();
    //Connection connection = new Connection();

    public void getCriancas(){
        try {
            //criancas = connection.sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> returnAllProgramas(){
        List<String> programas = new LinkedList<String>();
        for(Crianca crianca:criancas){
            if(!programas.contains(crianca.getPrograma())){
                programas.add(crianca.getPrograma());
            }

        }
        return programas;
    }

    public List<String> returnCriancasByPrograma(String programa){
        List<String> found = new LinkedList<String>();
        for(Crianca crianca: criancas){
            if(crianca.getPrograma().equals(programa)) found.add(crianca.getLocal());
        }
        return found;
    }

    public String returnNome(String programa, String local){
        for(Crianca crianca: criancas){
            if(crianca.getPrograma().equals(programa) && crianca.getLocal().equals(local)) return crianca.getNome();
        }
        return "Sorry...";
    }
}
