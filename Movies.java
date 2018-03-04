/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xp_kino;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nugzar
 */
public class Movies {

    private String nameOfMovie;
    private String showingDate;
    List<Movies> moviesToHold = new ArrayList<>();

    public Movies(String nameOfMovie, String showingDate) {
        this.nameOfMovie = nameOfMovie;
        this.showingDate = showingDate;
    }

    public String getNameOfMovie() {
        return nameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie) {
        this.nameOfMovie = nameOfMovie;
    }

    public String getShowingDate() {
        return showingDate;
    }

    public void setShowingDate(String showingDate) {
        this.showingDate = showingDate;
    }

    @Override
    public String toString() {
        return "Titlen på filme: " + nameOfMovie + " SHOW TIME: " + showingDate + "\n";
    }

    public void menu() {

        try {
            Scanner scanner = new Scanner(System.in);
            String choise = "";
            System.out.println("Her kan du oprette eller fjerne film");
            System.out.println(" Opret | Fjern");
            choise = scanner.next();
            if (choise.equalsIgnoreCase("opret")) {
                createMovies();

            } else if (choise.equalsIgnoreCase("fjern")) {
                alterTheCurrentMovie();

            } else {
                System.out.println("Try again");
                menu();
            }
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    public List<Movies> createMovies() {

        try {
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;

            while (flag) {

                String a = "";
                System.out.println("DU KAN TIL ENHVER TID VENDE TILBAGE TIL MENUEN");
                System.out.println("TAST BLOT EXIT I BEGGE FELTER\n");
                System.out.println("************************************************");
                System.out.println("Felt 1: Tast navnet på filmen");
                this.nameOfMovie = scanner.nextLine();
                System.out.println("Felt 2: Vise tiden i foramt eks: 02-03-2018  22:00");
                this.showingDate = scanner.nextLine();

                if (!this.moviesToHold.equals("Exit") && !this.showingDate.equalsIgnoreCase("Exit")) {
                    moviesToHold.add(new Movies(this.nameOfMovie, this.showingDate));

                    for (int i = 0; i < moviesToHold.size(); i++) {

                        System.out.println(i + "# " + moviesToHold.get(i));

                    }

                } else {
                    menu();
                }
            }
        } catch (Exception E) {
            System.out.println(E);
        }
        return moviesToHold;

    }

    public void alterTheCurrentMovie() {

        try {
            int choise = 0;
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < moviesToHold.size(); i++) {
                System.out.println(i + "# " + moviesToHold.get(i));
            }
            System.out.println("Venligst vælg index #:");
            int index = scanner.nextInt();
            moviesToHold.remove(index);
            System.out.println("Det valgte index #: " + choise + " er slettet");
            System.out.println("Du kan nu tilføje en ny film");

        } catch (Exception E) {
            System.out.println(E);
        }

    }
}
