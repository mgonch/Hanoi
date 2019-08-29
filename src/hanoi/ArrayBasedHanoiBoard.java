package hanoi;

/**
 * A {@link ArrayBasedHanoiBoard} is a simple implementation of
 * {@link HanoiBoard}
 *
 * @author jcollard
 *
 */
public class ArrayBasedHanoiBoard implements HanoiBoard {

	private HanoiPeg[] pegs = new HanoiPeg[3];


	/**
	 * Creates a {@link ArrayBasedHanoiBoard} with three empty {@link HanoiPeg}s
	 * and {@code n} rings on peg 0.
	 */
	public ArrayBasedHanoiBoard(int n) {
		if(n < 0){
			throw new IllegalArgumentException();
		}
		//Setup / initialize towers
		for(int i = 0; i < pegs.length; i++){
			pegs[i] = new StackBasedHanoiPeg();
		}
		for(int i = n; i > 0; i--){
			pegs[0].addRing(new HanoiRing(i));
		}

	}

	@Override
	public void doMove(HanoiMove move) throws IllegalHanoiMoveException {
		if(!isLegalMove(move)){
			throw new IllegalHanoiMoveException("Illegal move.");
		}
		else{
			HanoiPeg mFromPeg = pegs[move.getFromPeg()];
			HanoiPeg mToPeg =  pegs[move.getToPeg()];
			HanoiRing ringToMove = mFromPeg.remove();
			mToPeg.addRing(ringToMove);
		}
	}

	@Override
	public boolean isSolved() {
        if(!pegs[0].hasRings() && !pegs[1].hasRings()) {
			return true;
		}
        else{
        	return false;
		}
	}

	/**
	 * <p>
	 * A {@link HanoiMove} is not legal if either is true:
	 *
	 * <ul>
	 * <li>The from peg has no rings</li>
	 * <li>The to peg has rings AND the ring to be moved has a size larger than
	 * the topmost ring on the to peg.</li>
	 * </ul>
	 *
	 * Otherwise, the move is legal.
	 * </p>
	 */
	@Override
	public boolean isLegalMove(HanoiMove move) {
		HanoiPeg mFromPeg = pegs[move.getFromPeg()];
		HanoiPeg mToPeg =  pegs[move.getToPeg()];
		if((!mFromPeg.hasRings())){
			return false;
		}
		HanoiRing ringToMove = mFromPeg.getTopRing();
        if((mToPeg.hasRings() && ringToMove.getSize() >= mToPeg.getTopRing().getSize())){
			return false;
		}
        else{
        	return true;
		}
	}
}
