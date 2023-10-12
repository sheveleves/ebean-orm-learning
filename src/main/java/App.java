import controllers.RootController;
import io.ebean.DB;
import io.ebean.Database;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
//        DbMigration dbMigration = DbMigration.create();
//        dbMigration.addPlatform(Platform.POSTGRES, "psql");
//        dbMigration.generateMigration();

        Database database = DB.getDefault();
        Javalin app = Javalin.create(
                        config -> {
                            JavalinThymeleaf.init(getTemplateEngine());
                        }
                )
                .get("/", RootController.welcome)
                .start(9000);


    }
    private static TemplateEngine getTemplateEngine() {
        TemplateEngine templateEngine = new TemplateEngine();
//        templateEngine.addDialect(new LayoutDialect());
//        templateEngine.addDialect(new Java8TimeDialect());
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("/templates/");
//        templateResolver.setCharacterEncoding("UTF-8");
        templateEngine.addTemplateResolver(templateResolver);
        return templateEngine;
    }
}
