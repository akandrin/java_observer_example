package com;

import java.util.Scanner;

public class Main {

    public static void PrintMenu()
    {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить пользователя");
        System.out.println("2. Удалить пользователя");
        System.out.println("3. Отправить сообщение пользователям");
        System.out.println("4. Выйти");
    }

    public static void main(String[] args) {
        NewsService newsService = new NewsService();

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            PrintMenu();
            String choice = scanner.nextLine();
            if (choice.equals("1"))
            {
                System.out.println("Введите имя пользователя: ");
                String userName = scanner.nextLine();
                User user = new User(userName);
                user.Attach(newsService); // добавлем к новому пользователю новостной сервис в качестве наблюдателя с той целью, чтобы уведомлять последнего о том, что пользователю приходят сообщения.
                newsService.Attach(user);
            }
            else if (choice.equals("2"))
            {
                System.out.println("Введите имя пользователя, которого нужно удалить: ");
                String userName = scanner.nextLine();
                newsService.DetachObserverByName(userName);
            }
            else if (choice.equals("3"))
            {
                System.out.println("Введите сообщение: ");
                String message  = scanner.nextLine();
                newsService.SendMessageForUsers(message);
            }
            else if (choice.equals("4"))
            {
                return;
            }
            else
            {
                System.out.println("Некорректный ввод.\n");
            }
        }
    }
}
