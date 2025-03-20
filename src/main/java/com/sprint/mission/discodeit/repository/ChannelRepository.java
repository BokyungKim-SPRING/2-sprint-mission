package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface ChannelRepository {
    Channel save(Channel channel);
    Channel findById(UUID channelId);
    List<Channel> findAll();
    Channel update(Channel channel);
    void delete(UUID channelId);
    boolean exists(UUID channelId);
    boolean existsById(UUID channelId);
}
