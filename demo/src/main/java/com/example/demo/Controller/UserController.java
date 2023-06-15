package com.example.demo.Controller;


import com.example.demo.Model.User;
import com.example.demo.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UsuarioService usuarioService;

    @Autowired
    public UserController(UsuarioService usuarioService) {this.usuarioService = usuarioService;}

    @GetMapping(value = "/usuarios")
    public List<User> getUsers(){
        return usuarioService.getUsers();
    }

    //    @PostMapping(value = "/guardarproducto")
//    public String guardarProducto(@RequestBody Producto producto){
//        productoService.sa
//    }
    @PostMapping
    public void registerNewUser(@RequestBody User user){
        usuarioService.addNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        usuarioService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String password){
        usuarioService.updateUser(userId,
                email,
                password);
    }
}
