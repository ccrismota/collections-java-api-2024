package main.java.list.operacoesBasicas;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    //atributo
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void  removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for(Tarefa t : tarefaList) {
            if (t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotaldeTarefas(){
        return tarefaList.size();
    }

    public void obterDescricoesDasTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        System.out.println("Numero toatal de tarefas na lista é : " + listaTarefa.obterNumeroTotaldeTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("Numero toatal de tarefas na lista é : " + listaTarefa.obterNumeroTotaldeTarefas());

        listaTarefa.removerTarefa("Tarefa 2");
        System.out.println("Numero toatal de tarefas na lista é : " + listaTarefa.obterNumeroTotaldeTarefas());

        listaTarefa.obterDescricoesDasTarefas();
    }

}
