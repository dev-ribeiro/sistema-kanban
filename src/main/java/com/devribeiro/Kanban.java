package com.devribeiro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.devribeiro.enums.Status;
import com.devribeiro.models.Task;

public class Kanban {

  private List<Task> tasks;

  public Kanban() {
    this.tasks = new ArrayList<>();
  }

  public void createTask(String name) {
    Integer id = tasks.size() + 1;

    Task register = new Task(id, name, Status.PARA_FAZER);

    this.tasks.add(register);
  }

  public List<Task> listAllTasks() {
    return this.tasks;

  }

  public List<Task> getTaskById(Integer id) {
    List<Task> filteredTasks = this.tasks.stream()
        .filter(task -> task.getId() == id)
        .collect(Collectors.toList());

    return filteredTasks;
  }

  public List<Task> getTasksByStatus(Status filter) {
    List<Task> filteredTasks = this.tasks.stream()
        .filter(task -> task.getStatus() == filter)
        .collect(Collectors.toList());

    return filteredTasks;
  }

  public void updateTaskStatus(Integer id, Status newStatus) {
    Integer currentTaskSize = this.tasks.size();

    if (id > currentTaskSize || id < 1) {
      System.out.println("ID NÃO CADASTRADO");
    } else {
      List<Task> updatedTaskList = this.tasks.stream()
          .map(task -> {
            if (task.getId() == id) {
              task.setStatus(newStatus);
            }

            return task;
          })
          .collect(Collectors.toList());

      this.tasks = updatedTaskList;

      System.out.println("LISTA ATUALIZADA COM SUCESSO");
    }
  }

}
