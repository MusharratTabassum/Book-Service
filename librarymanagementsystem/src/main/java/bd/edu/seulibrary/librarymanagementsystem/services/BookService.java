package bd.edu.seulibrary.librarymanagementsystem.services;

import bd.edu.seulibrary.librarymanagementsystem.models.Book;
import bd.edu.seulibrary.librarymanagementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(int id){
        List<Book> bookList = bookRepository.findAll();
        Book book = null;
        for (Book b : bookList){
            if(id == b.getSerial_no()){
                book = b;
                break;
            }
        }

        return book;
    }

    public Boolean deleteById(int id){
        Book book = findById(id);

        if(book != null){
            List<Book> result = new ArrayList();
            List<Book> bookList = bookRepository.findAll();

            for (Book b : bookList){
                if(b.getSerial_no() != id)
                    result.add(b);
            }

            bookRepository.deleteAll();
            bookRepository.saveAll(result);
            return true;
        }
        else
            return false;
    }

    public Book create(Book book){
        return bookRepository.save(book);
    }

    public Book update(int id, Book book){
        Book result = findById(id);
        if (result != null) {
           book.setSerial_no(id);
           return bookRepository.save(book);
        }
        else
            return null;
    }

}
