package FinalProject.model;

public enum ShipType {
    BATTLESHIP("четырехпалубный корабль", "четырехпалубного корабля",4),
    CRUISER1("первый трехпалубный корабль", "первого трехпалубного корабля",3),
    CRUISER2("второй трехпалубный корабль", "второго трехпалубного корабля",3),
    DESTROYER1("первый двухпалубный корабль", "первого двухпалубного корабля",2),
    DESTROYER2("второй двухпалубный корабль", "второго двухпалубного корабля",2),
    DESTROYER3("третий двухпалубный корабль", "третьего двухпалубного корабля",2),
    TORPEDOBOAT1 ("первый однопалубный корабль", "первого однопалубного корабля",1),
    TORPEDOBOAT2("второй однопалубный корабль", "второго однопалубного корабля",1),
    TORPEDOBOAT3("третий однопалубный корабль", "третьего однопалубного корабля",1),
    TORPEDOBOAT4("четвертый однопалубный корабль", "четвертого однопалубного корабля",1);

    private String typeForm1;
    private String typeForm2;
    private int size;

    ShipType(String typeForm1, String typeForm2, int size) {
        this.typeForm1 = typeForm1;
        this.typeForm2 = typeForm2;
        this.size = size;
    }

    public String getTypeForm1() {
        return typeForm1;
    }

    public String getTypeForm2() {
        return typeForm2;
    }

    public int getSize() {
        return size;
    }
}
