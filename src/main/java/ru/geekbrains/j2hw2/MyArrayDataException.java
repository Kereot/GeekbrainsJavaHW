package ru.geekbrains.j2hw2;
// См. комментарии в MainApp
public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String s) {
        super(s);
    }

//    public void why(int i, int j) {
//        System.err.println("Data in row " + (i + 1) + ", column " + (j + 1) + " is not valid");
//    }
}

