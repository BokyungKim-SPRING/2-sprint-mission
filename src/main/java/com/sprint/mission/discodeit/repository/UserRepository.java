package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    User findById(UUID userId);
    List<User> findAll();
    User update(User user);
    void delete(UUID userId);
    boolean exists(UUID userId);
}
