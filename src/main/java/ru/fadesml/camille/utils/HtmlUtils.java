package ru.fadesml.camille.utils;

public class HtmlUtils {
    public static String createHtml(String title, String css, String ... elements) {
        String start = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<title>"+ title +"</title>" +
                "<style>"+ css +"</style>" +
                "</head>" +
                "<body>";
        String body = "";
        for (String element : elements) {
            body = body.concat(element);
        }
        String end = "</body></html>";

        return start + body + end;
    }
}
