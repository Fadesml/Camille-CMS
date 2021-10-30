package ru.fadesml.camille.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.fadesml.camille.services.PageService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StaticPageController {
    private final PageService pageService;

    @GetMapping("/")
    public String displayMainPage(Map<String, Object> model) {
        model.put("pages", pageService.getAllPageDtos());

        return "MainPage";
    }
}
