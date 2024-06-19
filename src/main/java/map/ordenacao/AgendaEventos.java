package main.java.map.ordenacao;

import main.java.map.operacoesBasicas.AgendaContatos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    //atributos
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }
    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventoTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry: eventosTreeMap.entrySet()){
            if(entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)){
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();
                System.out.println("O próximo Evento: " + proximoEvento
                        + " acontecerá na data " + proximaData);
                break;
            }
        }
    }



    public static void main(String[] args) {

        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate
                .of(2024, Month.JUNE, 15),"Evento 1", "Atacao 1");
        agendaEventos.adicionarEvento(LocalDate
                .of(2024, 7, 9),"Evento 2", "Atacao 2");
        agendaEventos.adicionarEvento(LocalDate
                .of(2022, Month.JANUARY, 10),"Evento 3", "Atacao 3");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();

    }

}
