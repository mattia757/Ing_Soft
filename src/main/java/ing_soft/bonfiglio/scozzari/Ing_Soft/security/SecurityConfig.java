package ing_soft.bonfiglio.scozzari.Ing_Soft.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(withDefaults())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/api/user/**").authenticated();
                    auth.requestMatchers("/").permitAll();
                    auth.anyRequest().authenticated();
                })
                /*.formLogin(formLogin ->
                        formLogin
                                //.loginPage("/auth")
                                .defaultSuccessUrl("/dashboard")
                                .permitAll()
                )*/
                .logout(logout ->
                        logout
                                //.logoutSuccessUrl("/auth")
                                .permitAll()
                )
                .build();
    }

    //TODO Implementare il custom login e il custom logout

}
