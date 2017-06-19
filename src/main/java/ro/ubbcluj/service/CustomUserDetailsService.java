package ro.ubbcluj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.ubbcluj.dao.UserDAO;
import ro.ubbcluj.domain.UserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Cosmin on 18-Jun-17.
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ro.ubbcluj.domain.User user = userDAO.getUserByEmail(email);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<UserRole> role) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (UserRole userRole : role) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

        return result;
    }

    private User buildUserForAuthentication(ro.ubbcluj.domain.User user, List<GrantedAuthority> authorities) {

        return new User(user.getEmail(), user.getPassword(), true, true, true, true, authorities);
    }
}