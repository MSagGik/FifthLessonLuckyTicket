package com.msaggik.fifthlessonluckyticket;

import java.util.Arrays;

public class Algorithm {

    // создание пустого конструктора
    public Algorithm() {
    }

    // метод определения счастливый билет или нет
    public boolean isHappyTicket(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int

        int s1 = 0, s2 = 0; // создание буферных переменных

        for(int i = 0; i < 3; i++) { // цикл заполнения первой половины числа
            s1 = s1 + inputInt % 10;
            inputInt = inputInt / 10;
        }
        for(int i = 0; i < 3; i++) { // цикл заполнения второй половины числа
            s2 = s2 + inputInt % 10;
            inputInt = inputInt / 10;
        }
        // проверка равенства
        if (s1 == s2) { // если суммы равны
            return true;   // то билет счастливый
        } else { // иначе
            return false; // билет не счастливый
        }
    }

    // метод определения следующего счастливого билета (чуть менее быстрый)
    public int nextHappyTicketV1(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int

        if(!isHappyTicket(Integer.toString(inputInt))) { // если билет не счастливый
            while (!isHappyTicket(Integer.toString(inputInt))) { // то выполняется цикл
                inputInt = inputInt + 1; // шаговой проверки следующих билетов до наступления счастливого билета
            }
            return inputInt; // возвращается найденный счастливый билет
        } else { // иначе (в случае изначально счастливого билета)
            return inputInt; // возвращается счастливый билет
        }
    }

    // метод определения следующего счастливого билета (быстрее)
    public int nextHappyTicketV2(String input) {
        int inputInt = Integer.parseInt(input); // конвертирование данных из String в int
        int count = 0; // задание счётчика

        for (int i = inputInt; i < 1_000_000; i++) { // цикл проверки и поиски счастливого билета
            int s1 = i%10 + (i/10)%10 + (i/100)%10; // подсчёт суммы последних трёх чисел
            int j = i / 1000;
            int s2 = j%10 + (j/10)%10 + (j/100)%10; // подсчёт суммы первых трёх чисел
            if (s1 == s2) { // проверка счастливого билета
                break; // выброс из цикла
            } else { // иначе
                count++; // увеличение счётчика на единицу
            }
        }

        return inputInt + count; // вывод счастливого билета
    }
}
