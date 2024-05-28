package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.repository.MessageRepository;
import bg.softuni.pathfinder.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
}
