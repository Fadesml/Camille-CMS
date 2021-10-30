package ru.fadesml.camille.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fadesml.camille.dto.PageDto;
import ru.fadesml.camille.entity.Page;
import ru.fadesml.camille.exceptions.NotFoundException;
import ru.fadesml.camille.mappers.PageMapper;
import ru.fadesml.camille.repository.PageRepository;
import ru.fadesml.camille.services.PageService;

import java.util.List;

@Service
@RequiredArgsConstructor
class PageServiceImpl implements PageService {
    private final PageRepository repository;
    private final PageMapper mapper;

    public List<Page> getAllPageEntities() {
        return repository.findAll();
    }

    public List<PageDto> getAllPageDtos() {
        return mapper.toDto(getAllPageEntities());
    }

    @Override
    public Page getPage(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(Page.class, id.toString()));
    }

    @Override
    public Page getPage(String path) {
        return repository.findByPath(path).orElseThrow(() -> new NotFoundException(Page.class, path));
    }

    public String getPageHtml(Long id) {
        return mapper.toHtml(getPage(id));
    }

    public String getPageHtml(String path) {
        return mapper.toHtml(getPage(path));
    }

}
