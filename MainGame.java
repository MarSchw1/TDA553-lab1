public class MainGame {
    public static void main(String[] args) {
        Model model = new Model();
        CarController cc = new CarController(model);
        View view = new View(800, 560, model);
        Widgets cw = new Widgets("Car", cc, view);
        model.addObserver(view);
    }
}
