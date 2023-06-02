package com.example.demo.repositories;

import com.example.demo.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// PersonRepository => interface
//@RepositoryRestResource(collectionResourceRel = "people", path = "people") // 리소스 타입 상태로 : 이름, 경로를 보여줌
public interface PersonRepository extends PagingAndSortingRepository<Person, Long>, CrudRepository<Person, Long> {
    List<Person> findByLastName(@Param("name") String name); // LastName function => parameter "name"
}
