package com.example.double_db.repository;

import com.example.double_db.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private static final Person TEST_PERSON = new Person(1, "Alex", "Merser");



    @Test
    public void shouldCreatePersonProperly() {
        Person clone = TEST_PERSON;
        Person save = personRepository.save(clone);
        clone.setId(save.getId());

        Assertions.assertNotNull(save);
        assertThat(save)
                .usingRecursiveComparison()
                .isEqualTo(clone);
    }


    @Test
    public void shouldGetPersonProperly() {
        Person clone = TEST_PERSON;
        Person savedPerson = personRepository.save(TEST_PERSON);
        Optional<Person> possiblePerson = personRepository.findById(savedPerson.getId());

        Assertions.assertNotNull(
                possiblePerson.get());

        clone.setId(savedPerson.getId());

        assertThat(possiblePerson.get())
                .usingRecursiveComparison()
                .isEqualTo(TEST_PERSON);
    }

    @Test
    public void shouldGetListOfAllPersons() {
        Person clone = TEST_PERSON;
        Person savedPerson = personRepository.save(TEST_PERSON);
        clone.setId(savedPerson.getId());

        List<Person> persons = Arrays.asList(clone);
        List<Person> actualList = personRepository.findAll();

        Assertions.assertNotNull(
                actualList);

        Assertions.assertEquals(
                persons.size(), actualList.size());

        assertThat(actualList)
                .usingRecursiveComparison()
                .isEqualTo(persons);
    }


    @Test
    public void shouldRemovePersonProperly() {
        Person clone = TEST_PERSON;
        Person savedPerson = personRepository.save(TEST_PERSON);
        clone.setId(savedPerson.getId());

        assertThat(savedPerson)
                .usingRecursiveComparison()
                .isEqualTo(clone);

        personRepository.deleteById(savedPerson.getId());

        Optional<Person> possiblePerson = personRepository.findById(savedPerson.getId());

        Assertions.assertFalse(
                possiblePerson.isPresent());
    }


    @Test
    public void shouldProperlyUpdatePerson() {
        Person clone = TEST_PERSON;
        Person savedPerson = personRepository.save(clone);
        clone.setId(savedPerson.getId());

        assertThat(savedPerson)
                .usingRecursiveComparison()
                .isEqualTo(clone);

        clone.setName("Jack");
        clone.setSurname("Smith");
        Person updated = personRepository.save(clone);

        assertThat(updated)
                .usingRecursiveComparison()
                .isEqualTo(clone);
    }
}