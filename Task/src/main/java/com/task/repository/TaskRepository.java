package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllByUsersId(long userid);

}
