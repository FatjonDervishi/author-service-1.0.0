package al.fatjon.authorservice.controller;

import al.fatjon.authorservice.model.AuthorPojo;
import al.fatjon.authorservice.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RequiredArgsConstructor
@RestController
@RequestMapping("/public/library/author-service")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAuthorById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.ok(authorService.getById(id));
        } catch(IllegalArgumentException ie) {
            return ResponseEntity.badRequest().body(ie);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }

    @GetMapping()
    public ResponseEntity<List<AuthorPojo>> getAuthors() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Object> createAuthor(@RequestBody AuthorPojo author ) {
        authorService.setNewAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body("Author created successfully");

    }

}
