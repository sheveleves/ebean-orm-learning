package controllers;

import Model.Sh;
import io.javalin.http.Handler;

public class RootController {
    public static Handler welcome = ctx -> {
        Sh sh = new Sh("Djon", "Shev");
        sh.save();
        sh.toString();
        ctx.render("index.html");
    };
}
