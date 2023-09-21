package util;


import java.util.Map;

public class VerificaMap {

    public static void verifica(Map colecao){
        if (colecao.isEmpty()){
            throw new RuntimeException("lista vazia");
        }

    }
}
