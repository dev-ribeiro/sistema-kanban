package com.devribeiro;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.devribeiro.enums.Status;
import com.devribeiro.models.Task;

public class KanbanTest {

  @Test
  public void shouldBeCreateATask() {
    Kanban kanban = new Kanban();

    kanban.createTask("TESTE");

    List<Task> allTasks = kanban.listAllTasks();

    Integer expectedSize = 1;
    Integer size = allTasks.size();
    assertEquals("O tamanho da lista seja 1", expectedSize, size);
  }

  @Test
  public void shouldBeUpdateATask() {
    Kanban kanban = new Kanban();

    kanban.createTask("TESTE1");
    kanban.updateTaskStatus(1, Status.FEITO);

    Task task = kanban.getTaskById(1).get(0);

    Status expectedStatus = Status.FEITO;
    Status currentTaskStatus = task.getStatus();

    assertEquals("Deve ser possível atualizar o status de uma tarefa", expectedStatus, currentTaskStatus);
  }

  @Test
  public void shouldBeListAllTasks() {
    Kanban kanban = new Kanban();

    kanban.createTask("TESTE");
    kanban.createTask("TESTE");
    kanban.createTask("TESTE");

    Integer expectedSize = 3;
    Integer currentSize = kanban.listAllTasks().size();
    assertEquals("Deve ser possível listar todas as tarefas", expectedSize, currentSize);
  }

  @Test
  public void shouldBeFilterTaskByStatus() {
    Kanban kanban = new Kanban();

    kanban.createTask("TESTE1");
    kanban.createTask("TESTE2");
    kanban.createTask("TESTE3");

    kanban.updateTaskStatus(2, Status.TRABALHANDO);
    kanban.updateTaskStatus(3, Status.TRABALHANDO);

    Integer expectedListSize = 2;
    Integer currentListSize = kanban.getTasksByStatus(Status.TRABALHANDO).size();

    assertEquals("Deve ser possível filtrar as tarefas por status", expectedListSize, currentListSize);
  }

  @Test
  public void shouldBeFilterTaskById() {
    Kanban kanban = new Kanban();

    kanban.createTask("TESTE1");
    kanban.createTask("TESTE2");
    kanban.createTask("TESTE3");

    Integer expectedListSize = 1;
    Integer currentListSize = kanban.getTaskById(2).size();

    assertEquals("Deve ser possível recuperar uma task pelo id", expectedListSize, currentListSize);
  }
}
