package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.repository.PictureRepository;
import bg.softuni.pathfinder.service.PictureService;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }
}
