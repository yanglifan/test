package yanglifan.test.good_topn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GoodTopNFinder {
    private Comparator<Good> comparator = (o1, o2) -> o2.getPrice().compareTo(o1.getPrice());

    SortedSet<Good> find(String fileName, int topN) {
        SortedSet<Good> results = new TreeSet<>(comparator);

        double currentMinimum = 0d;
        try (InputStream inputStream = new FileInputStream(getFilePath(fileName))) {
            Scanner sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Good good = new Good(line);

                if (good.getPrice() < currentMinimum) {
                    continue;
                }

                if (results.size() < topN * 2) {
                    results.add(good);
                } else {
                    List<Good> temp = results.stream().limit(topN).collect(Collectors.toList());
                    results = new TreeSet<>(comparator);
                    results.addAll(temp);
                }

                currentMinimum = results.last().getPrice();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return results;
    }

    private String getFilePath(String fileName) {
        URL url = getClass().getClassLoader().getResource(fileName);
        if (url == null) {
            throw new RuntimeException();
        }

        return url.getPath();
    }
}
