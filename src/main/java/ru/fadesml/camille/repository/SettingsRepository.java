package ru.fadesml.camille.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.camille.entity.Settings;

public interface SettingsRepository extends JpaRepository<Settings, String> {
}
