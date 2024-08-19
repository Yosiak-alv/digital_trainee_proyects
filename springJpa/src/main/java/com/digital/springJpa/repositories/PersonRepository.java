package com.digital.springJpa.repositories;

import com.digital.springJpa.dto.PersonDto;
import com.digital.springJpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    //the table name is persons, but we use the class name Person in the query
    //hql is the query language of hibernate

    @Query("select p from Person p where p.id in ?1")
    List<Person> findAllByIds(List<Long> ids);

    @Query("select p.name, length(p.name) from Person p where length(p.name) = (select min(length(p.name)) from Person p)")
    List<Object[]> findShortestName();

    @Query("select p from Person p where p.id= (select max(p.id) from Person p)")
    Optional<Person> findLastPerson();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
    Object[] getResumeAggregation();

    @Query("select min(length(p.name)) from Person p")
    Integer getMinLengthName();

    @Query("select max(length(p.name)) from Person p")
    Integer getMaxLengthName();

    @Query("select p.name, length(p.name) from Person p")
    List<Object[]> getPersonNameLength();

    @Query("select count(p.id) from Person p")
    Long getTotalPersons();

    @Query("select min(p.id) from Person p")
    Long getMinId();

    @Query("select max(p.id) from Person p")
    Long getMaxId();

    List<Person> findAllByOrderByNameAscLastnameDesc();

    @Query("select p from Person p order by p.name, p.lastname desc")
    List<Person>getAllOrdered();

    List<Person> findByIdBetweenOrderByNameAsc(Long id1, Long id2);

    List<Person> findByNameBetweenOrderByNameDescLastnameDesc(String name1, String name2);

    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name desc")
    List<Person> findAllBetweenId(Long id1, Long id2);

    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name desc, p.lastname desc")
    List<Person> findAllBetweenName(String name1, String name2);

    @Query("select p.id, upper(p.name), lower(p.lastname), upper(p.programmingLanguage) from Person p")
    List<Object[]> findAllPersonDataListCase();

    @Query("select upper(p.name || ' ' || p.lastname) from Person p")
    List<String> findAllFullNameConcatUpper();

    @Query("SELECT lower(p.name || ' ' || p.lastname) FROM Person p")
    List<String> findAllFullNameConcatLower();

    @Query("select p.name || ' ' || p.lastname from Person p")
    List<String> findAllFullNameConcat();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long countDistinctProgrammingLanguage();

    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select new com.digital.springJpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllPersonDto();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    @Query("select p.name from Person p where p.id = ?1")
    String getNameById(Long id);

    @Query("select p.id from Person p where p.id = ?1")
    Long getIdById(Long id);

    @Query("select CONCAT(p.name, ' ', p.lastname) as fullname from Person p where p.id = ?1")
    String getFullNameById(Long id);

    @Query("select p from Person p where p.id = ?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name = ?1")
    Optional<Person> findOneName(String name);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByNameContaining(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("select p from Person p where p.programmingLanguage = ?1 and p.name = ?2")
    List<Person> searchByProgrammingLanguage(String programmingLanguage, String name);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);

    @Query("select p from Person p where p.id = ?1")
    Optional<Object> oftenerPersonDataById(Long id);

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> oftenerPersonData();

    @Query("select p.name, p.programmingLanguage from Person p where p.name = ?1")
    List<Object[]> oftenerPersonData(String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage = ?1")
    List<Object[]> oftenerPersonDataByProgrammingLanguage(String programmingLanguage);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage = ?1 and p.name = ?2")
    List<Object[]> oftenerPersonData(String programmingLanguage, String name);
}
