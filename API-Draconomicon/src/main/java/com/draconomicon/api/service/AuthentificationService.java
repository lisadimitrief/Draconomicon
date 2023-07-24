// package com.draconomicon.api.service;

// import java.util.HashSet;

// import org.hibernate.mapping.Set;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import com.draconomicon.api.model.Role;
// import com.draconomicon.api.model.User;
// import com.draconomicon.api.repository.RoleRepository;
// import com.draconomicon.api.repository.UserRepository;


// @Service
// @Transactional
// public class AuthentificationService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private RoleRepository roleRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     public User registerUser(String username, String password){
//         String encodedPassword = passwordEncoder.encode(password);
//         Role userRole = roleRepository.findByAuthority("USER").get();

//         Set<Role> authorities = new HashSet<>();

//         authorities.add(userRole);
        
//         return userRepository.save(new User(0, username, encodedPassword, authorities));
//     }
// }
