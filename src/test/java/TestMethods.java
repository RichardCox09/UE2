import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMethods {
    State greenState, yellowState, redState;
    TrafficLightCtrl ctrl = TrafficLightCtrl.getInstance();
    TrafficLightGui gui = new TrafficLightGui(ctrl);

    @Test
    public void testGreenColor(){
        greenState = new State() {
            @Override
            public State getNextState() {
                return yellowState;
            }

            @Override
            public String getColor() {
                return "green";
            }
        };

        gui.changeLights(greenState.getColor());
        assertTrue(gui.greenIsOn());
        assertFalse(gui.yellowIsOn());
        assertFalse(gui.redIsOn());
    }

    @Test
    public void testYellowColor(){
        yellowState = new State() {
            @Override
            public State getNextState() {
                return redState;
            }

            @Override
            public String getColor() {
                return "yellow";
            }
        };

        gui.changeLights(yellowState.getColor());
        assertFalse(gui.greenIsOn());
        assertTrue(gui.yellowIsOn());
        assertFalse(gui.redIsOn());
    }

    @Test
    public void testRedColor(){
        redState = new State() {
            @Override
            public State getNextState() {
                return yellowState;
            }

            @Override
            public String getColor() {
                return "red";
            }
        };

        gui.changeLights(redState.getColor());
        assertFalse(gui.greenIsOn());
        assertFalse(gui.yellowIsOn());
        assertTrue(gui.redIsOn());
    }
}
