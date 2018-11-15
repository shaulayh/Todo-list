package com.shaulayh.service;

import com.shaulayh.model.TodoData;
import com.shaulayh.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem todoItem);

    void removeItem(int id);

    TodoItem getItem(int id);

    TodoData getData();

    void updateItem(TodoItem todoItem);
}
