# 2. Model-View-Controller
1.Vilka avvikelser från MVC-idealet kan ni identifiera i det ursprungliga användargränssnittet? Vad borde ha gjorts smartare, dummare eller tunnare?

### CarController nu:
* cc.cars.add(VehicleFactory.createVolvo()); Själva "add" delen ska vara vara en del av CarController men logiken och hanteringen ska skötas av modellen.
* Timerlistener har inget med input att göra.  Denna del har mer med modellens logik att göra och bör därför vara i modellen.
* gas, brake etc. är alla medotder som hör till CarController men i  uvarande lösning känner de till bilarnas logik. CarController bör inte känna till detta så funktionerna bör kalla på modellen som utför själva handlingen inom modellns abgränsningar.

### CarView nu:
* 



