package ru.fadesml.camille.utils;

import j2html.TagCreator;

import java.nio.charset.StandardCharsets;

import static j2html.TagCreator.body;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.style;
import static j2html.TagCreator.title;

public class HtmlUtils {
    public static String createHtml(String title, String css, String scripts, String ... elements) {
        String body = "";
        for (String element : elements) {
            body = body.concat(element);
        }

        return html(
                head(
                        title(title),
                        meta().withCharset(StandardCharsets.UTF_8.name()),
                        link()
                                .withRel("stylesheet")
                                .withHref("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"),
                        style(css)
                ),
                body(
                        TagCreator.rawHtml(body + scripts)
                )
        ).render();
    }
}
