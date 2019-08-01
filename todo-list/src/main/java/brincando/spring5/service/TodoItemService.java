package brincando.spring5.service;

import brincando.spring5.model.TodoData;
import brincando.spring5.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem item);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem updateItem);

    TodoData getData();

}
