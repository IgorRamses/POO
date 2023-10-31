package main.java.igorindustries.cam.controllers;

import java.util.ArrayList;
import java.util.Scanner;

public class AtividadeCurricular {
    private String nomeAtividadeCurricular;
    private int matriculaAtividadeCurricular;
    private static int contadorNumeroRegistro = 1;
    private int numeroRegistro;
    private int grupoAtividade;
    private String descricaoAtividade;
    private boolean statusAproveitamento;
    private int cargaHorariaConsiderada;

    public AtividadeCurricular(String nomeAtividadeCurricular, int matriculaAtividadeCurricular, int grupoAtividade,
            String descricaoAtividade) {
        this.nomeAtividadeCurricular = nomeAtividadeCurricular;
        this.matriculaAtividadeCurricular = matriculaAtividadeCurricular;
        this.grupoAtividade = grupoAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.statusAproveitamento = false;
        this.cargaHorariaConsiderada = 0;
        this.numeroRegistro = contadorNumeroRegistro;
        contadorNumeroRegistro++;
    }

    public static boolean salvarAtividade(ArrayList<AtividadeCurricular> atividades, AtividadeCurricular atividade) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Vc quer salvar as informações da atividade? (s/n): ");
        String respostaSalvar = scanner.nextLine().trim().toLowerCase();

        if (respostaSalvar.equalsIgnoreCase("s") || respostaSalvar.equalsIgnoreCase("sim")) {
            System.out.println("Informações salvas!");
            atividades.add(atividade);
            return true;
        } else {
            System.out.println("Informações não salvas.");
            return false;
        }
    }

    public static AtividadeCurricular cadastrarAtividade(ArrayList<AtividadeCurricular> atividades) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Coloque o nome da atividade curricular: ");
        String nomeAtividadeCurricular = scanner.nextLine();

        int matriculaAtividadeCurricular = 0;
        while (true) {
            System.out.print("Coloque a matrícula do aluno: ");
            if (scanner.hasNextInt()) {
                matriculaAtividadeCurricular = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Erro: A matrícula deve ter apenas números. Tente dnv.");
                scanner.nextLine();
            }
        }

        int grupoAtividade = 0;
        while (true) {
            System.out.print("Coloque o grupo da atividade: ");
            if (scanner.hasNextInt()) {
                grupoAtividade = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println(
                        "Erro: O grupo de atividade deve ter apenas números. Por favor, tente dnv.");
                scanner.nextLine();
            }
        }

        System.out.print("Coloque a descrição da atividade: ");
        String descricaoAtividade = scanner.nextLine();

        AtividadeCurricular atividade = new AtividadeCurricular(nomeAtividadeCurricular, matriculaAtividadeCurricular,
                grupoAtividade, descricaoAtividade);
        boolean dadosSalvos = salvarAtividade(atividades, atividade);
        if (dadosSalvos) {
            System.out.println("Atividade curricular criada! Número de registro da atividade é "
                    + atividade.getNumeroRegistro());
        } else {
            System.out.println("Cadastro da atividade curricular cancelado.");
        }

        return atividade;
    }

    public void exibirAtividadeCurricular() {
        System.out.println("Número de Registro: " + numeroRegistro);
        System.out.println("Nome da Atividade Curricular: " + nomeAtividadeCurricular);
        System.out.println("Matrícula: " + matriculaAtividadeCurricular);
        System.out.println("Grupo da Atividade: " + grupoAtividade);
        System.out.println("Descrição da Atividade: " + descricaoAtividade);
        System.out.println("Status de Aproveitamento: " + statusAproveitamento);
        System.out.println("Carga Horária Considerada: " + cargaHorariaConsiderada + " horas\n");
    }

    public static void exibirAtividades(ArrayList<AtividadeCurricular> atividades) {
        for (AtividadeCurricular atividade : atividades) {
            atividade.exibirAtividadeCurricular();
        }
    }

    public static void alterarStatusAproveitamento(ArrayList<AtividadeCurricular> atividades,
            ArrayList<AtividadeCurricular> atividadesAprovadas) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Coloque o número de registro da atividade que deseja alterar o status de aproveitamento: ");
        int numeroRegistro = scanner.nextInt();
        scanner.nextLine();

        boolean encontrou = false;
        for (AtividadeCurricular atividade : atividades) {
            if (atividade.getNumeroRegistro() == numeroRegistro) {
                encontrou = true;
                if (atividade.isStatusAproveitamento()) {
                    System.out.println("Atenção: Esta atividade já foi aprovada antes.");
                    return;
                } else {
                    System.out.print("Digite o novo status de aproveitamento (true ou false): ");
                    boolean novoStatusAproveitamento = scanner.nextBoolean();
                    scanner.nextLine();
                    atividade.setStatusAproveitamento(novoStatusAproveitamento);

                    if (novoStatusAproveitamento) {
                        System.out.print("Coloque a carga horária considerada para esta atividade: ");
                        int cargaHoraria = scanner.nextInt();
                        scanner.nextLine();
                        atividade.setCargaHorariaConsiderada(cargaHoraria);
                        atividadesAprovadas.add(atividade);
                        System.out.println("Atividade aprovada!");
                    } else {
                        System.out.println("Atividade reprovada.");
                    }
                    break;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Atividade com o número de registro " + numeroRegistro + " não encontrada.");
        }
    }

    public String getNomeAtividadeCurricular() {
        return nomeAtividadeCurricular;
    }

    public void setNomeAtividadeCurricular(String nomeAtividadeCurricular) {
        this.nomeAtividadeCurricular = nomeAtividadeCurricular;
    }

    public int getMatriculaAtividadeCurricular() {
        return matriculaAtividadeCurricular;
    }

    public void setMatriculaAtividadeCurricular(int matriculaAtividadeCurricular) {
        this.matriculaAtividadeCurricular = matriculaAtividadeCurricular;
    }

    public static int getContadorNumeroRegistro() {
        return contadorNumeroRegistro;
    }

    public static void setContadorNumeroRegistro(int contadorNumeroRegistro) {
        AtividadeCurricular.contadorNumeroRegistro = contadorNumeroRegistro;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public int getGrupoAtividade() {
        return grupoAtividade;
    }

    public void setGrupoAtividade(int grupoAtividade) {
        this.grupoAtividade = grupoAtividade;
    }

    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public boolean isStatusAproveitamento() {
        return statusAproveitamento;
    }

    public void setStatusAproveitamento(boolean statusAproveitamento) {
        this.statusAproveitamento = statusAproveitamento;
    }

    public int getCargaHorariaConsiderada() {
        return cargaHorariaConsiderada;
    }

    public void setCargaHorariaConsiderada(int cargaHorariaConsiderada) {
        this.cargaHorariaConsiderada = cargaHorariaConsiderada;
    }
}
