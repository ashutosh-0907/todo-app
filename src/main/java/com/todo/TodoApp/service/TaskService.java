package com.todo.TodoApp.service;

import com.todo.TodoApp.model.Tasks;
import com.todo.TodoApp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Tasks saveTasks(Tasks task){
        return taskRepository.save(task);
    }

    public Tasks getTasks(Integer id){
        return taskRepository.findTasksById(id);
    }

    public List<Tasks> findAllTasks(){
        return taskRepository.findAll();
    }

    public List<Tasks> findAllCompletedTasks(){
        return taskRepository.findByCompletedTrue();
    }

    public List<Tasks> findAllIncompletedTasks(){
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTasks(Integer id){
        taskRepository.deleteById(id);
    }

    public Tasks updateTasks(Tasks task){
        return taskRepository.save(task);
    }
}
