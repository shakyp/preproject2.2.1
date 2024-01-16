package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

//      UserService userService = context.getBean(UserService.class);
//
//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

//        Создание нескольких пользователей с машинами, добавление их в базу данных, вытаскивание.
        UserService userServiceCars = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        userServiceCars.add(new User("User5", "Lastname5", "user5@mail.ru", new Car("Car5", 5)));
        userServiceCars.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("Car6", 6)));
        userServiceCars.add(new User("User7", "Lastname7", "user7@mail.ru", new Car("Car7", 7)));
        userServiceCars.add(new User("User8", "Lastname8", "user8@mail.ru", new Car("Car8", 8)));

        List<User> usersCars = userServiceCars.listUsers();
        for (User user : usersCars) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

//        Получение юзера, владеющего машиной по ее модели и серии.
        System.out.println(carService.getCarByModelAndSeries("Car6", 6));

        context.close();
    }
}
