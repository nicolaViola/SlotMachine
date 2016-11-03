# Slotmachine
This project would implement a slotmachine game. Throughout a web interface you will receive three cards and if they are equal you will win

## State-of-the-art
### slotmachine implementation
The slotmachine is implemented by a State Pattern. There are four states and every state can execute one or more operations to make the slotmachine change to a new state.
When the slotmachine starts, it is in a NoCoin state.

![Alt text](/document/slotmachineStateDiagram.png?raw=true "Slotmachine State Diagram")

How you can seen from the above picture, the edges are the operation that a state can execute. 

The real game is done in the GAME state. It has injected a Croupier object which knows the game rules. Actual croupier implementation can give you three random cards from a sixteen-card pack.
If the croupier give you three equal cards you win. You will have three chances to win.

![Alt text](/document/slotmachineClassDiagram.png?raw=true "Slotmachine Class Diagram")


### controller implementation
The controller is implemented like a Spring REST service. It exposes the methods to make the slotmachine change state. It implements a Template Pattern to execute the operation.
![Alt text](/document/templateControllerClassDiagram.png?raw=true "Controller Template Class Diagram")

### Testing and documentation
The Rest service is documented by Swagger (http://swagger.io/) so you can also test it. You can try it following this url: http://localhost:8080/swagger-ui.html
You will have an endpoints list. A lot of those come from Spring Boot Actuator but the "machine-controller : Machine Controller" endpoint will make you able to test the game.
Every methods match with the operation of the game. 

The default state is NoCoin state so you can do:
-	/insertCoin operation. You can see the new state (Ready) in the ResponseBody.  
-	/startToPlay operation. You can see the new state (Game) in the ResponseBody.  
-	/shoot operation. You can see the new state (Game, NoCoin or Win). If Win
-		/disponeMoney operation. You can see the new state (NoCoin).

## Used Techonlogy
The project uses Spring Core, Spring Boot, Rest API with Spring MVC, Swagger

## To-do List
 - Add Spring data MongoDb to record the games (use Fongo)
 - GUI