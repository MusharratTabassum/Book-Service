package bd.edu.seulibrary.librarymanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer serial_no;
    private String book_name;
    private String author_name;
    private String publisher_name;
    private String Edition;
    private String section;
}
