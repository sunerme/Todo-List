package com.app.todoapp.repository;

import com.app.todoapp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReposirory extends JpaRepository<Task, Long> {
}
