package lista.ordencaoNumero;

import util.VerificarLista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros  {
    private List<Integer> listaNumeros;

    public OrdenacaoNumeros() {
        listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero){
        listaNumeros.add(numero);

    }
    public List<Integer> ordenarAscendente(){
        VerificarLista.verifica(listaNumeros);
        List<Integer>listaAscenteNumeros= new ArrayList<>(listaNumeros);
        Collections.sort(listaAscenteNumeros);
        return listaAscenteNumeros;
    }
    public List<Integer> ordenarDescendente(){
        VerificarLista.verifica(listaNumeros);
        List<Integer>listaDescendenteNumeros= new ArrayList<>(listaNumeros);
        Collections.sort(listaDescendenteNumeros);
        listaDescendenteNumeros.sort(Collections.reverseOrder());
        return listaDescendenteNumeros;
    }


    public static void main(String[] args) {

        OrdenacaoNumeros numeros = new OrdenacaoNumeros();

        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);



        System.out.println(numeros.ordenarAscendente());




        System.out.println(numeros.ordenarDescendente());


    }
}
