package br.com.fabio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fabio.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
