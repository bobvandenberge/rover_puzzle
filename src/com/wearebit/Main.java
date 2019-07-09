package com.wearebit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Read problem
        var problem = "problems/big_problem.txt";

        CircularList<Bron> bronnen = getBronnen(problem);

        for (int i = 0; i < bronnen.size(); i++) {
            int brandstofOver = bronnen.get(i).overheadInBrandstof();
            if (brandstofOver >= 0) {
                if(werktDitPad(bronnen, i)) {
                    System.out.println("Start met " + i);
                    break;
                }
            }
        }
    }

    private static boolean werktDitPad(CircularList<Bron> bronnen, int beginBron) {
        var huidigeBron = beginBron + 1;
        var brandstof = bronnen.get(beginBron).overheadInBrandstof();

        while(huidigeBron != beginBron) {
            brandstof += bronnen.get(huidigeBron).overheadInBrandstof();

            if (brandstof < 0) {
                return false;
            }

            huidigeBron = (huidigeBron + 1) % bronnen.size();
        }

        return true;
    }

    private static CircularList<Bron> getBronnen(String problem) {
        CircularList<Bron> bronnen = new CircularList<>();
        try (Stream<String> stream = Files.lines(Paths.get(problem)).skip(1)) {

            stream.forEach(input -> {
                String[] splitted = input.split(" ");
                int kmTotVolgendeBron = Integer.parseInt(splitted[0]);
                int brandstof = Integer.parseInt(splitted[1]);

                bronnen.add(new Bron(brandstof, kmTotVolgendeBron));
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return bronnen;
    }
}
