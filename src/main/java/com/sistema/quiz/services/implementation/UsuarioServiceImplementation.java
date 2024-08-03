package com.sistema.quiz.services.implementation;

import com.sistema.quiz.entities.Usuario;
import com.sistema.quiz.entities.UsuarioRol;
import com.sistema.quiz.repositories.RolRepository;
import com.sistema.quiz.repositories.UsuarioRepository;
import com.sistema.quiz.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository  rolRepository;


    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if (usuarioLocal != null){
            System.out.println("El usuaro ya existe");
            throw new Exception("El usuario ya esta presente");
        }else {
            for (UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return null;
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {

    }
}
