package gestion.users.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestion.users.apirest.servicio.*;
import gestion.users.apirest.entity.*;
import gestion.users.apirest.apiresponse.ApiResponse;

@RestController
@RequestMapping("/api") //http://localhost:8080/api
public class UsuarioController {
	
	@Autowired
	private ServicioUsuario userServicio;
	
	@GetMapping("/usuarios")
	public ResponseEntity<ApiResponse<List<Usuario>>> findAll() {
	    List<Usuario> usuarios = userServicio.findAll();
	    ApiResponse<List<Usuario>> response;

	    if (!usuarios.isEmpty()) {
	        response = new ApiResponse<>("success", 200, "Estos son todos los usuarios actualmente.", usuarios);
	        return ResponseEntity.ok(response);
	    } else {
	        response = new ApiResponse<>("not success", 500, "Error al leer los usuarios.", null);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }
	}
	
	@GetMapping("/usuarios/{idUsuario}")
	public ResponseEntity<ApiResponse<Usuario>> getUser(@PathVariable int idUsuario) {
	    Usuario user = userServicio.findById(idUsuario);

	    if (user == null) {
	        ApiResponse<Usuario> response = new ApiResponse<>("not success", 404, "No existe el usuario " + idUsuario, null);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	    
	    ApiResponse<Usuario> response = new ApiResponse<>("success", 200, "Usuario encontrado", user);
	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("/usuarios")
    public ResponseEntity<ApiResponse<Usuario>> addUser(@RequestBody Usuario user) {
	    user.setId(0);
	    userServicio.create(user);
	    ApiResponse<Usuario> response = new ApiResponse<>("success", 201, "Usuario creado correctamente", user);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping("/updateusuarios")
    public ResponseEntity<ApiResponse<Usuario>> updateUser(@RequestBody Usuario user) {
	    userServicio.update(user);
	    ApiResponse<Usuario> response = new ApiResponse<>("success", 200, "Usuario actualizado correctamente", user);
	    return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/usuarios/{idUsuario}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable int idUsuario) {
	    Usuario tempUser = userServicio.findById(idUsuario);
	    if (tempUser == null) {
	        ApiResponse<String> response = new ApiResponse<>("not success", 404, "No existe el usuario " + idUsuario, null);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	    userServicio.deletedById(idUsuario);
	    ApiResponse<String> response = new ApiResponse<>("success", 200, "Usuario eliminado con id - " + idUsuario, null);
	    return ResponseEntity.ok(response);
	}
	
}
