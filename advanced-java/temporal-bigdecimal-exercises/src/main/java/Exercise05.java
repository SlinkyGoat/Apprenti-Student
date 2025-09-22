import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {

        LocalDate nextGiftDay = LocalDate.of(date.getYear(), 1, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        while (nextGiftDay.isBefore(date)) {
            nextGiftDay = nextGiftDay.plusWeeks(2);
        }

        int count = 0;
        LocalDate endOfYear = LocalDate.of(date.getYear(), 12, 31);
        while (!nextGiftDay.isAfter(endOfYear)) {
            count++;
            nextGiftDay = nextGiftDay.plusWeeks(2);
        }

        return BigDecimal.valueOf(count * 10L);
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {

        LocalDate giftDay = LocalDate.of(date.getYear(), 1, 1)
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        while (giftDay.isBefore(date)) {
            giftDay = giftDay.plusWeeks(2);
        }

        BigDecimal total = BigDecimal.ZERO;
        LocalDate endOfYear = LocalDate.of(date.getYear(), 12, 31);

        while (!giftDay.isAfter(endOfYear)) {
            total = total.add(BigDecimal.valueOf(giftDay.getDayOfMonth()));
            giftDay = giftDay.plusWeeks(2);
        }

        return total;
    }
}
