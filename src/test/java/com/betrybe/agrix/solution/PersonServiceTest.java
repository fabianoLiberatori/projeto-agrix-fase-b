package com.betrybe.agrix.solution;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.h2.command.dml.MergeUsing.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PersonServiceTest {

  @Mock
  private PersonRepository personRepository;

  @InjectMocks
  private PersonService personService;

  private Person person;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    person = new Person();
    person.setId(1L);
    person.setUsername("NormalUser");
    person.setPassword("userPass");
    person.setRole(Role.USER);
  }

  @Test
  void getPersonById() {
    when(personRepository.findById(1L)).thenReturn(Optional.of(person));

    Person personTest = personService.getPersonById(1L);

    assertNotNull(personTest);
    assertEquals(person.getId(), personTest.getId());
  }

  @Test
  void personNotFoundById() {
    when(personRepository.findById(1L)).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonById(1L));
  }

  @Test
  void getPersonByName() {
    when(personRepository.findByUsername("NormalUser")).thenReturn(Optional.of(person));

    Person personTest = personService.getPersonByUsername("NormalUser");

    assertNotNull(personTest);
    assertEquals(person.getUsername(), personTest.getUsername());
  }

  @Test
  void personNotFoundByName() {
    when(personRepository.findByUsername("NormalUser")).thenReturn(Optional.empty());

    assertThrows(PersonNotFoundException.class, () -> personService.getPersonByUsername("NormalUser"));
  }

}
