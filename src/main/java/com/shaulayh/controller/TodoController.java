package com.shaulayh.controller;

import com.shaulayh.model.TodoData;
import com.shaulayh.model.TodoItem;
import com.shaulayh.service.TodoItemService;
import com.shaulayh.utils.AttributeNames;
import com.shaulayh.utils.Mappings;
import com.shaulayh.utils.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoController {

    private final TodoItemService todoItemService;

    @Autowired
    public TodoController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData() {
        return todoItemService.getData();
    }


    @GetMapping(Mappings.ITEMS)
    public String getItems() {
        return ViewNames.ITEMS;
    }

    @GetMapping(Mappings.ITEM)
    public String getItem(@RequestParam int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute("Id", todoItem.getId());
        model.addAttribute("title", todoItem.getTitle());
        model.addAttribute("details", todoItem.getDetails());
        model.addAttribute("deadline", todoItem.getDeadline());
//        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ITEM;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addItem(@RequestParam(required = false, defaultValue = "0") int id,
                          Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("Enter", "details", LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form is {}", todoItem);
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE)
    public String deleteItem(@RequestParam int id) {
        log.info("the id from delete request is= {}", id);
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
