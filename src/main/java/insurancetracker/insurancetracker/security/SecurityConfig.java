package insurancetracker.insurancetracker.security;


import insurancetracker.insurancetracker.service.UserService.UserService;
import insurancetracker.insurancetracker.service.UserService.UserServicesImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserServicesImpl userService;
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers("/Auth/" , "/Auth/login" , "Auth/register").permitAll()
                .antMatchers("/users/**").hasRole("ROLE_USER")
                .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().
                loginPage("Auth/login")
                .loginProcessingUrl("/Auth/login")
                .failureUrl("/Auth/login?error=true")
                .permitAll()
                .successHandler((request, response, authentication) -> {
                    String username = authentication.getName();
                    String redirectUrl = determineRedirectUrl(authentication);
//                    HttpServletResponse httpResponse = (HttpServletResponse) response;
//                    httpResponse.sendRedirect(redirectUrl);
                })
                .failureUrl("/Auth/login?error=true")
                .and()
                .logout()
                .logoutUrl("Auth/logout")
                .logoutSuccessUrl("Auth/")
                .permitAll()
                .and()
                .sessionManagement()
                .sessionFixation()
                .none();
    }

    private String determineRedirectUrl(org.springframework.security.core.Authentication authentication) {
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "/admin/dashboard";
        }
        return "/users/dashboard";
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return (PasswordEncoder) new BCryptPasswordEncoder();
    }
}
