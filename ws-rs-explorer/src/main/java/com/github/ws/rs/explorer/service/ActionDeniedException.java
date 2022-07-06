package com.github.ws.rs.explorer.service;

import java.io.Serial;

import com.github.ws.rs.explorer.Action;
import com.github.ws.rs.explorer.ExplorerException;

/**
 * Business exception if an action cannot be performed because the user is not authenticated
 * or does not have the necessary privileges.
 */
public final class ActionDeniedException extends ExplorerException {

    /**
     * Serial number.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Business action.
     */
    private final Action action;

    /**
     * Construct an exception.
     *
     * @param action  Business action
     * @param message Specific message can be visible by the client
     */
    public ActionDeniedException(final String entity, final Action action, final String message) {
        super(String.format("On [%s] action [%s] is denied ! %s", entity, action, message).trim());
        this.action = action;
    }

    /**
     * Construct an exception.
     *
     * @param action Business action
     */
    public ActionDeniedException(final String entity, final Action action) {
        this(entity, action, "");
    }

    // Getter

    public Action getAction() {
        return action;
    }
}
