package lista.deTarefas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
   private List<Tarefa> tarefas;

   public ListaTarefas(){
       this.tarefas= new ArrayList<>();
   }

   public void adicionarTarefa(String descricao){
       tarefas.add(new Tarefa(descricao));
   }

   public void removerTarefa(String descricao){
       List <Tarefa> removerTarefas= new ArrayList<>();
       for(Tarefa tarefa :tarefas){
           if (tarefa.getDescricao().equalsIgnoreCase(descricao)){
                removerTarefas.add(tarefa);
           }
       }
       tarefas.removeAll(removerTarefas);
   }

   public  int obterNumeroTotalTarefas(){
       return  tarefas.size();
   }

   public void obterDescricoesTarefas() {
       System.out.println(tarefas);
   }




}
