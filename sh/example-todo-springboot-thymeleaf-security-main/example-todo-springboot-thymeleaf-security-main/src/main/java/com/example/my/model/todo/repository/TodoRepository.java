package com.example.my.model.todo.repository;

import com.example.my.model.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    List<TodoEntity> findByUserEntity_IdAndDeleteDateIsNull(Long userId);
    //todo : Select *
    //todo : From TODO JOIN 'USER' u ON u.id = t.user_id WHERE t.user_id = ? AND t.delete_date is null;

    Optional<TodoEntity> findByIdAndDeleteDateIsNull(Long id);

}
