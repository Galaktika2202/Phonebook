package Progect;

import java.util.Scanner;

public class Main {
    static final int MAX_CONTACTS = 10;
    static Contact[] contacts = new Contact[MAX_CONTACTS];
    static int numContacts = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    saveAndExit();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n1. Новый контакт");
        System.out.println("2. Редактировать контакт");
        System.out.println("3. Удалить контакт");
        System.out.println("4. Сохранить и выйти");
    }

    static int getChoice() {
        System.out.print("Выберите действие: ");
        return scanner.nextInt();
    }

    static void addContact() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("Пожалуйста, введите имя.");
            name = scanner.nextLine();
        }

        System.out.print("Введите номер телефона: ");
        String value = scanner.nextLine();
        while (value.isEmpty()) {
            value = scanner.nextLine();
        }

        for (int i = 0; i < MAX_CONTACTS; i++) {
            if (contacts[i] == null) {
                contacts[i] = new Contact(name, value);
                System.out.println("Контакт добавлен.");
                return;
            }
        }
        System.out.println("Память телефона заполнена.");
    }

    static void editContact() {
        displayContacts();
        System.out.print("Введите индекс контакта для редактирования: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character
        if (0 <= index && index < MAX_CONTACTS && contacts[index] != null) {
            System.out.print("Введите новое имя: ");
            String name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.println("Пожалуйста, введите имя.");
                name = scanner.nextLine();
            }

            System.out.print("Введите новый номер: ");
            String value = scanner.nextLine();
            while (value.isEmpty()) {
                value = scanner.nextLine();
            }

            contacts[index] = new Contact(name, value);
            System.out.println("Контакт изменен.");
        } else {
            System.out.println("Неверный индекс контакта.");
        }
    }

    static void deleteContact() {
        displayContacts();
        System.out.print("Введите индекс контакта для удаления: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline character
        if (0 <= index && index < MAX_CONTACTS && contacts[index] != null) {
            contacts[index] = null;
            System.out.println("Контакт удален.");
        } else {
            System.out.println("Неверный индекс контакта.");
        }
    }

    static void displayContacts() {
        System.out.println("\nСписок контактов ");
        for (int i = 0; i < MAX_CONTACTS; i++) {
            if (contacts[i] != null) {
                System.out.println((i + 1) + ". " + contacts[i].name + " " + contacts[i].value);
            } else {
                System.out.println((i + 1) + ". ...");
            }
        }
    }

     static void saveAndExit() {
        System.out.println("Сохранение и выход...");
    }
}


