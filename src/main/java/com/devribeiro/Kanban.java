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

  public void listAllTasks() {
    for (Task task : this.tasks) {
      System.out.println("=====================");
      System.out.println(task.getId());
      System.out.println(task.getName());
      System.out.println(task.getStatus());
    }
  }

  public void getTaskById(Integer id) {
    List<Task> filteredTasks = this.tasks.stream()
        .filter(task -> task.getId() == id)
        .collect(Collectors.toList());

    if (filteredTasks.size() == 0) {
      System.out.println("ID NÃO ENCONTRADO");
    } else {
      for (Task task : filteredTasks) {
        System.out.println("=====================");
        System.out.println(task.getId());
        System.out.println(task.getName());
        System.out.println(task.getStatus());
      }
    }
  }

  public void getTasksByStatus(Status filter) {
    List<Task> filteredTasks = this.tasks.stream()
        .filter(task -> task.getStatus() == filter)
        .collect(Collectors.toList());

    if (filteredTasks.size() == 0) {
      System.out.println("NÃO TAREFAS CADASTRADAS NESSA COM ESSE STATUS");
    } else {
      for (Task task : filteredTasks) {
        System.out.println("=====================");
        System.out.println(task.getId());
        System.out.println(task.getName());
        System.out.println(task.getStatus());
      }
    }
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
