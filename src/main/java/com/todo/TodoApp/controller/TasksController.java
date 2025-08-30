package com.todo.TodoApp.controller;

import com.fasterxml.jackson.databind.ser.std.RawSerializer;
import com.todo.TodoApp.model.Tasks;
import com.todo.TodoApp.service.TaskService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TasksController {

    @Autowired
    TaskService taskService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Tasks>> getAllTasks(){
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Tasks>> getAllCompletedTasks(){
        return new ResponseEntity<>(taskService.findAllCompletedTasks(),HttpStatus.OK);
    }
    @GetMapping("/incompleted")
    public ResponseEntity<List<Tasks>> getAllIncompletedTasks(){
        return new ResponseEntity<>(taskService.findAllIncompletedTasks(),HttpStatus.OK);
    }
    @PostMapping("/create/tasks")
    public ResponseEntity<Tasks> saveTasks(@RequestBody Tasks tasks) {
        return new ResponseEntity<Tasks>(taskService.saveTasks(tasks), HttpStatus.CREATED);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Tasks> updateTasks(@PathVariable Integer id, @RequestBody Tasks task){
        task.setId(id);
        return new ResponseEntity<>(taskService.updateTasks(task),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTasks(@PathVariable Integer id){
        taskService.deleteTasks(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }



}
