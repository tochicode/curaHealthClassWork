package bookingAptTest;

import bookingObjectsPage.BookingObjectsPage;
import io.qameta.allure.Description;
import net.bytebuddy.asm.MemberSubstitution;
import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookingAptTest {
    BookingObjectsPage booking = new BookingObjectsPage();

    @BeforeTest
    public void openPage(){
        booking.openWebpage();
    }

    @Test
    @Description("Appointment Confirmation" +
            "Please be informed that your appointment has been booked as following:" +
            "\nFacility\n" +
            "Hongkong CURA Healthcare Center\n" +
            "\n" +
            "Apply for hospital readmission\n" +
            "No\n" +
            "\n" +
            "Healthcare Program\n" +
            "Medicaid\n" +
            "\n" +
            "Visit Date\n" +
            "12/04/2023\n" +
            "\n" +
            "Comment\n" +
            "I would like to get a very good specialist to run my health program.")
    public void AppointmentProcess(){
        booking.makeAppointment();
        booking.bookAppointment();
        booking.makeAppointmentFinal();
    }

    @AfterTest
    public void closeOut(){
        booking.logOutBtn();
        booking.teardown();
    }


}
