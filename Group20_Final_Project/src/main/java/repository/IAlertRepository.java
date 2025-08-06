package repository;

import entities.AlertType;
import java.util.List;

/**
 * DAO interface for Alert Type operations.
 * 
 * @author Sarthak
 */
public interface IAlertRepository {
    List<AlertType> getAllAlertTypes();
    AlertType getAlertTypeById(int id);
}
