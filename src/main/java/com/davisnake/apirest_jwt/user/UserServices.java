package com.davisnake.apirest_jwt.user;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository; 

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {
       
        User user = User.builder()
        .id(userRequest.id)
        .firstName(userRequest.getFirstName())
        .lastName(userRequest.lastName)
        .country(userRequest.getCountry())
        .role(Role.USER)
        .build();
        
        Integer resultado = userRepository.updateUser(user.id, user.firstName, user.lastName, user.country);

        if (resultado == 0){
            
            return new UserResponse("El usuario no se encuentra registrado");
        }

        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    public UserDTO getUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
       
        if (user!=null)
        {
            UserDTO userDTO = UserDTO.builder()
            .id(user.id)
            .username(user.userName)
            .firstname(user.firstName)
            .lastname(user.lastName)
            .country(user.country)
            .build();
            return userDTO;
        }
        return null;
    }
}
