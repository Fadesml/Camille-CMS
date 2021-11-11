package ru.fadesml.camille.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.fadesml.camille.entity.Settings;
import ru.fadesml.camille.entity.SystemMessage;
import ru.fadesml.camille.messages.SystemMessageCode;
import ru.fadesml.camille.exceptions.NotFoundException;
import ru.fadesml.camille.repository.SettingsRepository;
import ru.fadesml.camille.repository.SystemMessageRepository;
import ru.fadesml.camille.services.CacheService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
class CacheServiceImpl implements CacheService {
    private final Long timerPeriod;
    private final SettingsRepository settingsRepository;
    private final SystemMessageRepository systemMessageRepository;
    private final Logger logger;

    private Settings cachedSettings;
    private final Map<String, String> messages = new HashMap<>();

    public CacheServiceImpl(@Value("${app.timer.cache}") Long timerPeriod,
                            SettingsRepository settingsRepository,
                            SystemMessageRepository systemMessageRepository) {
        this.timerPeriod = timerPeriod;
        this.settingsRepository = settingsRepository;
        this.systemMessageRepository = systemMessageRepository;
        this.logger = Logger.getLogger(CacheService.class.getName());
    }

    @PostConstruct
    public void postConstruct() {
        updateCache();
    }

    @Override
    public void updateCache() {
        try {
            updateMessages();
            updateSettings();
        } catch (Exception e) {
            logger.warning("Can't update cache! Exception: " + e.getMessage());
        }
    }

    @Override
    public Settings getSettings() {
        if (this.cachedSettings != null) {
            return new Settings(this.cachedSettings);
        }

        throw new NotFoundException(Settings.class, Map.of("SETTINGS MAIN", "null"));
    }

    @Override
    public String getMessage(SystemMessageCode code) {
        return getMessage(code.name());
    }

    @Override
    public String getMessage(String code) {
        if (this.messages.containsKey(code)) {
            return this.messages.get(code);
        }

        throw new NotFoundException(SystemMessage.class, Map.of("code", code));
    }

    @Override
    public void updateSettings() {
        this.cachedSettings = settingsRepository.findById("MAIN").orElse(this.cachedSettings);
    }

    @Override
    public void updateMessages() {
        systemMessageRepository.findAll().forEach(message -> {
            if (messages.containsKey(message.getId()) &&
                    message.getAnswer() != null &&
                    !message.getAnswer().equals(messages.get(message.getId()))) {
                messages.replace(message.getId(), message.getAnswer());
            } else {
                messages.put(message.getId(), message.getAnswer());
            }
        });
    }

    @Override
    public Long getTimerPeriod() {
        return timerPeriod;
    }
}