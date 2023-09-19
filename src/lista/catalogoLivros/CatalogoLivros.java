package lista.catalogoLivros;

import util.VerificarLista;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    private List<Livro> catalogoDeLivros;

    public CatalogoLivros() {
        catalogoDeLivros= new ArrayList<>();
    }


    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
            catalogoDeLivros.add(new Livro(titulo,autor,anoPublicacao));
    }

    public List pesquisarPorAutor(String autor){

        VerificarLista.verifica(catalogoDeLivros);
        List <Livro> listaDeLivroAutor= new ArrayList<>();
            for (Livro livro : catalogoDeLivros){
                if (livro.getAutor().equalsIgnoreCase(autor)){
                    listaDeLivroAutor.add(livro);
                }


            }
        return listaDeLivroAutor;
    }

    public List pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
        VerificarLista.verifica(catalogoDeLivros);

        List <Livro>listaDeLivrosNoIntervaloDosAnos= new ArrayList<>();

        for(Livro livro :catalogoDeLivros){
            if (livro.getAnoPublicacao()>=anoInicial && livro.getAnoPublicacao()<=anoFinal ){
                listaDeLivrosNoIntervaloDosAnos.add(livro);
            }


        }
        return listaDeLivrosNoIntervaloDosAnos;
    }

    public Livro pesquisarPorTitulo(String titulo){
        VerificarLista.verifica(catalogoDeLivros);
        Livro livroTitulo=null;
        for(Livro livro:catalogoDeLivros){

            if (livro.getTitulo().equalsIgnoreCase(titulo)){
                livroTitulo=livro;
                break;
            }

        }
        return livroTitulo;
    }

    public static void main(String[] args) {

        CatalogoLivros catalogoLivros = new CatalogoLivros();


        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);


        System.out.println(catalogoLivros.pesquisarPorAutor("Robert C. Martin"));

        System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022));

        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2025, 2030));

        System.out.println(catalogoLivros.pesquisarPorTitulo("Java Guia do Programador"));


        System.out.println(catalogoLivros.pesquisarPorTitulo("Título Inexistente"));
    }


}
