public class SeatReservation {
    public static void main(String[] args) {
        //A stadium assigns numerical values to different seat sections.

        //1. Create an enum named SeatSection with values:
        //GENERAL
        //PREMIUM
        //VIP
        enum SeatSection {
            GENERAL,
            PREMIUM,
            VIP,
        }

        //2. Print each section’s corresponding integer value using the ordinal() method.
        System.out.println(SeatSection.GENERAL + " is assigned value: " + SeatSection.GENERAL.ordinal());
        System.out.println(SeatSection.PREMIUM + " is assigned value: " + SeatSection.PREMIUM.ordinal());
        System.out.println(SeatSection.VIP + " is assigned value: " + SeatSection.VIP.ordinal());

    }
}
