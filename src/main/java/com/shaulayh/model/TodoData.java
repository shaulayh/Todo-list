package com.shaulayh.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    private int Id;
    private List<TodoItem> items = new ArrayList<>();

    public TodoData() {
        this.Id = 1;
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem todoItem) {
        todoItem.setId(Id);
        items.add(todoItem);
        Id++;
    }

    public void removeItem(int Id) {
        ListIterator<TodoItem> itemIterator = items.listIterator();
        while (itemIterator.hasNext()) {
            TodoItem item = itemIterator.next();
            if (item.getId() == Id) {
                itemIterator.remove();
                break;
            }
        }
    }

    public TodoItem getTodoItem(int Id) {
        for (TodoItem todoItem : items) {
            if (todoItem.getId() == Id) {
                return todoItem;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem updateTodoItem) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            TodoItem item = itemListIterator.next();
            if (item.equals(updateTodoItem)) {
                itemListIterator.set(updateTodoItem);
                break;
            }
        }
    }
}
