package com.todo.TodoApp.repository;

import com.todo.TodoApp.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {
    public Tasks findTasksById(Integer id);
    //public Tasks findByTasks(String tasks);
    public List<Tasks> findByCompletedTrue();
    public List<Tasks> findByCompletedFalse();
    //public void delete(Integer id);
}
