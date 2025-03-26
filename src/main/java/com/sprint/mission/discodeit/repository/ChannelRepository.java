package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Channel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChannelRepository {
    Channel save(Channel channel);
    Optional<Channel> findById(UUID channelId);
    List<Channel> findAll();
    Channel update(Channel channel);
    void delete(UUID channelId);
    boolean existsById(UUID channelId);
}
