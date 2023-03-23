package br.com.mike.myqandrade.restwithspringbootandjava.services;

import br.com.mike.myqandrade.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    private List<Person> persons = new ArrayList<>();

    public Person findById(String id){
        logger.info("Finding one person");
        int identification = Integer.parseInt(id);
        return persons.get(identification - 1);
    }

    public List<Person> findAll(){
        logger.info("Finding all people");
        return persons;
    }

    public Person create(Person p){
        logger.info("Creating one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        person.setAddress(p.getAddress());
        person.setGender(p.getGender());

        persons.add(person);

        return person;
    }

    public Person update(Person person, Long id){
        logger.info("Updating person");
        int identification = id.intValue();
        var p = persons.get(identification - 1);
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setAddress(person.getAddress());
        p.setGender(person.getGender());
        return p;
    }

    public void delete(Long id){
        logger.info("Deleting person");
        int identification = id.intValue();
        persons.remove(identification - 1);
    }



}
