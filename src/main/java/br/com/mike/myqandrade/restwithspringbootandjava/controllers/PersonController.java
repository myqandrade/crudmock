package br.com.mike.myqandrade.restwithspringbootandjava.controllers;

import br.com.mike.myqandrade.restwithspringbootandjava.model.Person;
import br.com.mike.myqandrade.restwithspringbootandjava.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    public ResponseEntity<?> create(@RequestBody Person person){
        return new ResponseEntity<Person>(personService.create(person), CREATED);
    }

    @PutMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public ResponseEntity<?> update(@RequestBody Person person, @PathVariable Long id){
        return ResponseEntity.ok(personService.update(person, id));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
