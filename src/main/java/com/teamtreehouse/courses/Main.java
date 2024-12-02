package com.teamtreehouse.courses;


import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class Main {
    public static void main(String[] args) {

        get("/", (req, res) -> {
                return new ModelAndView(null, "index.hbs");
    }, new HandlebarsTemplateEngine());
        post("/sign-in", (request, response) ->
        { Map<String, String> model = new HashMap<>();
            model.put("username", request.queryParams("username"));
            return new ModelAndView(model,"sign-in.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
/* lambda (functional interface for route object) takes 2 parameters:
its passed request and response.  And returns Hello World.
 */
/* (assumed port is 80, or we can specify the port here:
http://localhost:4567/hello */

/* after adding the 2nd function, re-run the web app but with a slash only
after the host instead of "hello".  Server is constantly running, waiting for requests.
 */
