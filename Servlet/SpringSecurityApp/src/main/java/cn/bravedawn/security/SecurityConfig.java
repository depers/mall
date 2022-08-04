package main.java.cn.bravedawn.security;

import main.java.cn.bravedawn.dao.AppUserDetailsServiceDAO;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * 配置三种认证方式
         */
        // in-memory authentication
        //auth.inMemoryAuthentication().withUser("pankaj").password("pankaj123").roles("USER");

        // using custom UserDetailsService DAO
        //auth.userDetailsService(new AppUserDetailsServiceDAO());

        // using JDBC
        //Context ctx = new InitialContext();
        //DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/server/userDB");
        //
        //final String findUserQuery = "select username, password, enabled from Employees where username = ?";
        //final String findRoles = "select username, role from Roles where username = ?";
        //
        //auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery(findUserQuery).authoritiesByUsernameQuery(findRoles);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*.html");
    }
}
