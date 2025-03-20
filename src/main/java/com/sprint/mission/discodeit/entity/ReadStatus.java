package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class ReadStatus implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final Instant createdAt;
    private Instant updatedAt;

    private final UUID userId;
    private final UUID channelId;
    private Instant lastReadAt;

    public ReadStatus(UUID userId, UUID channelId) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.userId = userId;
        this.channelId = channelId;
        this.lastReadAt = null;
    }

    public void updateLastReadAt(Instant newLastReadAt) {
        if (newLastReadAt != null && (this.lastReadAt == null || newLastReadAt.isAfter(this.lastReadAt))) {
            this.lastReadAt = newLastReadAt;
            this.updatedAt = Instant.now();
        }
    }

}
