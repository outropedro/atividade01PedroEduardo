package org.example;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class main
{

    public static void main( String[] args ) throws ParseException {
        Scanner teclado = new Scanner(System.in);
        Funcionarios funcionarios = new Funcionarios();
        int opcao;
        System.out.println( "Selecione uma opção:\n1 - Cadastrar funcionario\n2 - Emitir relatorio" );
        opcao = teclado.nextInt();

        if(opcao == 1){

            funcionarios.cadastraFuncionario();

        }
        else if (opcao == 2){
            funcionarios.emitirRelatorio();
        }
        else{
            System.out.println("Opção invalida, selecione uma opção.");
        }
    }


}
