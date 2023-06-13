package pl.programming4you.lectures5.lecture5;

public class Bodyguard {
    private String[] allowedGuestNames;

    public void setAllowedGuestNames(String[] allowedGuestNames) {
        this.allowedGuestNames = allowedGuestNames;
    }

    boolean check(Guest guest) {
        if (guest.getAge() >= 18) {
            for (String name : allowedGuestNames) {
                if (guest.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
}
