package org.example;

import java.util.Random;

/**
 Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
 Если длины массивов не равны, необходимо как-то оповестить пользователя.
 */


public class Main {
    public static void main(String[] args) {
        int[] array1 = generateArr();
        int[] array2 = generateArr();
        int[] result = modifyArray(array1, array2);
        System.out.println("Результирующий массив: ");
        for (int i = 0; i < result.length; i++ ) {
            System.out.print(result[i] + " ");
        }
    }

    /**
     Метод суммирующий элементы сгенерированных массивов, и оповещения пользователя в случае возникновении
     исключения
     */
    static int[] modifyArray(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null){
            throw new NullPointerException("Оба массива должны существовать");
        }
        if (arr1.length != arr2.length){
            throw new CustomArraySizeException("Не совпадают размеры массивов", arr1.length, arr2.length);
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;
    }

    /**
     Метод генерирующий массивы для нашей задачи
     */
    static int[] generateArr() {
        Random random = new Random();
        int[] result = new int[random.nextInt(4, 6)]; // Создаем такой диапозон, для последующей провокации ошибки
        for (int i = 0; i < result.length; i++){
            result[i] = random.nextInt(10);
        }
        return result;
    }
}

/**
 Создаем свой класс исключения и переопределяем метод оповещения пользователя
 для более детальной информации о возникшей проблеме
 */
class CustomArraySizeException extends RuntimeException{
    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}
