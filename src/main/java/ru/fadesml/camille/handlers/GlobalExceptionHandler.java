package ru.fadesml.camille.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.fadesml.camille.exceptions.NotFoundException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NotFoundException.class })
    public ModelAndView handleNotFoundException(NotFoundException ex, WebRequest request) {
        ModelAndView mv = new ModelAndView("errors/NotFound");
        Map<String, Object> model = mv.getModelMap();
        model.put("message", ex.getMessage());
        return mv;
    }
}
