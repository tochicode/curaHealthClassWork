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
            "Please be informed that your appointment has been booked as following:")
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
