package ar.edu.utn.yachtclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//Configura el login en /login y redirige a /index tras autenticarse. 
//🧑‍💼 Admin //Usuario: admin //Contraseña: admin123 // 
//👷 Empleados //Usuario: empleado1 //Contraseña: emp123 // 
//👤 Socios //Usuario: juanp //Contraseña: 123
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                // páginas públicas
                .requestMatchers("/", "/index", "/login", "/css/**", "/js/**", "/images/**").permitAll()
                // SOCIO solo sus datos y embarcaciones
                .requestMatchers("/socios/mis-datos").hasRole("SOCIO")
                .requestMatchers("/embarcaciones/mias").hasRole("SOCIO")
                // ADMIN y EMPLEADO rutas compartidas
                .requestMatchers("/socios/**").hasAnyRole("ADMIN", "EMPLEADO")
                .requestMatchers("/embarcaciones/**").hasAnyRole("ADMIN", "EMPLEADO")
                // EMPLEADO solo sus zonas
                .requestMatchers("/empleadozona/mis-zonas").hasRole("EMPLEADO")
                .requestMatchers("/zonas/mia").hasRole("EMPLEADO")
                // ADMIN solo
                .requestMatchers("/amarres/**", "/zonas/**", "/empleados/**", "/compras/**").hasRole("ADMIN")
                .requestMatchers("/usuarios/**").hasRole("ADMIN")
                .requestMatchers("/empleadozona/nuevo", "/empleadozona/lista",
                        "/empleadozona/editar/**", "/empleadozona/eliminar/**").hasRole("ADMIN")
                // cualquier otra ruta requiere login
                .anyRequest().authenticated()
                )
                .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/index", true)
                .permitAll()
                )
                .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                );

        return http.build();
    }
}
