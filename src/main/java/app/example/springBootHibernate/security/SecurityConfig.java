package app.example.springBootHibernate.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Разрешаем доступ к "/public" без авторизации
                .authorizeRequests()
                .antMatchers("/public").permitAll() // Публичный эндпоинт, доступен без авторизации
                .anyRequest().authenticated() // Все остальные запросы требуют авторизации
                .and()
                // Включаем стандартную форму логина
                .formLogin().permitAll() //  Даем доступ к странице логина без авторизации
                .and()
                // Настройка логина по умолчанию
                .logout().permitAll();// Даем доступ к странице логаута
    }
}

