public class VehicleFactory {
    public static Vehicle createVolvo(){
        Volvo240 volvo = new Volvo240();
        return volvo;
    }

    public static Vehicle createSaab(){
        Saab95 saab = new Saab95();
        return saab;
    }

    public static Vehicle createScania(){
        Scania scania = new Scania();
        return scania;
    }

}
