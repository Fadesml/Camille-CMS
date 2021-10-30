package ru.fadesml.camille.mappers;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import ru.fadesml.camille.dto.PageDto;
import ru.fadesml.camille.entity.Page;
import ru.fadesml.camille.utils.HtmlUtils;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PageMapper {
    @Autowired
    @Lazy
    protected ComponentMapper componentMapper;

    public String toHtml(Page page) {
        return HtmlUtils.createHtml(page.getTitle(), page.getFullCSS(), componentMapper.toHtml(page.getComponents()));
    }

    public abstract PageDto toDto(Page page);

    public abstract List<PageDto> toDto(List<Page> pages);
}
