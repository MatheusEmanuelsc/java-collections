package set.listaTarefas;

import util.VerificarLista;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa>listaTarefa;

    public ListaTarefas() {
        this.listaTarefa = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        listaTarefa.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        VerificarLista.verifica(listaTarefa);

        for (Tarefa tarefa: listaTarefa){
            if (tarefa.getDesc().equalsIgnoreCase(descricao)){
                listaTarefa.remove(tarefa);
                break;
            }
        }
    }

    public void exibirTarefas(){
        VerificarLista.verifica(listaTarefa);
        System.out.println(listaTarefa);
    }

    public int contarTarefas(){

        return listaTarefa.size();
    }

    public Set<Tarefa>obterTarefasConcluidas(){
        VerificarLista.verifica(listaTarefa);
        Set<Tarefa>listaTarefasConcluidas=new HashSet<>();

        for (Tarefa tarefa: listaTarefa){
            if (tarefa.isStatus()){
                listaTarefasConcluidas.add(tarefa);
            }
        }
        return listaTarefasConcluidas;
    }

    public Set<Tarefa>obterTarefasPendentes(){
        VerificarLista.verifica(listaTarefa);
        Set<Tarefa>listaTarefasPendentes=new HashSet<>();

        for (Tarefa tarefa: listaTarefa){
            if (!tarefa.isStatus()){
                listaTarefasPendentes.add(tarefa);
            }
        }
        return listaTarefasPendentes;
    }
    public void marcarTarefaConcluida(String descricao){
        VerificarLista.verifica(listaTarefa);

        for (Tarefa tarefa: listaTarefa){
            if (tarefa.getDesc().equalsIgnoreCase(descricao)){
                tarefa.setStatus(true);
                break;
            }
        }
    }
    public void marcarTarefaPendente(String descricao){
        VerificarLista.verifica(listaTarefa);

        for (Tarefa tarefa: listaTarefa){
            if (tarefa.getDesc().equalsIgnoreCase(descricao)){
                tarefa.setStatus(false);
                break;
            }
        }
    }

    public void limparListaTarefas(){
        VerificarLista.verifica(listaTarefa);

        listaTarefa.removeAll(listaTarefa);
    }

    public static void main(String[] args) {
        try {
            // Criando uma instância da classe ListaTarefas
            ListaTarefas listaTarefas = new ListaTarefas();

            // Adicionando tarefas à lista
            listaTarefas.adicionarTarefa("Estudar Java");
            listaTarefas.adicionarTarefa("Fazer exercícios físicos");
            listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
            listaTarefas.adicionarTarefa("Ler livro");
            listaTarefas.adicionarTarefa("Preparar apresentação");

            // Exibindo as tarefas na lista
            listaTarefas.exibirTarefas();

            // Removendo uma tarefa
            listaTarefas.removerTarefa("Fazer exercícios físicos");
            listaTarefas.exibirTarefas();

            // Contando o número de tarefas na lista
            System.out.println("Total de tarefas na lista: " + listaTarefas.contarTarefas());

            // Obtendo tarefas pendentes
            System.out.println(listaTarefas.obterTarefasPendentes());

            // Marcando tarefas como concluídas
            listaTarefas.marcarTarefaConcluida("Ler livro");
            listaTarefas.marcarTarefaConcluida("Estudar Java");

            // Obtendo tarefas concluídas
            System.out.println(listaTarefas.obterTarefasConcluidas());

            // Marcando tarefas como pendentes
            listaTarefas.marcarTarefaPendente("Estudar Java");
            listaTarefas.exibirTarefas();

            // Limpando a lista de tarefas
            listaTarefas.limparListaTarefas();
            listaTarefas.exibirTarefas();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

}
