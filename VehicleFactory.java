public class VehicleFactory {
    public static VehicleObject createVolvo(){
        Volvo240 volvo = new Volvo240();
        return new VehicleObject(volvo);
    }

    public static VehicleObject createSaab(){
        Saab95 saab = new Saab95();
        return new VehicleObject(saab);
    }

    public static VehicleObject createScania(){
        Scania scania = new Scania();
        return new VehicleObject(scania);
    }

}
