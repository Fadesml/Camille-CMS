package ru.fadesml.camille.services;

import ru.fadesml.camille.dto.PageDto;
import ru.fadesml.camille.entity.Page;

import java.util.List;

public interface PageService {
    /**
     * @return List of all page entities
     */
    List<Page> getAllPageEntities();

    /**
     * @return List of all page dtos
     */
    List<PageDto> getAllPageDtos();

    /**
     * @param id - identifier of page entity
     * @return Page entity
     */
    Page getPage(Long id);

    /**
     * @param path - path field of page entity
     * @return Page entity
     */
    Page getPage(String path);

    /**
     * @param id - identifier of page entity
     * @return Html string converted from page entity
     */
    String getPageHtml(Long id);

    /**
     * @param path - path field of page entity
     * @return Html string converted from page entity
     */
    String getPageHtml(String path);
}
