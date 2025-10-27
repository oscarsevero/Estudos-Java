/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadordetarefadois;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author x1
 */
public class GerenciadordeTarefaDois {
 public static void main(String[] args) {
        
     boolean control = true;
     Scanner scr = new Scanner(System.in);   
     ArrayList Supreme= new ArrayList<>();    
     int id =0;
     
     while(control) { 
         
         System.out.println("-------------------");
         System.out.println("Painel de Entrada");
         System.out.println("Escolha uma das opçoes:");
         System.out.println("1 - Adicionar");
         System.out.println("2 - Listar");
         System.out.println("3 - Marcar como Concluida");
         System.out.println("4 - Deletar");
         System.out.println("5 - Sair");
         System.out.println("-------------------");
       
        
        int entradaUsuario = scr.nextInt();
        scr.nextLine();
        ArrayList listaMa= new ArrayList<>();
        
        
         switch (entradaUsuario) { 
             
             case 1-> { 
                ArrayList listaMe= new ArrayList<>(); 
                System.out.println("-------------------");
                
                 
                 String valTarefa; 
                 String valUrgencia;
                 
                 System.out.println("Digite a Tarefa:");
                 valTarefa = scr.next();
                 scr.nextLine(); 
                 
                 System.out.println("-------------------");
                 System.out.println("Digite a Urgencia");
                 System.out.println("-------------------");
                 System.out.println("1 - Baixa");
                 System.out.println("2 - Moderada");
                 System.out.println("3 - Alta");
                 System.out.println("-------------------");
                 
                 int ControlUr = scr.nextInt();
                 
                 switch (ControlUr) {
                 case 1:
                     valUrgencia = "Baixa";
                     break;
                 case 2:
                     valUrgencia = "Moderada";
                     break;
                 case 3:
                     valUrgencia = "Alta";
                     break;
                 default:
                     valUrgencia = "Erro";
                     System.out.println("Digite um Valor Valido:");
                     break;
             }
                               
                 System.out.println(" Numero da Tarefa " + id + " A tarefa se refere a: " + valTarefa + " e a urgencia " + valUrgencia );
                 listaMe.add(id++);
                 listaMe.add(valTarefa);
                 listaMe.add(valUrgencia);                 
                 System.out.println("-------------------");                         
                 Supreme.add(listaMe);
        
             }
           
            case 2 -> {  
                 System.out.println("--------------------");
                 System.out.println("Atualmente a lista Possui: " + Supreme.size() + " Itens");
                 System.out.println("--------------------");
                 
              for (int i = 0; i < Supreme.size(); i++) {
                      System.out.println(Supreme.get(i));
    }
         
     }   
            
                
                
                case 3 -> {
                 System.out.println("--------------------");
                 System.out.println("Selecione qual Deseja Marcar como Concluida");
                 System.out.println("--------------------");
    
                for (int i = 0; i < Supreme.size(); i++) {
                 System.out.println(Supreme.get(i));
                 }
    
                 int conclui = scr.nextInt();
                      scr.nextLine();
        
                 ArrayList item = (ArrayList) Supreme.get(conclui);
                  if (item.size() == 3) {
                  item.add("Concluida");
                 } else {
                    item.set(3, "Concluida");
                     }
    
    System.out.println("Tarefa Numero: " + conclui + " marcada como Concluida!");
}
    
            
            
            case 4 -> { 
                System.out.println("--------------------");
                System.out.println("Selecione qual Deseja Remover");
                System.out.println("--------------------");
                
                for (int i = 0; i < Supreme.size(); i++) {
                      System.out.println(Supreme.get(i));
                }
                
                int retira; 
                retira = scr.nextInt();       
                Supreme.remove(retira);                                
                System.out.println("Tarefa Numero: " + retira +  " Removido com Sucesso!");                        
                
                System.out.println(Supreme);
                
                for (int x = 0; x < Supreme.size(); x++) {
                     ArrayList item = (ArrayList) Supreme.get(x); 
                     item.set(0, x); }
                
           
}
            case 5 -> {
                     System.out.println("Programa Encerrado");
                     control = false;
                     
            }
}

                
            
            }   
     
        } 
    } 
