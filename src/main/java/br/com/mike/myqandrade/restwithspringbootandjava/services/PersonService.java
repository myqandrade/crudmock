package br.com.mike.myqandrade.restwithspringbootandjava.services;

import br.com.mike.myqandrade.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.mike.myqandrade.restwithspringbootandjava.model.Person;
import br.com.mike.myqandrade.restwithspringbootandjava.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    private List<Person> persons = new ArrayList<>();

    public Person findById(Long id){
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public Person update(Person person){
        Person entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public void delete(Long id){
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }



}
