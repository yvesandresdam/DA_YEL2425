package andres.flights_jftemplate.Controller;

import andres.flights_jfxtemplate.Controller.TicketsController;
import andres.flights_jfxtemplate.Service.TicketService;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TicketsControllerTest {

    TicketsController controller;
    TicketService ticketServiceMock;

    @BeforeAll
    public static void initToolkit() {
        new JFXPanel(); // Inicializa toolkit solo una vez antes de todos los tests
    }

    @BeforeEach
    void setUp() {
        controller = new TicketsController();
        ticketServiceMock = Mockito.mock(TicketService.class);
        controller.ticketService = ticketServiceMock;

        // Inicializa el Label para evitar NullPointerException
        controller.logLabel = new Label();
    }

    @Test
    void testCheckServerStatus_serverDown() {
        Mockito.when(ticketServiceMock.checkServerStatus()).thenReturn(false);

        controller.checkServerStatus();

        assertTrue(controller.isFormHasErrors());
        assertEquals("The application is not connected to the server.", controller.getErrorMessage());
        assertTrue(controller.logLabel.getStyle().contains("red"));
    }

    @Test
    void testCheckServerStatus_serverUp() {
        Mockito.when(ticketServiceMock.checkServerStatus()).thenReturn(true);

        controller.checkServerStatus();

        assertFalse(controller.isFormHasErrors());
        assertNull(controller.getErrorMessage());
        assertFalse(controller.logLabel.getStyle().contains("red"));
    }
}
