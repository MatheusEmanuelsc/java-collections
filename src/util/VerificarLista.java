package util;

import java.util.List;

public class VerificarLista {

    public static void verifica(List lista){
        if (lista.isEmpty()){
            throw new RuntimeException("lista vazia");
        }

    }
}
