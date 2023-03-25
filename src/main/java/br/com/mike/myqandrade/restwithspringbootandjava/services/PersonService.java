package br.com.mike.myqandrade.restwithspringbootandjava.services;

import br.com.mike.myqandrade.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.mike.myqandrade.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.mike.myqandrade.restwithspringbootandjava.model.Person;
import br.com.mike.myqandrade.restwithspringbootandjava.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonVO findById(Long id){
        var person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        var convertedPerson = PersonVO.personToPersonVO(person);
        return convertedPerson;
    }

    public List<PersonVO> findAll(){
        List<Person> personList = personRepository.findAll();
        List<PersonVO> personVOList = new ArrayList<>();
        for(Person person : personList){
            var convertedPerson = PersonVO.personToPersonVO(person);
            personVOList.add(convertedPerson);
        }
        return personVOList;
    }

    public PersonVO create(PersonVO personVO){
        var person = Person.personVOToPerson(personVO);
        personRepository.save(person);
        return personVO;
    }

    public PersonVO update(PersonVO personVO, Long id){
        var person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        person.setFirstName(personVO.getFirstName());
        person.setLastName(personVO.getLastName());
        person.setAddress(personVO.getAddress());
        person.setGender(personVO.getGender());
        personRepository.save(person);

        return personVO;
    }

    public void delete(Long id){
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }



}
