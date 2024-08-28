package Aula22_Operacoes.ExemploArquivo;
import java.io.*;
import java.nio.channels.ScatteringByteChannel;
public class Escrevendo {
    public static void main(String[] args) {

        File caminho = new File ("C:\\Users\\laris\\OneDrive\\ÁreadeTrabalho\\Programação\\2 trimestre");
        if (caminho.exists())
            System.out.println("O caminho existe");
        else {
            System.out.println("O caminho não existe, tentando criar...");
            caminho.mkdirs();
        }

        //testando escrever uma pessoa em um arquivo
        Pessoa p1 = new Pessoa();
        p1.setNome("Jonas");
        p1.setSobrenome("Silva");
        File arquivo = new File(caminho,"dadosPessoa.db");
        try{
            ObjectOutputStream objEscrita =
                    new ObjectOutputStream(new FileOutputStream(arquivo.getAbsolutePath()));
            objEscrita.writeObject(p1);
            objEscrita.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Erro ao ler arquivo");
        }
        catch (IOException e){
            System.out.println("Erro ao gravar as informações");
        }
    }
}
