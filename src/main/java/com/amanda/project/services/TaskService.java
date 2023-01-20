package com.amanda.project.services;

import com.amanda.project.entities.Task;
import com.amanda.project.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException(String.valueOf(id)));
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public Task update(Long id, Task task) {
        Task entity = taskRepository.getReferenceById(id);
        updateTask(entity, task);
        return taskRepository.save(entity);

    }

    private void updateTask(Task initialTask, Task task) {
        initialTask.setTitle(task.getTitle());
        initialTask.setDescription(task.getDescription());
        initialTask.setDateLine(task.getDateLine());
    }
}
