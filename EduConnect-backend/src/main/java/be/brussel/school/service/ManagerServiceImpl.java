package be.brussel.school.service;

import be.brussel.school.model.Manager;
import be.brussel.school.repository.ManagerRepository;
import be.brussel.school.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<Manager> getManagerById(Long id) {
        return managerRepository.findById(id);
    }

    @Override
    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager updateManager(Long id, Manager manager) {
        if (managerRepository.existsById(id)) {
            manager.setId(id);
            return managerRepository.save(manager);
        }
        return null;
    }

    @Override
    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }
}
