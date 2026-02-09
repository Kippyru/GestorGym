package com.gym.GestorGym.security;

import com.gym.GestorGym.models.Persona;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;public class PersonaUserDetail implements UserDetails {

    private final Persona persona;

    public PersonaUserDetail(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + persona.getIdRol().getNombre()));
    }

    @Override
    public String getUsername() {
        return persona.getEmail();
    }

    @Override public String getPassword() {
        return persona.getContraseña();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}