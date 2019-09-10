package com.company.controller;

import com.company.model.MovieModel;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.util.DefaultPrettyPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {

    static Scanner scan = new Scanner(System.in);
    static String movie, rating, types;
    static int id, year, runtime, countable, search;
    static MovieModel movieModel;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final ArrayList<MovieModel> MOVIES = new ArrayList<>();

    // that method is answer for adding movie in the model
    public static ArrayList<MovieModel> addMovie() {
        System.out.println("Please enter your count for add movie");
        countable = scan.nextInt();
        for(int i = 0; i < countable; i++) {
            System.out.println("Please enter ID movies");
            id = scan.nextInt();
            System.out.println("Please enter movie title: ");
            movie = scan.nextLine(); // for debug
            movie = scan.nextLine(); // for run
            System.out.println("Please enter movie rating: ");
            rating = scan.nextLine();
            System.out.println("Please enter movie types: ");
            types = scan.nextLine();
            System.out.println("Please enter year produced: ");
            year = Integer.parseInt(scan.next());
            System.out.println("Please enter total runtime: ");
            runtime = scan.nextInt();

            movieModel = new MovieModel(id, movie, rating, types, year, runtime);
            MOVIES.add(movieModel);
        }
        return MOVIES;
    }

    // that methods is answer for adding movie in the json file
    public void addMovieJson() {
        try {
            addMovie();
            ObjectWriter writer = OBJECT_MAPPER.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("json/movies.json"), MOVIES.toArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(MOVIES);
    }

    // that methods is update movie
    public void updateMovie(int id, String types_movie) {
        try {
            File file = new File("json/movies.json");
            JsonNode node = OBJECT_MAPPER.readTree(file);
            System.out.println(node);

            JsonNode movie_title = node.path("movieTitle");
            System.out.println(movie_title.getTextValue());

            JsonNode movie_rating = node.path("ratingMovie");
            System.out.println(movie_rating.getTextValue());

            JsonNode movie_year = node.path("yearMovie");
            System.out.println(movie_year.getIntValue());

            JsonNode movie_runtime = node.path("runtimeMovie");
            System.out.println(movie_runtime.getIntValue());

            movieModel = new MovieModel(id, types_movie);
            MOVIES.add(movieModel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // that method is answer for remove movie in the model
    public void removeMovie() {
        try {
            System.out.println("Please enter index for delete movie");
            search = scan.nextInt();
            byte[] file = Files.readAllBytes(Paths.get("json/movies.json"));
            List movies = OBJECT_MAPPER.readValue(file, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, MovieModel.class));
            movies.remove(search); // that component is answer for removing data in list
            System.out.println(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // that method is answer for a show movie
    public void showMovie() {
        try {
            byte[] file = Files.readAllBytes(Paths.get("json/movies.json"));
            List movies = OBJECT_MAPPER.readValue(file, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, MovieModel.class));
            System.out.println(movies);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // that method is change type films
    public void changeMovieType(){
        try {
            System.out.println("Please enter index for delete movie");
            int index = scan.nextInt();
            System.out.println("Please enter changed value for type movie");
            String changed = scan.nextLine();
            String changed1 = scan.nextLine();
            updateMovie(index, changed1);
            ObjectWriter writer = OBJECT_MAPPER.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("json/update_movies.json"), MOVIES.toArray());
            System.out.println(MOVIES);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
