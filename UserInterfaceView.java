package HomeWork7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города...");
            String city = scanner.nextLine();

            System.out.println("Введите 1 для получения погоды на сегодня" +
                    "Введите 5 для прогноза на 5 дней; Введите 0 для выхода...");
            String command = scanner.nextLine();

            if ("0".equals(command)) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                System.out.println("Ошибка при выводе погоды!");
            }

        }
    }

    public static void main(String[] args) throws IOException {
        UserInterfaceView view = new UserInterfaceView();
        //model.getWeather("Chita", Period.NOW);
        view.runInterface();
    }
}
