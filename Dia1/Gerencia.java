package com.mycompany.gerenciadortarefas;

import java.util.ArrayList;

public class Gerencia {

    private int id = 1; // contador automático
    private ArrayList<ArrayList<String>> tr = new ArrayList<>();

    // adiciona uma tarefa com ID automático
    public void adicionarTarefa(ArrayList<String> tarefa) {
        ArrayList<String> nova = new ArrayList<>();
        nova.add(String.valueOf(id++));        // ID automático
        nova.add(tarefa.get(0));               // Descrição
        nova.add(tarefa.get(1));               // Prioridade
        nova.add("Pendente");                  // Status padrão
        tr.add(nova);
    }

    public ArrayList<ArrayList<String>> getTr() {
        return tr;
    }

    public void setTr(ArrayList<ArrayList<String>> tr) {
        this.tr = tr;
    }

    // marcar tarefa como concluída
    public boolean concluirTarefa(int idTarefa) {
        for (ArrayList<String> t : tr) {
            if (Integer.parseInt(t.get(0)) == idTarefa) {
                t.set(3, "Concluída");
                return true;
            }
        }
        return false;
    }

    // deletar tarefa
    public boolean deletarTarefa(int idTarefa) {
        return tr.removeIf(t -> Integer.parseInt(t.get(0)) == idTarefa);
    }
}
