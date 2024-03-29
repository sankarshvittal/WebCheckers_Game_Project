package com.webcheckers.ui;

import java.util.Objects;

import com.webcheckers.appl.GameCenter;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import static spark.Spark.halt;

/**
 * The Web Controller for returning from the Spectating Page to the Home Page.
 *
 */
public class GetEndSpectatingRoute implements TemplateViewRoute {
    // Attributes
    private final GameCenter gameCenter;

    /**
     * The constructor for the {@code GET /endSpectating} route handler.
     *
     * @param gameCenter
     *    The {@link GameCenter} for the application.
     */
    GetEndSpectatingRoute(final GameCenter gameCenter) {
        Objects.requireNonNull(gameCenter, "gameCenter must not be null");

        this.gameCenter = gameCenter;
    }

    @Override
    public ModelAndView handle(Request request, Response response) {
        final String currentUsername = request.session().attribute(PostLoginRoute.USERNAME_PARAM);

        //Remove the user from spectating & return to the home page
        if(currentUsername != null)
            gameCenter.endSpectating(currentUsername);

        response.redirect("/");
        halt();
        return null;
    }
}