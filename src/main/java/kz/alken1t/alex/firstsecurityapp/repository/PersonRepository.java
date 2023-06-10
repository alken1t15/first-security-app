package kz.alken1t.alex.firstsecurityapp.repository;

import kz.alken1t.alex.firstsecurityapp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByUsername(String username);
}