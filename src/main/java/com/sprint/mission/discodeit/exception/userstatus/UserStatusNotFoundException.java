package com.sprint.mission.discodeit.exception.userstatus;

import com.sprint.mission.discodeit.exception.ErrorCode;

import java.util.Map;
import java.util.UUID;

public class UserStatusNotFoundException extends UserStatusException {

    public UserStatusNotFoundException(UUID userId) {
        super(ErrorCode.USER_STATUS_NOT_FOUND, Map.of("userId", userId));
    }
}