import java.time.DayOfWeek;
import java.time.LocalDate;

    public class DostonIshSoatlari {

        public static void main(String[] args) {

            LocalDate firstDate = LocalDate.of(2019, 3, 1);
            LocalDate lastDate = LocalDate.of(2024, 9, 30);

            int umumiySoatlar = 0;

            while (!firstDate.isAfter(lastDate)) {
                DayOfWeek day = firstDate.getDayOfWeek();
                if (day == DayOfWeek.SATURDAY) {
                    umumiySoatlar += 6;
                } else if (day == DayOfWeek.SUNDAY) {
                    umumiySoatlar += 9;
                }
                firstDate = lastDate.plusDays(1);
            }
            System.out.println("Dostonning jami ishlagan soatlari: " + umumiySoatlar + " soat");
        }
    }

