package day12.task4;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<String> members;

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
        members = new ArrayList<>();
    }

    public MusicBand(String name, int year, List<String> members) {
        this.name = name;
        this.year = year;
        this.members = members;
    }

    public void addArtist(String artist) {
        if (!members.contains(artist)) {
            members.add(artist);
        }
    }

    public void removeArtist(String artist) {
        members.remove(artist);
    }

    public static void transferMembers(MusicBand A, MusicBand B) {
        B.getMembers().addAll(A.getMembers());
        A.getMembers().clear();
    }

    public void printMembers() {
        System.out.println(this.toString() + " contains:");
        members.forEach(System.out::println);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
