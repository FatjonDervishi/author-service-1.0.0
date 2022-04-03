package al.fatjon.authorservice.manager;

import al.fatjon.authorservice.model.AuthorEntity;
import al.fatjon.authorservice.repository.AuthorLocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthorEntityManager {
    @Autowired
    AuthorLocalRepository localRepository;

    public AuthorEntity findById(Integer id) {
        AuthorEntity authorEntity = localRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Authors found with that ID"));
        return authorEntity;
    }

    public List<AuthorEntity> findAll() {
        return localRepository.findAll();
    }

    public void create(AuthorEntity authorEntity) {
        localRepository.save(authorEntity);
    }

}
