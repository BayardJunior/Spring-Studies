package brincando.spring5.model;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id") // {"id", "title"} multiplos
public class TodoItem {

    // == fields ==
    private int id;
    private String title;
    private String details;
    private LocalDate deadLine;

    // == constructor ==
    public TodoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadLine = deadLine;
    }
}