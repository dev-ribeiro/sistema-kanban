package com.devribeiro;

import com.devribeiro.enums.Status;

public class App {
  public static void main(String[] args) {
    Kanban kanban = new Kanban();

    kanban.createTask("TESTE");
    kanban.createTask("TESTE");
    kanban.createTask("TESTE");
    kanban.createTask("TESTE");
    kanban.createTask("TESTE");
    kanban.createTask("TESTE");


    kanban.updateTaskStatus(-4, Status.ESPERANDO);
  }
}
