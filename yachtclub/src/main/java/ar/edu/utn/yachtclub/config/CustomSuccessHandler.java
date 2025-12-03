package ar.edu.utn.yachtclub.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();

        for (GrantedAuthority auth : roles) {

            // ROLE_ADMIN → "admin"
            String role = auth.getAuthority().replace("ROLE_", "").toLowerCase();

            // Redirección dinámica (ADMIN → /admin/menu)
            response.sendRedirect("/" + role + "/menu");
            return;
        }

        response.sendRedirect("/login?error");
    }
}

