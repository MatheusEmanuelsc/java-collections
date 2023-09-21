package map.agendaEventos;

import util.VerificaMap;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate,Evento> listaEventos;

    public AgendaEventos() {
        this.listaEventos= new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nomeEvento, String nomeAtracao){
        listaEventos.put(data,new Evento(nomeEvento,nomeAtracao));
    }

    public void exibirAgenda(){
        VerificaMap.verifica(listaEventos);

        Map<LocalDate,Evento>programacaoDeEventos=new TreeMap<>(listaEventos);

        System.out.println(programacaoDeEventos);
    }

    public void obterProximoEvento(){
        VerificaMap.verifica(listaEventos);
        LocalDate dataAtual= LocalDate.now();
        Map<LocalDate,Evento>programacaoDeEventos=new TreeMap<>(listaEventos);
        for (Map.Entry<LocalDate,Evento> entry : programacaoDeEventos.entrySet()){

            if (entry.getKey().isEqual(dataAtual)|| entry.getKey().isAfter(dataAtual)){
                System.out.println("O Proximo evento " + entry.getValue()+ " na Data "+entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            AgendaEventos agendaEventos = new AgendaEventos();

            // Adiciona eventos à agenda
            agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
            agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
            agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
            agendaEventos.adicionarEvento(LocalDate.of(2023, Month.AUGUST, 28), "Hackathon de Inovação", "Competição de soluções criativas");
            agendaEventos.adicionarEvento(LocalDate.of(2024, 9, 20), "Seminário de Inteligência Artificial", "Discussão sobre IA avançada");

            // Exibe a agenda completa de eventos
            agendaEventos.exibirAgenda();

            // Obtém e exibe o próximo evento na agenda
            agendaEventos.obterProximoEvento();
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
