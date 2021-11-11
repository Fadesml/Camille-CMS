package ru.fadesml.camille.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ru.fadesml.camille.exceptions.CamilleException;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { CamilleException.class})
    protected ModelAndView handleCamilleExceptions(Exception ex, WebRequest request, HttpServletResponse response) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (ex.getClass().isAnnotationPresent(ResponseStatus.class)) {
            status = ex.getClass().getAnnotation(ResponseStatus.class).value();
        }

        ModelAndView mv = new ModelAndView("errors/ErrorPage");
        Map<String, Object> model = mv.getModelMap();
        model.put("statusName", status.name());
        model.put("statusValue", status.value());
        model.put("request", request);
        model.put("exception", ex);


        response.setStatus(status.value());

        return mv;
    }
}
