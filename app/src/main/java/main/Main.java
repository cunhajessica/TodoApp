package main;

import controller.ProjectController;
import controller.TaskController;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;

public class Main {

    public static void main(String[] args) {
// Testando os recursos do TodoApp

//        ProjectController projectController = new ProjectController();
//        Project project = new Project();
//        project.setName("Projeto teste");
//        project.setDescription("description");
//        projectController.save(project);
        TaskController taskController = new TaskController();

        Task task = new Task();
        task.setIdProject(3);
//        task.setName("Criar as telas de aplicação");
        task.setName("Alterar telas de aplicação");
        task.setDescription("Devem ser criadas telas de cadastro.");
        task.setNotes("Sem notas");
        task.setIsCompleted(false);
        task.setDeadline(new Date());

//        taskController.save(task);

        
//        taskController.update(task);
//        List<Task> tasks = taskController.getAll(2);
//        System.out.println("Total de tarefas = " + tasks.size());

        taskController.removeById(2);
    }
}
