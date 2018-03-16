/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.compras.web.security;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
/**
 *
 * @author leonardo.aedo
 */
public class MyAuthenticationProvider implements AuthenticationProvider {
 
    private UserDetailsService userDetailsService;
 
    public void setUserDetailsService(UserDetailsService userDetailsService) {
 
        this.userDetailsService = userDetailsService;
    }
 
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
 
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authentication.getName());
        try {
        if (userDetails != null && userDetails.getPassword().equals("admin")) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
            if ("admin".compareToIgnoreCase(authentication.getName()) == 0 && "admin".compareToIgnoreCase(authentication.getCredentials().toString().trim()) == 0 ) {
            return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        }
        } catch (Exception e) {
        }
        
        throw new BadCredentialsException("Bad credentials");
    }

    @Override
    public boolean supports(Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}