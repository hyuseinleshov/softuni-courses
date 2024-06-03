package bg.softuni.mobilelele.service;

import bg.softuni.mobilelele.model.Model;

import java.util.List;

public interface ModelService {
    Model getById(Long id);
    List<Model> getAll();
    Model save(Model model);
    void delete(Long id);
}
