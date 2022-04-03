package al.fatjon.authorservice.repository;

import al.fatjon.authorservice.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AuthorLocalRepository extends JpaRepository<AuthorEntity, Integer> {
    Optional<AuthorEntity> findById(Integer id);
}
