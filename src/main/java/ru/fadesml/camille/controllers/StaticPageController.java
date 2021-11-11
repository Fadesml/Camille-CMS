package ru.fadesml.camille.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.fadesml.camille.services.CacheService;
import ru.fadesml.camille.services.PageService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StaticPageController {
    private final PageService pageService;
    private final CacheService cacheService;

    @GetMapping("/")
    public String displayMainPage(Map<String, Object> model) {
        model.put("pages", pageService.getAllPageDtos());

        return "MainPage";
    }

    @GetMapping("/settings")
    @ResponseBody
    public String displaySettings() {
        return cacheService.getSettings().toString();
    }

    @GetMapping("/settings/update")
    @ResponseBody
    public String updateSettings() {
        cacheService.updateSettings();
        return displaySettings();
    }
}
