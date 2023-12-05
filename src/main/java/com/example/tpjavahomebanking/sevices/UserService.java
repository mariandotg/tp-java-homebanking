package com.example.tpjavahomebanking.sevices;

import com.example.tpjavahomebanking.exceptions.UserNotExistsException;
import com.example.tpjavahomebanking.exceptions.UserNotFoundException;
import com.example.tpjavahomebanking.mappers.UserMapper;
import com.example.tpjavahomebanking.models.User;
import com.example.tpjavahomebanking.models.dtos.UserDTO;
import com.example.tpjavahomebanking.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }




    public List<UserDTO> getUsers(){
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserMapper::userToDto)
                .collect(Collectors.toList());
    }





        public UserDTO getUserById(Long id) {
            User user = repository.findById(id).orElseThrow(() ->
                    new UserNotFoundException("Usuario no se encuentra con el id: " + id));
            return UserMapper.userToDto(user);

        }




    public UserDTO createUser(UserDTO userDto){
        User userValidEmail = validateUserByEmail(userDto);

        if (userValidEmail == null){
            User userSaved = repository.save(UserMapper.dtoToUser(userDto));
            return UserMapper.userToDto(userSaved);
        } else{
            throw new UserNotExistsException("Usuario con mail: " + userDto.getEmail() + " ya existe");
        }




    }




    public String deleteUser(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "El usuario con id: " + id + " ha sido eliminado";
        } else {
            throw new UserNotExistsException("El usuario a eliminar elegido no existe");
        }


    }


    public UserDTO updateUser(Long id, UserDTO dto) {
        if (repository.existsById(id)){
            User userToModify = repository.findById(id).get();

            if (dto.getName() != null){
                userToModify.setName(dto.getName());
            }


            if (dto.getEmail() != null){
                userToModify.setEmail(dto.getEmail());
            }

            if (dto.getPassword() != null){
                userToModify.setPassword(dto.getPassword());
            }

            if (dto.getDni() != null){
                userToModify.setDni(dto.getDni());
            }


            if (dto.getDate() != null){
                userToModify.setDate(dto.getDate());
            }

            if (dto.getDirection() != null){
                userToModify.setDirection(dto.getDirection());
            }

            if (dto.getCount() != null){
                userToModify.setCount(dto.getCount());
            }


            User userModified = repository.save(userToModify);

            return UserMapper.userToDto(userModified);
        }

        return null;
    }

    public User validateUserByEmail(UserDTO dto){

        return repository.findByEmail(dto.getEmail());


    }

    public User validateUserByDni(UserDTO dto){

        return repository.findByDni(dto.getDni());


    }





}