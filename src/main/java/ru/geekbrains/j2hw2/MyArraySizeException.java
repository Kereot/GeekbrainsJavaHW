package ru.geekbrains.j2hw2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException(String error) {
        super(error);
    }
}
