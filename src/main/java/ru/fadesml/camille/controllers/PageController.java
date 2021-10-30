package ru.fadesml.camille.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fadesml.camille.services.PageService;

@RestController
@RequiredArgsConstructor
public class PageController {
    private final PageService pageService;

    @GetMapping("/pages/{path}")
    public String getPage(@PathVariable String path) {
        return pageService.getPageHtml(path);
    }

}
