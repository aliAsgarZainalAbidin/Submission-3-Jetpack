package com.example.sub2jetpack.utils;

import com.example.sub2jetpack.data.local.entity.MovieEntity;
import com.example.sub2jetpack.data.local.entity.TvEntity;
import com.example.sub2jetpack.data.remote.response.MovieResponse;
import com.example.sub2jetpack.data.remote.response.TvResponse;

import java.util.ArrayList;

public class DataDummy {
    public static ArrayList<MovieEntity> generateDummyMovie(){
        ArrayList<MovieEntity> listMovies = new ArrayList<>();
        listMovies.add(new MovieEntity(454626,
                237255,
                1090,
                false,
                "/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
                false,
                "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
                "en",
                "Sonic the Hedgehog",
                "Sonic the Hedgehog",
                7.3f,
                "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                "2020-02-12",
                false));
        return listMovies;
    }

    public static ArrayList<TvEntity> generateDummyTv(){
        ArrayList<TvEntity> listTv = new ArrayList<>();
        listTv.add(new TvEntity(60735,
                "The Flash",
                "The Flash",
                235173,
                3429,
                "2014-10-07",
                "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg",
                "en",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                6.9f,
                false));
        return listTv;
    }

    public static ArrayList<MovieResponse> generateRemoteDummyMovie(){
        ArrayList<MovieResponse> listMovies = new ArrayList<>();
        listMovies.add(new MovieResponse(454626,
                237255,
                1090,
                false,
                "/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
                false,
                "/stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
                "en",
                "Sonic the Hedgehog",
                "Sonic the Hedgehog",
                7.3f,
                "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
                "2020-02-12"));
        return listMovies;
    }

    public static ArrayList<TvResponse> generateRemoteDummyTv(){
        ArrayList<TvResponse> listTv = new ArrayList<>();
        listTv.add(new TvResponse(60735,
                "The Flash",
                "The Flash",
                235173,
                3429,
                "2014-10-07",
                "/6ZdQTBy20HzWudZthAV7NkZWfIb.jpg",
                "en",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                6.9f));
        return listTv;
    }

}
