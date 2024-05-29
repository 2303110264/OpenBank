package kopo.aisw.hc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers(new AntPathRequestMatcher("/member/signIn")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/member/signUp")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/member/jusoPopup")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("/public/**")).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/member/signIn")
                .defaultSuccessUrl("/bank/", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/member/logout")
                .logoutSuccessUrl("/member/signIn?logout")
                .permitAll()
            );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
