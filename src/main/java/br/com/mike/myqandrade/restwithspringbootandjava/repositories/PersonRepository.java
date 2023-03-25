package br.com.mike.myqandrade.restwithspringbootandjava.repositories;

import br.com.mike.myqandrade.restwithspringbootandjava.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
