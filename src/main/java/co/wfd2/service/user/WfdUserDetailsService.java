package co.wfd2.service.user;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.wfd2.service.entity.user.User;
import co.wfd2.util.Role;

/**
 *
 */
@Service
public class WfdUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public WfdUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    /**
     *
     * @param userName the username identifying the user whose data is required.
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.getByUsername(userName);
        List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }

    /**
     *
     * @param userRole
     * @return
     */
    private List<GrantedAuthority> getUserAuthority(Role userRole) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
            roles.add(new SimpleGrantedAuthority(userRole.name()));
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    /**
     *
     * @param user
     * @param authorities
     * @return
     */
    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                user.getActive(), true, true, true, authorities);
    }
}