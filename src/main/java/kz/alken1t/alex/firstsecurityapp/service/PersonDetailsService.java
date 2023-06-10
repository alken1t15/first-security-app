package kz.alken1t.alex.firstsecurityapp.service;

import kz.alken1t.alex.firstsecurityapp.repository.PersonRepository;
import kz.alken1t.alex.firstsecurityapp.security.PersonDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PersonDetailsService implements UserDetailsService {
    public final PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository.findByUsername(username).map(PersonDetails::new).orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }
}
