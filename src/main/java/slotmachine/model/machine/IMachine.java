package slotmachine.model.machine;

import java.util.List;

import slotmachine.model.cardspack.Card;
import slotmachine.model.machine.state.IState;

public interface IMachine {
	
	IState getActualMachineState();
	
	void setState(IState state);

	void insertCoin();

	void shoot();
	
	void disposeMoney();
	
	void giveBackMoney();
	
	void startToPlay();

	void setCards(List<Card> cards);
	
	List<Card> getCards();


}
