package day12.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> bands = new ArrayList<>();
        bands.add(new MusicBand("Band 1", 1990));
        bands.add(new MusicBand("Band 2", 2020));
        bands.add(new MusicBand("Band 3", 1997));
        bands.add(new MusicBand("Band 4", 2000));
        bands.add(new MusicBand("Band 5", 1999));
        bands.add(new MusicBand("Band 6", 1995));
        bands.add(new MusicBand("Band 7", 2010));
        bands.add(new MusicBand("Band 8", 1998));
        bands.add(new MusicBand("Band 9", 2001));
        bands.add(new MusicBand("Band 10", 1980));
        Collections.shuffle(bands);
        List<MusicBand> bandsAfter2000 = groupsAfter2000(bands);
        bands.forEach(System.out::println);
        System.out.println();
        bandsAfter2000.forEach(System.out::println);
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        return bands.stream().filter(band -> band.getYear() > 2000).collect(Collectors.toList());
    }
}
