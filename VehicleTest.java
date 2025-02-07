import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    private Saab95 saab;
    private Volvo240 volvo; // måste ha med två ilika för att testa turbo och om trimfactor fungerar som den ska
    private Scania scania;
    private VehicleTransport vehicleTransport;


    @BeforeEach
    void SetUp() {
        saab = new Saab95();
        volvo = new Volvo240();
        scania = new Scania();
        vehicleTransport = new VehicleTransport(2);
    }

    @AfterEach // Känns som om det kan bli fel i olika test ifall motorn förblir på från ett annat test...
    void TearDown() {
        saab.StopEngine();
        saab.setTurboOff();
        volvo.StopEngine();
    }

    @Test
    void TestGetNrDoors() {
        assertAll( // assertAll ger oss möjligheten att testa samma metod för flera variabler (bilar)
                () -> assertEquals(4, volvo.GetNrDoors()),
                () -> assertEquals(2, saab.GetNrDoors())
        );
    }

    @Test
    void TestGetEnginePower() {
        assertAll(
                () -> assertEquals(125, saab.GetEnginePower()),
                () -> assertEquals(100, volvo.GetEnginePower())
        );
    }

    @Test
    void TestGetAndSetColorSaab() {
        saab.SetColor(Color.blue);
        assertEquals(Color.blue, saab.GetColor());
    }

    @Test
    void TestGetAndSetColorVolvo() {
        volvo.SetColor(Color.red);
        assertEquals(Color.red, volvo.GetColor());
    }

    @Test
    void TestStartEngine() {
        saab.StartEngine();
        assertEquals(0.1, saab.GetCurrentSpeed());
    }

    @Test
    void SpeedFactor() {
    }

    @Test
    void TestGas() {
        saab.StopEngine();
        double oldSpeed = saab.GetCurrentSpeed();
        saab.Gas(0.5);
        double newSpeed = saab.GetCurrentSpeed();
        assertTrue(oldSpeed < newSpeed);
    }

    @Test
    void TestBrake() {
        saab.StartEngine();
        for (int i = 1; i<5; i++){
            saab.Gas(1);
        }
        double oldSpeed = saab.GetCurrentSpeed();
        saab.Brake(1);
        double newSpeed = saab.GetCurrentSpeed();
        assertTrue(oldSpeed > newSpeed);
    }

    @Test
    void TestTurnRightAndMove() {
        volvo.StartEngine();
        volvo.Gas(1);
        volvo.TurnRight();
        volvo.Move();
        assertEquals(1.35, volvo.GetX());

    }

    @Test
    void TestTurnLeftAndMove() {
        volvo.StartEngine();
        volvo.Gas(1);
        volvo.TurnLeft();
        volvo.Move();
        assertEquals(-1.35, volvo.GetX());
    }

    @Test
    void TestMove() {
        volvo.StartEngine();
        volvo.Gas(1);
        volvo.Move();
        assertEquals(1.35, volvo.GetY());
    }

    @Test
    void TestTurboOn(){
        double oldSpeedFactor = saab.SpeedFactor();
        saab.setTurboOn();
        double newSpeedFactor = saab.SpeedFactor();
        assertTrue(oldSpeedFactor < newSpeedFactor);
    }

    @Test
    void TestTurboOff(){
        saab.setTurboOn();
        double oldSpeedFactor = saab.SpeedFactor();
        saab.setTurboOff();
        double newSpeedFactor = saab.SpeedFactor();
        assertTrue(oldSpeedFactor > newSpeedFactor);
    }

    @Test
    void TestRaiseScania(){
        scania.raisePlatform();
        assertEquals(70, scania.getAngle());
    }

    @Test
    void TestLowerScania(){
        scania.raisePlatform(50);
        scania.lowerPlatform();
        assertEquals(0, scania.getAngle());
    }

    @Test
    void TestDoubleRaiseAndLowerScania(){
        scania.raisePlatform(10);
        scania.lowerPlatform(5);
        assertEquals(5, scania.getAngle());
    }

    @Test
    void TestScaniaDriveWithRaisedPlatform(){
        scania.raisePlatform(10);
        scania.StartEngine();
        assertEquals(0, scania.GetCurrentSpeed());
    }

    @Test
    void TestTransportRaisPlatform(){
        vehicleTransport.lowerPlatform();
        vehicleTransport.raisePlatform();
        assertTrue(vehicleTransport.GetPlatformStatus());
    }

    @Test
    void TestCantMoveTransport(){
        vehicleTransport.lowerPlatform();
        vehicleTransport.StopEngine();
        assertEquals(0, vehicleTransport.GetCurrentSpeed());
    }

    //Tests if it's possible to load cars in reach and not ones out of reach
    @Test
    void TestTransporterInReachLoad(){
        volvo.StartEngine();
        volvo.Gas(1);
        volvo.Move();
        saab.StartEngine();
        saab.Gas(1);
        saab.Move();
        saab.Move();
        vehicleTransport.lowerPlatform();
        vehicleTransport.load(volvo);
        vehicleTransport.load(saab);

        assertEquals(1, vehicleTransport.GetNrCars());
    }

    @Test
    void TestCarsMoveOnPlatform(){
        vehicleTransport.lowerPlatform();
        vehicleTransport.load(volvo);
        vehicleTransport.StopEngine();
        vehicleTransport.Move();
        assertEquals(vehicleTransport.GetY(), volvo.GetY());
    }


}