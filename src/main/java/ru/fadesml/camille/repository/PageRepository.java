package ru.fadesml.camille.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fadesml.camille.entity.Page;

import java.util.Optional;

public interface PageRepository extends JpaRepository<Page, Long> {
    Optional<Page> findByPath(String path);
}
