package pl.programming4you.lectures5.lecture5;

public class Task9 {
    public static void main(String[] args) {
        Bodyguard bodyguard = new Bodyguard();
        bodyguard.setAllowedGuestNames(new String[]{"Rysiu", "Zenek", "Janusz"});

        Guest guest1 = new Guest("Rysiu", 30);
        Guest guest2 = new Guest("Rysiu", 17);
        Guest guest3 = new Guest("Zenek", 40);
        Guest guest4 = new Guest("Szymek", 22);
        Guest[] guests = {guest1, guest2, guest3, guest4};

        for (Guest guest : guests) {
            System.out.print("Guest " + guest.getName() + " is ");
            System.out.print(bodyguard.check(guest) ? "" : " NOT ");
            System.out.println("allowed!");
        }

    }
}