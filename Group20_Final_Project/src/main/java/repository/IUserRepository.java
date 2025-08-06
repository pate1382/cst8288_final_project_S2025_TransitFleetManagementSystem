package repository;

import entities.User;
import java.util.List;

/**
 * DAO interface for User operations.
 * 
 * @author Sarthak
 */
public interface IUserRepository {
    List<User> getAllUsers();
    User getUserById(int id);
    User authenticate(String email, String password);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
