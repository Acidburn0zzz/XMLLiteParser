import java.util.ArrayList;

/**
 * XML LITE Parser - WTFPL license
 */
public interface State {

    /**
     * @param c input character, event to be processed for the current state
     * @return a new state according to the input event
     */
    State transition(char c) throws NodeBeforeContentException, UnexpectedClosingNameException, EmptyNameException;

    /**
     * @return true if the state is a final state for the Finite-state machine
     */
    boolean isFinal();
}
