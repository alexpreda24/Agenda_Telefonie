import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Contact implements Serializable {
    private final String name;
    private final String prenume;

    private final String birthDate;
    private final NrTel phoneNumber;

    private boolean caseMobile;


    public Contact(String name, String prenume, NrTel phoneNumber,String birthDate, boolean caseMobile) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.prenume = prenume;
        this.caseMobile = caseMobile;
        LocalDate cal = LocalDate.of(Integer.parseInt(birthDate.substring(6, 10)),
                Integer.parseInt(birthDate.substring(3, 5)),
                Integer.parseInt(birthDate.substring(0, 2)));
        // birthDate is in the format dd/mm/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.birthDate = formatter.format(cal);

    }

    public String getName() {
        return name;
    }

    public NrTel getPhoneNumber() {
        return phoneNumber;
    }

    public String getPhoneNumberString() {
        return phoneNumber.getNumar();
    }

    public String getPrenume() {
        return prenume;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getMonth() {
        return Integer.parseInt(birthDate.substring(3, 5));
    }

    public int getDay() {
        return Integer.parseInt(birthDate.substring(0, 2));
    }

    public boolean compareContacts(Contact c) {

        if (this.name.equalsIgnoreCase(c.name) && this.prenume.equalsIgnoreCase(c.prenume) &&
                this.phoneNumber.equals(c.phoneNumber) && this.birthDate.equals(c.birthDate))
            return true;
        return false;
    }

    public int compareToDate(Contact c) {
        int day = Integer.parseInt(this.birthDate.substring(0, 2));
        int month = Integer.parseInt(this.birthDate.substring(3, 5));
        int year = Integer.parseInt(this.birthDate.substring(6, 10));
        int day2 = Integer.parseInt(c.birthDate.substring(0, 2));
        int month2 = Integer.parseInt(c.birthDate.substring(3, 5));
        int year2 = Integer.parseInt(c.birthDate.substring(6, 10));
        if (year > year2)
            return 1;
        else if (year < year2)
            return -1;
        else {
            if (month > month2)
                return 1;
            else if (month < month2)
                return -1;
            else {
                if (day > day2)
                    return 1;
                else if (day < day2)
                    return -1;
                else
                    return 0;
            }
        }
    }


    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", prenume='" + prenume + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber=" + phoneNumber.getNumar() +
                ", caseMobile=" + caseMobile +
                '}';
    }

}
