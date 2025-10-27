package com.mycompany.gerenciadortarefas;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorTarefas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gerencia gerencia = new Gerencia();
        boolean executando = true;

        while (executando) {

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("======================================================");
            System.out.println("               GERENCIADOR DE TAREFAS");
            System.out.println("======================================================");
            System.out.println("| 1 - Adicionar tarefa                               |");
            System.out.println("| 2 - Listar tarefas                                 |");
            System.out.println("| 3 - Concluir tarefa                                |");
            System.out.println("| 4 - Deletar tarefa                                 |");
            System.out.println("| 5 - Sair                                           |");
            System.out.println("------------------------------------------------------");
            System.out.print("Escolha uma opção: ");

            if (!sc.hasNextInt()) {
                System.out.println("Por favor, digite um número válido!");
                sc.nextLine();
                continue;
            }

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {
                    ArrayList<String> novaTarefa = new ArrayList<>();

                    System.out.println("Descreva a tarefa:");
                    String descricao = sc.nextLine();
                    novaTarefa.add(descricao);

                    System.out.println("------------------------------------------------------");
                    System.out.println("Escolha a prioridade:");
                    System.out.println("1 - Alta");
                    System.out.println("2 - Média");
                    System.out.println("3 - Baixa");
                    System.out.println("------------------------------------------------------");
                    System.out.print("Opção: ");

                    int prioridade = sc.nextInt();
                    sc.nextLine();

                    switch (prioridade) {
                        case 1 -> novaTarefa.add("Alta");
                        case 2 -> novaTarefa.add("Média");
                        default -> novaTarefa.add("Baixa");
                    }

                    gerencia.adicionarTarefa(novaTarefa);

                    System.out.println("\n✅ Tarefa adicionada com sucesso!");
                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                }

                case 2 -> {
                    System.out.println("======================================================");
                    System.out.println("                LISTA DE TAREFAS");
                    System.out.println("======================================================");

                    ArrayList<ArrayList<String>> tarefas = gerencia.getTr();

                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa adicionada ainda!");
                    } else {
                        for (ArrayList<String> t : tarefas) {
                            System.out.println("ID: " + t.get(0) + " | " +
                                               "Descrição: " + t.get(1) + " | " +
                                               "Prioridade: " + t.get(2));
                        }
                    }

                    System.out.println("\nPressione ENTER para continuar...");
                    sc.nextLine();
                }

                case 3 -> {
                    System.out.print("Digite o ID da tarefa para marcar como concluída: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (gerencia.concluirTarefa(id)) {
                        System.out.println("✅ Tarefa concluída com sucesso!");
                    } else {
                        System.out.println("❌ ID não encontrado!");
                    }

                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                }

                case 4 -> {
                    System.out.print("Digite o ID da tarefa para deletar: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (gerencia.deletarTarefa(id)) {
                        System.out.println("🗑️  Tarefa removida com sucesso!");
                    } else {
                        System.out.println("❌ ID não encontrado!");
                    }

                    System.out.println("Pressione ENTER para continuar...");
                    sc.nextLine();
                }

                case 5 -> {
                    System.out.println("Programa encerrado. Até mais!");
                    executando = false;
                }

                default -> {
                    System.out.println("Opção inválida! Tente novamente.");
                    sc.nextLine();
                }
            }
        }

        sc.close();
    }
}