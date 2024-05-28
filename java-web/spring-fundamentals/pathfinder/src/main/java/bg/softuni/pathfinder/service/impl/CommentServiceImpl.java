package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.repository.CommentRepository;
import bg.softuni.pathfinder.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CategoryService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
