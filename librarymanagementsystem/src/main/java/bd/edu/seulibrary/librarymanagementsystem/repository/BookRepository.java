package bd.edu.seulibrary.librarymanagementsystem.repository;


import bd.edu.seulibrary.librarymanagementsystem.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {}
