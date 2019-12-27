package com.code.miduo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: czp
 * @Description
 * @CreateDate: 2019/12/27 11:07
 */
public class MyService extends Service {

    private static final String TAG = "binder service";
    private List<Book> books;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        books = new ArrayList<>();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return mbinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    IMyAidlInterface.Stub mbinder = new IMyAidlInterface.Stub() {

        @Override
        public void connect() throws RemoteException {
            Log.d(TAG, "connect: service and client");
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            books.add(book);
            Log.d(TAG, "addBook: " + book.toString());
        }

        @Override
        public List<Book> getBooks() throws RemoteException {
            return books;
        }
    };
}
