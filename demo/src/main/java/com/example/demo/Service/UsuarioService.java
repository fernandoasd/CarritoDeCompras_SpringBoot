package com.example.demo.Service;

import com.example.demo.Model.Product;
import com.example.demo.Model.User;
import com.example.demo.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<User> getUsers(){
        return usuarioRepository.findAll();
    }

    public void addNewUser(User user){
        Optional<User> userByEmail = usuarioRepository.
                findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("user email exits");
        }
        usuarioRepository.save(user);
        }

    public void deleteUser(Long userId) {
        Optional<User> exists = usuarioRepository.findById(userId);
        if (!exists.isPresent()){
            throw new IllegalStateException(
                    "product with id " + userId + " does not exists");
        }
        usuarioRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId, String email, String password) {
        User user = usuarioRepository.findById(userId).orElseThrow(() -> new IllegalStateException(
                "user with id " + userId + " does not exists"));

        if (email != null &&
                email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)){
            Optional<User> userByEmail = usuarioRepository.
                    findUserByEmail(email);
            if (userByEmail.isPresent()){
                throw new IllegalStateException("user exists");
            }
            user.setEmail(email);
        }
        if (password != null &&
                password.length() > 0 &&
                !Objects.equals(user.getPassword(), password)){
            user.setPassword(password);
        }
    }
}
