import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class carTest {
    private Saab95 saab;
    private volvo240 volvo; // måste ha med två ilika för att testa turbo och om trimfactor fungerar som den ska



    @BeforeEach
    void setUp() {
        saab = new Saab95();
        volvo = new volvo240();
    }

    @AfterEach // Känns som om det kan bli fel i olika test ifall motorn förblir på från ett annat test...
    void tearDown() {
        saab.stopEngine();
        saab.setTurboOff();
        volvo.stopEngine();
    }

    @Test
    void testGetNrDoors() {
        assertAll( // assertAll ger oss möjligheten att testa samma metod för flera variabler (bilar)
                () -> assertEquals(4, volvo.getNrDoors()),
                () -> assertEquals(2, saab.getNrDoors())
        );
    }

    @Test
    void testGetEnginePower() {
        assertAll(
                () -> assertEquals(125, saab.getEnginePower()),
                () -> assertEquals(100, volvo.getEnginePower())
        );
    }

    @Test
    void testGetAndSetColorSaab() {
        saab.setColor(Color.blue);
        assertEquals(Color.blue, saab.getColor());
    }

    @Test
    void testGetAndSetColorVolvo() {
        volvo.setColor(Color.red);
        assertEquals(Color.red, volvo.getColor());
    }

    @Test
    void testStartEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed());
    }

    @Test
    void speedFactor() {
    }

    @Test
    void testIncrementSpeed() {
        saab.currentSpeed = 1;
        double oldSpeed = saab.getCurrentSpeed();
        saab.incrementSpeed(1);
        double newSpeed = saab.getCurrentSpeed();
        assertTrue(oldSpeed < newSpeed);

    }

    @Test
    void testDecrementSpeed() {
        saab.currentSpeed = 10;
        double oldSpeed = saab.getCurrentSpeed();
        saab.decrementSpeed(0.5);
        double newSpeed = saab.getCurrentSpeed();
        assertTrue(oldSpeed > newSpeed);
    }

    @Test
    void testGas() {
        saab.stopEngine();
        double oldSpeed = saab.getCurrentSpeed();
        saab.gas(0.5);
        double newSpeed = saab.getCurrentSpeed();
        assertTrue(oldSpeed < newSpeed);
    }

    @Test
    void testBrake() {
        saab.startEngine();
        saab.currentSpeed = 2;
        double oldSpeed = saab.getCurrentSpeed();
        saab.brake(1);
        double newSpeed = saab.getCurrentSpeed();
        assertTrue(oldSpeed > newSpeed);
    }

    @Test
    void testTurnRightAndMove() {
        volvo.currentSpeed = 1;
        volvo.turnRight();
        volvo.move();
        assertEquals(1, volvo.getX());

    }

    @Test
    void testTurnLeftAndMove() {
        volvo.currentSpeed = 1;
        volvo.turnLeft();
        volvo.move();
        assertEquals(-1, volvo.getX());
    }

    @Test
    void testMove() {
        volvo.currentSpeed = 1;
        volvo.move();
        assertEquals(1, volvo.getY());
    }

    @Test
    void testTurboOn(){
        double oldSpeedFactor = saab.speedFactor();
        saab.setTurboOn();
        double newSpeedFactor = saab.speedFactor();
        assertTrue(oldSpeedFactor < newSpeedFactor);
    }

    @Test
    void testTurboOff(){
        saab.setTurboOn();
        double oldSpeedFactor = saab.speedFactor();
        saab.setTurboOff();
        double newSpeedFactor = saab.speedFactor();
        assertTrue(oldSpeedFactor > newSpeedFactor);
    }
}