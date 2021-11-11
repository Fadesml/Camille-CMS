package ru.fadesml.camille.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.camille.entity.SystemMessage;

public interface SystemMessageRepository extends JpaRepository<SystemMessage, String> {
}
