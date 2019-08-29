package hanoi;

import structures.LinkedStack;
import structures.StackInterface;

/**
 * A {@link StackBasedHanoiPeg} is a {@link HanoiPeg} backed by a
 * {@link LinkedStack}
 *
 * @author jcollard
 *
 */
public class StackBasedHanoiPeg implements HanoiPeg {

	private LinkedStack<HanoiRing> peg;

	/**
	 * Creates a new {@link StackBasedHanoiPeg} that has no rings.
	 */


	public StackBasedHanoiPeg() {
		peg = new LinkedStack<>();
	}

	@Override
	public void addRing(HanoiRing ring) throws IllegalHanoiMoveException {
		if((!peg.isEmpty()) && (ring.getSize() >= peg.peek().getSize())){
			throw new IllegalHanoiMoveException("Illegal move - not enough rings to remove or moved ring size exceeds that of top ring on target peg.");
		}
		peg.push(ring);
	}

	@Override
	public HanoiRing remove() throws IllegalHanoiMoveException {
		if(peg.isEmpty()){
			throw new IllegalHanoiMoveException("Illegal move - no rings to move.");
		}
        return peg.pop();
	}

	@Override
	public HanoiRing getTopRing() throws IllegalHanoiMoveException {
		if(peg.isEmpty()){
			throw new IllegalHanoiMoveException("Illegal move - no rings to move.");
		}
        return peg.peek();
	}

	@Override
	public boolean hasRings() {
		if(!peg.isEmpty()){
			return true;
		}
		else {
			return false;
		}
	}
}
