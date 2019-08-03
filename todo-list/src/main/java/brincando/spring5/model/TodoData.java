package brincando.spring5.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoData {

    // fields ==
    public static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    // == constructor ==
    public TodoData() {

        //add some dummy data, using the addItem Method so it sets the id field;
        addItem(new TodoItem("First", "First Details", LocalDate.now()));
        addItem(new TodoItem("Second", "Second Details", LocalDate.now()));
        addItem(new TodoItem("Third", "Third Details", LocalDate.now()));
        addItem(new TodoItem("Fourth", "Fourth Details", LocalDate.now()));
        addItem(new TodoItem("Fifth", "Fifht Details", LocalDate.now()));
    }

    public List<TodoItem> getItems(){
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem todoItem){
       /* if (todoItem == null){
            throw new NullPointerException("to add is a riquired parameter.");
        }*/
        todoItem.setId(idValue);
        items.add(todoItem);
        idValue++;
    }

    public void removeItem(int id){

       /* java.util.ConcurrentModificationException
        Isso ocorre pois o Iterator utilizado internamente nesse laço vai detectar
        , na próxima chamada ao seu método next(), que o número de modificações
        desta ArrayList é diferente de quando ele foi instanciado.

        items.stream().filter(todoItem -> todoItem.getId() == id).forEach(items::remove);

         */
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.remove(items.get(i));
            }
        }
    }

    public TodoItem getItem(int id){

        /*for (TodoItem todoItem : items) {
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }
        return null;*/

        return items.stream().filter(todoItem -> todoItem.getId() == id).findFirst().orElse(null);
    }

    public void updateItem(@NonNull TodoItem todoItemUpdate){

     /* java.util.ConcurrentModificationException
        Isso ocorre pois o Iterator utilizado internamente nesse laço vai detectar
        , na próxima chamada ao seu método next(), que o número de modificações
        desta ArrayList é diferente de quando ele foi instanciado.

        items.stream().filter(
                todoItem -> todoItem.getId() == todoItemUpdate.getId())
                .forEach(todoItem -> items.set(items.indexOf(todoItem), todoItemUpdate));
     */
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == todoItemUpdate.getId()) {
                items.set(i, todoItemUpdate);
                break;
            }
        }
    }
}
