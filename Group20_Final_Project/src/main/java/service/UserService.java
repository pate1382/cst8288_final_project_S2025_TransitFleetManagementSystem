package service;

import entities.User;
import repository.IUserRepository;
import repository.impl.UserRepositoryImpl;

/**
 * Service layer for user-related operations.
 * 
 * @author Sarthak
 */
public class UserService {

    private final IUserRepository userRepo = new UserRepositoryImpl();

    /**
     * Authenticates user credentials.
     * 
     * @param email user email
     * @param password user password
     * @return User object if valid, else null
     */
    public User login(String email, String password) {
        return userRepo.authenticate(email, password);
    }

    public boolean registerUser(User user) {
        return userRepo.addUser(user);
    }
}
