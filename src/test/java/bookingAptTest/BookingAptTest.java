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
    @Description("All appointment processes has been successfully passed")
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
