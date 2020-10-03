package day12.task5;

public class Task5 {
    public static void main(String[] args) {
        MusicBand musicBand1 = new MusicBand("Band 1", 2001);
        musicBand1.addArtist(new MusicArtist("Alice", 22));
        musicBand1.addArtist(new MusicArtist("Alice", 22));
        musicBand1.addArtist(new MusicArtist("Bob", 25));
        musicBand1.addArtist(new MusicArtist("Charlie", 30));
        musicBand1.removeArtist(new MusicArtist("Bob", 25));
        musicBand1.printMembers();
        MusicBand musicBand2 = new MusicBand("Band 2", 2004);
        musicBand2.addArtist(new MusicArtist("John", 34));
        musicBand2.addArtist(new MusicArtist("Tom", 45));
        musicBand2.printMembers();
        MusicBand.transferMembers(musicBand1, musicBand2);
        musicBand1.printMembers();
        musicBand2.printMembers();
    }
}
