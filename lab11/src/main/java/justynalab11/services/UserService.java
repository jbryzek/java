package justyna.lab11.services;

import justyna.lab11.models.User;
import justyna.lab11.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> list(){
        return (List<User>) userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
