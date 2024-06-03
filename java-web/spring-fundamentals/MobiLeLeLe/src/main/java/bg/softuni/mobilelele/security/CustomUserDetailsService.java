package bg.softuni.mobilelele.security;

import bg.softuni.mobilelele.model.UserEntity;
import bg.softuni.mobilelele.model.UserRole;
import bg.softuni.mobilelele.model.enums.Role;
import bg.softuni.mobilelele.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class CustomUserDetailsService  implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        return new User(user.getUsername(), user.getPassword(), user.isActive(),
                true, true, true,
                mapRolesToAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(UserRole role) {
        Role roleName = role.getName();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName.name());
        return Collections.singletonList(authority);
    }
}
