import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Task2 {

    //https://www.baeldung.com/java-with-jsoup

    // 56 - 5 = 51

    //public static

    public static void run() throws IOException {

        Set<String> result = new HashSet<>();

        result = findLinks("https://code.edu.az/", result);

        System.out.println(result.size());
    }

    private static Set<String> findLinks(String url, Set lastSet) throws IOException {

        Set<String> links = lastSet;

        try {
            Document doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .get();

            Elements elements = doc.select("a[href]");

            if (elements.isEmpty())
                return null;

            elements.stream()
                    .map(link -> link.attr("href"))
                    .forEach(thisLink -> {
                        boolean add = links.add(thisLink);

                        if (add && thisLink.contains("https://code.edu.az")) {
                            System.out.println(thisLink);

                            try {
                                findLinks(thisLink, links);
                            } catch (IOException e) {
//                                System.out.println(e.getMessage());
                            }
                        }
                    });

        } catch (IOException e){
//            System.out.println(e.getMessage());
        }
        return links;
    }
}
