package com.webcheckers.ui;
import com.webcheckers.appl.GameCenter;
import com.webcheckers.model.Game;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Objects;

/**
 * The Web Controller for backing up a Move
 *
 */
public class PostBackupMoveRoute implements Route {
    //Attributes
    private final GameCenter gameCenter;

    /**
     * The constructor for the {@code POST /backupMove} route handler.
     *
     * @param gameCenter
     *    The {@link GameCenter} for the application.
     */
    PostBackupMoveRoute(final GameCenter gameCenter) {
        // validation
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");

        this.gameCenter = gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) {
        final String currentUsername = request.session().attribute(PostLoginRoute.USERNAME_PARAM);
        Game game = gameCenter.getGame(currentUsername);

        return game.backupMove();
    }
}
