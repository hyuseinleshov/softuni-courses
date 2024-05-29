package bg.softuni.pathfinder.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private User recipient;
}
