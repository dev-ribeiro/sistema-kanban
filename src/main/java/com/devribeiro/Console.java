package com.devribeiro;

import java.util.Scanner;

import com.devribeiro.enums.Status;

public class Console {
  private Kanban kanban;

  public Console() {
    this.kanban = new Kanban();
  }

  public void start() {

    while (true) {
      Scanner scanner = new Scanner(System.in);

      this.logMenu();
      Integer action = scanner.nextInt();

      if (action == 1) {
        System.out.println("LISTANDO TODAS AS TAREFAS");
        this.kanban.listAllTasks();
      } else if (action == 2) {
        this.logFilter(scanner);
      } else if (action == 3) {
        scanner.nextLine();

        System.out.println("CRIANDO TAREFA");
        System.out.println("=============");
        System.out.println("\n");
        System.out.println("INFORME O NOME DA TAREFA QUE SERÁ CRIADA");
        String taskName = scanner.nextLine();
        this.kanban.createTask(taskName);
      } else if (action == 4) {
        this.logUpdateTaskStatus(scanner);
      } else if (action == 0) {
        System.out.println("FECHANDO A APLICAÇÃO");
        break;
      } else {
        System.out.println("OPÇÃO NÃO ENCONTRADA");
      }
    }
  }

  private void logMenu() {
    System.out.println("\n");
    System.out.println("O que deseja fazer?");
    System.out.println("1 - LISTAR TAREFAS");
    System.out.println("2 - FILTRAR TAREFAS");
    System.out.println("3 - CRIAR TAREFAS");
    System.out.println("4 - ATUALIZAR O STATUS DA TAREFA");
    System.out.println("0 - FECHAR A APLICAÇÃO");
  }

  private void logFilter(Scanner scanner) {
    scanner.nextLine();

    System.out.println("1 - FILTRAR POR ID");
    System.out.println("2 - FILTRAR POR STATUS");
    Integer newAction = scanner.nextInt();

    if (newAction == 1) {
      scanner.nextLine();

      System.out.println("INFORME O ID QUE DESEJA ACESSAR:");
      Integer id = scanner.nextInt();
      this.kanban.getTaskById(id);
    } else if (newAction == 2) {
      scanner.nextLine();

      System.out.println("INFORME O STATUS QUE DESEJA FILTRAR:");
      System.out.println("PARA_FAZER");
      System.out.println("FEITO");
      System.out.println("ESPERANDO");
      System.out.println("TRABALHANDO");
      String status = scanner.nextLine();
      Status parsedStatus = Status.valueOf(status);
      this.kanban.getTasksByStatus(parsedStatus);
    } else {
      System.out.println("FUNÇÃO NÃO LOCALIZADA");
    }
  }

  private void logUpdateTaskStatus(Scanner scanner) {
    scanner.nextLine();
    System.out.println("INFORME O ID QUE DESEJA FILTRAR");
    Integer id = scanner.nextInt();
    System.out.println("STATUS DISPONÍVEIS:");
    System.out.println("- PARA_FAZER");
    System.out.println("- FEITO");
    System.out.println("- ESPERANDO");
    System.out.println("- TRABALHANDO");
    scanner.nextLine();
    String newStatus = scanner.nextLine();
    Status parsedNewStatus = Status.valueOf(newStatus);
    this.kanban.updateTaskStatus(id, parsedNewStatus);
  }
}
