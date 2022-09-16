package services;

import entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsuarioRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ServUsuario{
    @Autowired
    private UsuarioRepo usuarioRepository;

    public List<Usuario>getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuario(String id) throws Exception {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){ // Efectivamente existe va = true
            return usuarioOptional.get();
        }else{
            throw new Exception("Usuario no Existe");
        }
    }
}
