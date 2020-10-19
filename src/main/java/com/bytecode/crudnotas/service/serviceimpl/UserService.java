package com.bytecode.crudnotas.service.serviceimpl;

import com.bytecode.crudnotas.entity.UserRole;
import com.bytecode.crudnotas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.bytecode.crudnotas.entity.Usuario user = userRepository.findByusuario(username);

        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());

        return userBuild(user, authorities);
    }

    private User userBuild(com.bytecode.crudnotas.entity.Usuario usuario, List<GrantedAuthority> authorities){
        return new User(usuario.getUsuario(), usuario.getContra(), usuario.isDisponible(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRole){
        Set<GrantedAuthority> auth = new HashSet<GrantedAuthority>();

        for (UserRole userRoles : userRole){
            auth.add(new SimpleGrantedAuthority(userRoles.getRole()));
        }

        return new ArrayList<GrantedAuthority>(auth);
    }
}
