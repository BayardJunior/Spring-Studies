package brincando.spring5.service;

import brincando.spring5.model.TodoData;
import brincando.spring5.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    @Getter
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem item) {

        data.addItem(item);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem updateItem) {
        data.updateItem(updateItem);
    }
}
