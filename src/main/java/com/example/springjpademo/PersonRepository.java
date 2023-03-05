package com.example.springjpademo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value ="select * from Person p where id in (1,2)", nativeQuery = true )
    List<Person> findAllWithCustomNativeQuery();

    @Query(name ="custom_person_select")
    List<Person> findAllWithCustomNamedQuery();

    Person findPersonByNameAndId(String name, int id);
}
