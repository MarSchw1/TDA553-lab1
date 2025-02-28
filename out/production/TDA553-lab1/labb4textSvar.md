# 2. Model-View-Controller
1.Vilka avvikelser från MVC-idealet kan ni identifiera i det ursprungliga användargränssnittet? Vad borde ha gjorts smartare, dummare eller tunnare?

### CarController nu:
* cc.cars.add(VehicleFactory.createVolvo()); Själva "add" delen ska vara vara en del av CarController men logiken och hanteringen ska skötas av modellen.
* Timerlistener har inget med input att göra.  Denna del har mer med modellens logik att göra och bör därför vara i modellen.
* gas, brake etc. är alla medotder som hör till CarController men i  uvarande lösning känner de till bilarnas logik. CarController bör inte känna till detta så funktionerna bör kalla på modellen som utför själva handlingen inom modellns abgränsningar.

### CarView nu:
* väldigt mycket knappar osv. Kan tunnas ut en del. Kanpparna och saker som vi ser kan flyttas till en Widgets klass. 

# 3. Fler Designmönster
### Obeserver
Vi använder i nuläget inte Observer. En Observer skulle kunna användas för att göra förhållandent mellan modell och view mer abstrak i linje med OCP.
### Factory Method
Vi har använt en Factory method för att skapa fordonen men i just denna applikation skulle funktionaliteten kunna utökas för att även skapa en workshop.
### State
Vi använder oss inte av något state pattern just nu. Det skulle vara möjligt att använda ett state pattern på några ställen men vi anser att det inte lönar sig i applikationen då dess funktionalitet redan är begränsad. Exempelvis loadade bilar eller turbo. 
### Composite
Vi använder inte någto Composite Pattern i nulget. Det skulle eventuellt kunna användas för att hatera alla aktiva fordon gemensamt.

Vi tror det blir lättare för oss att istället använda en form av Adapter Pattern för att gemensamt hantera de objekt som målas ut i appen. På så vis kan vi koppla fordon och repektive bilder till objekt som implementerar ett nytt interface "Drawable".  


