package bd.edu.seulibrary.librarymanagementsystem;

import bd.edu.seulibrary.librarymanagementsystem.models.Book;
import bd.edu.seulibrary.librarymanagementsystem.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
    }


    @Test
    void getAll(){
        List<Book> bookList = bookRepository.findAll();
        System.out.println(bookList);
    }

}
