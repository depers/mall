package main.java.cn.bravedawn.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetailsServiceDAO implements UserDetailsService {

    private final Log log = LogFactory.getLog(AppUserDetailsServiceDAO.class);

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername username = " + username);

        if (!username.equals("pankaj")) {
            throw new UsernameNotFoundException(username + " not found.");
        }

        // creating dummy user details, should do JDBC operations
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new ArrayList<>();
                auths.add(new SimpleGrantedAuthority("admin"));
                return auths;
            }

            @Override
            public String getPassword() {
                return "pankaj123";
            }

            @Override
            public String getUsername() {
                return username;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

    }
}
