package com.example.springjpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getPerson(){
        System.out.println(personRepository.findAll());
        return personRepository.findAll();
    }


    @GetMapping("/personsByNativeQuery")
    public List<Person> getPersonCustNativeQuery(){
        return personRepository.findAllWithCustomNativeQuery();
    }

    @GetMapping("/personsByNamedQuery")
    public List<Person> getPersonCust(){
        return personRepository.findAllWithCustomNamedQuery();
    }

    @GetMapping("/personByName/{name}/{id}")
    public Person getPersonByName(@PathVariable String name, @PathVariable int id){
        return personRepository.findPersonByNameAndId(name, id);
    }



    @GetMapping("/personById/{id}")
    public Optional<Person> getPersonById(@PathVariable int id){
        System.out.println(personRepository.findById(id));
        return personRepository.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id){
         personRepository.deleteById(id);
    }

}
