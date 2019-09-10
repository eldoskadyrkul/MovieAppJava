package com.company;

import com.company.controller.MovieService;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        MovieService listController = new MovieService();
        System.out.println("+++++++++++++++++++++++++++++++++");
        System.out.println("+                               +");
        System.out.println("+         Main menu             +");
        System.out.println("+                               +");
        System.out.println("+     1. Add movie              +");
        System.out.println("+     2. Show movie             +");
        System.out.println("+     3. Remove movie           +");
        System.out.println("+     4. Change type movie      +");
        System.out.println("+     5. Exit                   +");
        System.out.println("+                               +");
        System.out.println("+++++++++++++++++++++++++++++++++");

        System.out.println("+++ Please, write one options +++");
        Scanner scanner = new Scanner(System.in);
        int sa = scanner.nextInt();
        while (true) {
            switch (sa) {
                case 1:
                    listController.addMovieJson();
                    break;
                case 2:
                    listController.showMovie();
                    break;
                case 3:
                    listController.removeMovie();
                    break;
                case 4:
                    listController.changeMovieType();
                    break;
                case 5:
                    break;
            }
            break;
        }
    }
}
