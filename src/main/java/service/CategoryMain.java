package service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan(new String[]{"repository", "service"});
        appContext.refresh();

        CatalogService svc = (CatalogService) appContext.getBean("catalogService");
        svc.test();

        appContext.close();
    }
}
