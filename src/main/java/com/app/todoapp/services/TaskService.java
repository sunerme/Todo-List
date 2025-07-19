package com.app.todoapp.services;


import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskReposirory;
//import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskReposirory taskRepository;

    public TaskService(TaskReposirory taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTasks(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleeTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);

    }
}
