package bd.edu.seulibrary.librarymanagementsystem.controller;

import bd.edu.seulibrary.librarymanagementsystem.models.Book;
import bd.edu.seulibrary.librarymanagementsystem.models.MyInfo;
import bd.edu.seulibrary.librarymanagementsystem.repository.BookRepository;
import bd.edu.seulibrary.librarymanagementsystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/books")
public class BookController {

    private BookRepository bookRepository;
    @Autowired
    private BookService bookService;

    public BookController(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> bookList = bookService.findAll();
        return ResponseEntity.ok(bookList);
    }

    @GetMapping("/{serial_no}")
    public ResponseEntity<Book> getBookById(@PathVariable("serial_no") int serial_no) {
        Book book = bookService.findById(serial_no);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        try {
            Book createdBook = bookService.create(book);
            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{newId}")
    public ResponseEntity<Book> updatedBook(@PathVariable("newId") int newId, @RequestBody Book book) {
        Book updatedBook = bookService.update(newId, book);
        if(updatedBook != null){
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{serial_no}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("serial_no") int serial_no) {
        Boolean deleted = bookService.deleteById(serial_no);
        if(deleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getinfo")
    public ResponseEntity<MyInfo> getInfo() {
        MyInfo obj = new MyInfo("Book-Webservice", "Version 1.0", "Musharrat Tabassum Oyshi", "2017100000010");
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
