package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Author;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
