package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.models.Model;
import bg.softuni.mobilelele.repository.ModelRepository;
import bg.softuni.mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model getById(Long id) {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public List<Model> getAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public void delete(Long id) {
        modelRepository.deleteById(id);
    }
}
