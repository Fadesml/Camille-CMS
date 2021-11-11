package ru.fadesml.camille.services;

import ru.fadesml.camille.entity.Settings;
import ru.fadesml.camille.messages.SystemMessageCode;

public interface CacheService {
    void updateCache();

    Settings getSettings();

    String getMessage(SystemMessageCode code);

    String getMessage(String code);

    void updateSettings();

    void updateMessages();

    Long getTimerPeriod();
}
