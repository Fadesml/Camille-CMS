package ru.fadesml.camille.mappers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fadesml.camille.entity.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Mapper(componentModel = "spring")
public abstract class ComponentMapper {
    @Autowired
    protected ObjectMapper objectMapper;

    protected String toHtml(Collection<Component> components) {
        ArrayList<Component> componentList = new ArrayList<>(components);
        componentList.sort(Component.COMPARE_BY_POSITION);

        String html = "";

        for (Component component : components) {
            html = html.concat(toHtml(component));
        }

        return html;
    }

    @SneakyThrows
    protected String toHtml(Component component) {
        Map<String, String> model = objectMapper.readValue(component.getModel(), new TypeReference<>() {});

        String html = component.getTemplate().getHtml();

        for (Map.Entry<String, String> entry : model.entrySet()) {
            html = html.replace("{{ " + entry.getKey() + " }}", entry.getValue());
        }

        return html;
    }
}
