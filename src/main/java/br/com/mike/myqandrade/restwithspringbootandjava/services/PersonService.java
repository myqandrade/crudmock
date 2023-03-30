package br.com.mike.myqandrade.restwithspringbootandjava.services;

import br.com.mike.myqandrade.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.mike.myqandrade.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.mike.myqandrade.restwithspringbootandjava.mapper.DozerMapper;
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
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity, PersonVO.class);

    }

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO personVO){
        var entity = DozerMapper.parseObject(personVO, Person.class);
        personRepository.save(entity);
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO personVO){
        var person = personRepository.findById(personVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        person.setFirstName(personVO.getFirstName());
        person.setLastName(personVO.getLastName());
        person.setAddress(personVO.getAddress());
        person.setGender(personVO.getGender());
        personRepository.save(person);

        return DozerMapper.parseObject(person, PersonVO.class);
    }

    public void delete(Long id){
        Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }



}
