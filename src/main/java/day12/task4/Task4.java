package day12.task4;

public class Task4 {
    public static void main(String[] args) {
        MusicBand musicBand1 = new MusicBand("Band 1", 2001);
        musicBand1.addArtist("Alice");
        musicBand1.addArtist("Alice");
        musicBand1.addArtist("Bob");
        musicBand1.addArtist("Charlie");
        musicBand1.removeArtist("Bob");
        musicBand1.printMembers();
        MusicBand musicBand2 = new MusicBand("Band 2", 2004);
        musicBand2.addArtist("John");
        musicBand2.addArtist("Tom");
        musicBand2.printMembers();
        MusicBand.transferMembers(musicBand1, musicBand2);
        musicBand1.printMembers();
        musicBand2.printMembers();
    }
}
