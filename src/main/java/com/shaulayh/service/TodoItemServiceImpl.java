package com.shaulayh.service;

import com.shaulayh.model.TodoData;
import com.shaulayh.model.TodoItem;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class TodoItemServiceImpl implements TodoItemService {


    private final TodoData data = new TodoData();

    public TodoItemServiceImpl() {
        data.addItem(new TodoItem("Wake", "to wake up", LocalDate.now()));
        data.addItem(new TodoItem("Eat", "to eat", LocalDate.now()));
        data.addItem(new TodoItem("Sleep", "to sleep", LocalDate.now()));
    }


    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getTodoItem(id);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        data.updateItem(todoItem);
    }

    @Override
    public TodoData getData() {
        log.info("good to know {}", data);
        return data;
    }
}
