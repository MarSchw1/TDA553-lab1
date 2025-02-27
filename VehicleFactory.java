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

    public static WorkshopObject createVolvoWorkshop(int capacity, double x, double y){
        Workshop<Volvo240> volvo240Workshop = new Workshop<Volvo240>(capacity, x, y);
        return new WorkshopObject(volvo240Workshop);
    }

}
