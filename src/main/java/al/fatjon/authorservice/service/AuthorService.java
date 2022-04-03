package al.fatjon.authorservice.service;

import al.fatjon.authorservice.manager.AuthorEntityManager;
import al.fatjon.authorservice.model.AuthorEntity;
import al.fatjon.authorservice.model.AuthorPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorService {
    @Autowired
    AuthorEntityManager authorEntityManager;

    public AuthorPojo getById(Integer id) {
        return entityToPojo(authorEntityManager.findById(id));
    }

    public List<AuthorPojo> getAll() {
        return authorEntityManager.findAll().stream().map(e -> entityToPojo(e)).collect(Collectors.toList());
    }

    public void setNewAuthor(AuthorPojo author){
        authorEntityManager.create(pojoToEntity(author));
    }
    private AuthorEntity pojoToEntity (AuthorPojo author){
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(author.getName());
        authorEntity.setBio(author.getBio());
        return authorEntity;
    }

    private AuthorPojo entityToPojo(AuthorEntity authorEntity) {
        AuthorPojo author = new AuthorPojo();
        author.setId(authorEntity.getId());
        author.setName(authorEntity.getName());
        author.setBio(authorEntity.getBio());
        return author;
    }
}
