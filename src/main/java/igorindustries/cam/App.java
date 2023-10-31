package main.java.igorindustries.cam;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.igorindustries.cam.controllers.AtividadeCurricular;
import main.java.igorindustries.cam.controllers.Discente;

public class App {
    public static void main(String[] args) {

        ArrayList<Discente> discentes = new ArrayList<>();
        ArrayList<AtividadeCurricular> atividades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("_________________________________________________________________________");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Atividade");
            System.out.println("3. Visualizar atividades a partir da matrícula");
            System.out.println("4. Alterar status de aproveitamento da atividade");
            System.out.println("5. Mostrar carga horária total das atividades complementares dos alunos");
            System.out.println("6. Mostrar carga horária total das atividades complementares de um aluno");
            System.out.println("7. Sair");
            System.out.println("_________________________________________________________________________");

            if (scanner.hasNextInt()) {
                int escolha = scanner.nextInt();
                scanner.nextLine();

                switch (escolha) {
                    case 1:
                        Discente estudante = Discente.cadastrarDiscente(discentes);
                        break;
                    case 2:
                        AtividadeCurricular atividade = AtividadeCurricular.cadastrarAtividade(atividades);
                        break;
                    case 3:
                        AtividadeCurricular.exibirAtividades(atividades);
                        break;
                    case 4:
                        AtividadeCurricular.alterarStatusAproveitamento(atividades, atividades);
                    case 5:
                        Discente.mostrarCargaHorariaTotalDiscentes(discentes);
                        break;
                    case 6:
                        Discente.mostrarCargaHorariaDiscentePorMatricula(discentes);
                        break;
                    case 7:
                        System.out.println(
                                "Obrigado por usar o sistema de gestão das atividades complementares. Tchau tchau!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
            } else {
                System.out.println("Opção inválida. Por favor, escolha novamente.");
                scanner.nextLine();
            }
        }
    }
}
