package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.MessageRepository;

import java.util.*;

public class JCFMessageRepository implements MessageRepository {
    private final Map<UUID, Message> data = new HashMap<>();

    @Override
    public Message save(Message message) {
        data.put(message.getAuthorId(), message);
        return message;
    }

    @Override
    public Message findById(UUID messageId) {
        Message messageNullable = this.data.get(messageId);
        return Optional.ofNullable(messageNullable)
                .orElseThrow(() -> new NoSuchElementException("Message with id " + messageId + " not found"));
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Message update(Message message) {
        if (!this.data.containsKey(message.getId())) {
            throw new NoSuchElementException("Message with id " + message.getId() + " not found");
        }
        this.data.put(message.getId(), message);
        return message;
    }

    @Override
    public void delete(UUID messageId) {
        if (!this.data.containsKey(messageId)) {
            throw new NoSuchElementException("Message with id " + messageId + " not found");
        }
        this.data.remove(messageId);
    }

    @Override
    public boolean exists(UUID messageId) {
        return false;
    }
}
