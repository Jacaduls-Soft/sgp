package controller;

import entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.ServUsuario;

import java.util.List;

@RestController  //Peticion por medio Json
public class UsuarioControler {
    @Autowired
    private ServUsuario usuarioService;

    @GetMapping("usuario")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        return new ResponseEntity<List<Usuario>>(
                usuarioService.getUsuarios(),
                HttpStatus.OK
        );
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Object>getUsuarios(@PathVariable String id){
        try {
            Usuario usuario= usuarioService.getUsuario(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/usuario")
    public ResponseEntity<Object>getUsuario(@RequestParam String id){
    try {
        Usuario usuario= usuarioService.getUsuario(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
