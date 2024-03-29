package com.webcheckers.ui;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

/**
 * The Web Controller for the Login page.
 *
 */
public class GetLoginRoute implements TemplateViewRoute {
    static final String VIEW_NAME = "login.ftl";

    @Override
    public ModelAndView handle(Request request, Response response) {
        Map<String, Object> vm = new HashMap<>();
        vm.put("title", "Login!");
        return new ModelAndView(vm , VIEW_NAME);
    }

}