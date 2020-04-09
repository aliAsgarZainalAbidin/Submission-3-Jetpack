package com.example.sub2jetpack.Injection;

import android.content.Context;

import com.example.sub2jetpack.data.Repository;
import com.example.sub2jetpack.data.local.LocalDataSource;
import com.example.sub2jetpack.data.local.room.Database;
import com.example.sub2jetpack.data.remote.RemoteDataSource;
import com.example.sub2jetpack.utils.AppExecutors;
import com.example.sub2jetpack.utils.JsonHelper;

public class Injection {
    public static Repository provideRepository(Context context){
        Database database = Database.getInstance(context);
        RemoteDataSource remoteDataSource = RemoteDataSource.getINSTANCE(new JsonHelper());
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.dataDao());
        AppExecutors appExecutors = new AppExecutors();

        return Repository.getInstance(remoteDataSource, localDataSource, appExecutors);
    }
}
