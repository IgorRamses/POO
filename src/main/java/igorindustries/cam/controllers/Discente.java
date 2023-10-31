package main.java.igorindustries.cam.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Discente {
    private String nomeCompleto;
    private static int matricula;
    private String curso;
    private int cargaHorariaTotal;
    private int quantidadeAtividades;

    Scanner scanner = new Scanner(System.in);

    public Discente(String nomeCompleto, int matricula, String curso) {
        this.nomeCompleto = nomeCompleto;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String recuperarNomeCompleto() {
        return nomeCompleto;
    }

    public void definirNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int recuperarMatricula() {
        return matricula;
    }

    public void definirMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String recuperarCurso() {
        return curso;
    }

    public void definirCurso(String curso) {
        this.curso = curso;
    }

    public int recuperarCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void definirCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public int recuperarQuantidadeAtividades() {
        return quantidadeAtividades;
    }

    public void definirQuantidadeAtividades(int quantidadeAtividades) {
        this.quantidadeAtividades = quantidadeAtividades;
    }

    public static boolean salvarDadosDiscente(ArrayList<Discente> discentes, Discente discente) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Deseja salvar os dados do discente? (s/n): ");
        String respostaSalvar = scanner.nextLine().trim().toLowerCase();

        if (respostaSalvar.equalsIgnoreCase("s") || respostaSalvar.equalsIgnoreCase("sim")) {
            System.out.println("Dados salvos!");
            discentes.add(discente);
            return true;
        } else {
            System.out.println("Dados não salvos.");
            return false;
        }
    }

    public static Discente cadastrarDiscente(ArrayList<Discente> discentes) {
        Scanner scanner = new Scanner(System.in);
        String nomeCompleto = "";
        while (true) {
            System.out.println("Coloque o Nome Completo do discente: ");
            nomeCompleto = scanner.nextLine();
            if (Pattern.matches("^[a-zA-Z ]+$", nomeCompleto)) {
                break;
            } else {
                System.out.println("Erro: O nome deve ter apenas letras. Por favor, tente dnv.");
            }
        }

        int matricula = 0;
        while (true) {
            System.out.println("Coloque o Número de Matrícula do Discente: ");
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Erro: A matrícula deve ter apenas números. Por favor, tente dnv.");
                scanner.nextLine();
            }
        }

        String curso = "";
        while (true) {
            System.out.println("Coloque o Curso do Discente: ");
            curso = scanner.nextLine();
            if (Pattern.matches("^[a-zA-Z ]+$", curso)) {
                break;
            } else {
                System.out.println("Erro: O curso deve ter apenas letras. Por favor, tente dnv.");
            }
        }
        Discente discente = new Discente(nomeCompleto, matricula, curso);
        boolean dadosSalvos = salvarDadosDiscente(discentes, discente);
        if (dadosSalvos) {
            System.out.println("Discente cadastrado!");
        } else {
            System.out.println("Cadastro do discente cancelado.");
        }

        return discente;
    }

    public static boolean verificarMatriculaExistente(int numeroMatricula, ArrayList<Discente> discentes) {
        for (Discente discente : discentes) {
            if (discente.recuperarMatricula() == numeroMatricula) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarCargaHorariaTotalDiscentes(ArrayList<Discente> discentes) {
        if (discentes.isEmpty()) {
            System.out.println("Nenhum discente está cadastrado.");
        } else {
            System.out.println("Carga horária total das atividades complementares de todos os discentes cadastrados:");
            for (Discente discente : discentes) {
                System.out.println("Nome: " + discente.recuperarNomeCompleto());
                System.out.println("Número de Matrícula: " + discente.recuperarMatricula());
                System.out.println("Curso: " + discente.recuperarCurso());
                System.out.println("Carga Horária Total: " + discente.recuperarCargaHorariaTotal() + " horas");
                System.out.println("Quantidade de Atividades Complementares: " + discente.recuperarQuantidadeAtividades());
                System.out.println("------------------------");
            }
        }
    }

    public static void mostrarCargaHorariaDiscentePorMatricula(ArrayList<Discente> discentes) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Coloque o número de matrícula do discente para mostrar as atividades complementares: ");
            if (scanner.hasNextInt()) {
                matricula = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println(
                        "Erro: A matrícula deve ter apenas números. Por favor, tente dnv.");
                scanner.nextLine();
            }
        }

        boolean encontrado = false;
        for (Discente discente : discentes) {
            if (discente.recuperarMatricula() == matricula) {
                System.out.println("Nome: " + discente.recuperarNomeCompleto());
                System.out.println("Número de Matrícula: " + discente.recuperarMatricula());
                System.out.println("Curso: " + discente.recuperarCurso());
                System.out.println("Carga Horária Total: " + discente.recuperarCargaHorariaTotal() + " horas");
                System.out.println("Quantidade de Atividades Complementares: " + discente.recuperarQuantidadeAtividades());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println(
                    "Discente com a matrícula " + matricula + " não encontrado, ou não foi cadastrado no sistema");
        }
    }
}
