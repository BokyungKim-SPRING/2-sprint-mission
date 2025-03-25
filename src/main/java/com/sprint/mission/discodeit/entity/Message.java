package com.sprint.mission.discodeit.entity;

import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final Instant createdAt;
    private Instant updatedAt;
    //
    private String content;
    //
    private final UUID channelId;
    private final UUID authorId;
    private List<UUID> attachmentIds;

    public Message(String content, UUID channelId, UUID authorId) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        //
        this.content = content;
        this.channelId = channelId;
        this.authorId = authorId;
        this.attachmentIds = new ArrayList<>();
    }

    public void update(String newContent) {
        boolean anyValueUpdated = false;
        if (newContent != null && !newContent.equals(this.content)) {
            this.content = newContent;
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            this.updatedAt = Instant.now();
        }
    }

    public void addAttachment(UUID attachmentId) {
        if (attachmentId != null && !this.attachmentIds.contains(attachmentId)) {
            this.attachmentIds.add(attachmentId);
            this.updatedAt = Instant.now();
        }
    }
}
