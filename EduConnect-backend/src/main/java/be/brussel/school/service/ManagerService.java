package be.brussel.school.service;

import be.brussel.school.model.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    List<Manager> getAllManagers();
    Optional<Manager> getManagerById(Long id);
    Manager saveManager(Manager manager);
    Manager updateManager(Long id, Manager manager);
    void deleteManager(Long id);
}
