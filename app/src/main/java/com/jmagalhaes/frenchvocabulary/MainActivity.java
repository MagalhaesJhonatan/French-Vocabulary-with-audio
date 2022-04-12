package com.jmagalhaes.frenchvocabulary;

import static com.jmagalhaes.frenchvocabulary.Vocab.engArray;
import static com.jmagalhaes.frenchvocabulary.Vocab.rusArray;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;


public class MainActivity extends AppCompatActivity {



    int i = 0;
    int j = 0;

    public void deleteMp3() {
        File file = new File("/storage/emulated/0/Android/data/com.jmagalhaes.frenchvocabulary/files/Download", "temp.mp3");
        boolean deleted = file.delete();
    }

    public void beginDownload() {

        String s = "https://translate.google.com/translate_tts?ie=UTF-8&total=1&idx=0&client=tw-ob&tl=fr&q=" + rusArray[i];
        deleteMp3();
        File file = new File("/storage/emulated/0/Android/data/com.jmagalhaes.frenchvocabulary/files/Download", "temp.mp3");
        DownloadManager.Request request = null;

            request = new DownloadManager.Request(Uri.parse(s))
                    .setTitle("temp.mp3")
                    .setDestinationUri(Uri.fromFile(file))
                    .setNotificationVisibility(2)
                    .setVisibleInDownloadsUi(false)
                    .setAllowedOverMetered(true)
                    .setAllowedOverRoaming(true);


        DownloadManager downloadManager=(DownloadManager)getSystemService((DOWNLOAD_SERVICE));
        downloadManager.enqueue(request);

    }

    public void audioPlayer(View view){
        MediaPlayer mp = new MediaPlayer();

        try {
            mp.setDataSource("/storage/emulated/0/Android/data/com.jmagalhaes.frenchvocabulary/files/Download/temp.mp3");
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void nextClick (View view) {
        if (i < 0 || i >= (rusArray.length - 1)) {
            i = 0;

        } else {
            TextView textView = (TextView) findViewById(R.id.textView);
            i++;
            textView.setText(rusArray[i]);
            beginDownload();

        }
        if (j < 0 || j >= (engArray.length - 1)) {
            j = 0;
        } else {
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            j++;
            textView2.setText(engArray[j]);

        }
    }

    public void previousClick (View view) {
        if (i <= 0 || i >= (rusArray.length -1)) {
            i = 0;

        } else {
            TextView textView = (TextView) findViewById(R.id.textView);
            i--;
            textView.setText(rusArray[i]);
            beginDownload();

        }
        if (j <= 0 || j >= (engArray.length -1)) {
            j = 0;
        } else {
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            j--;
            textView2.setText(engArray[j]);


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vocabulary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.item1) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(rusArray[0]);
            i = 0;
            j = 0;
        }

        if (item.getItemId() == R.id.item2) {
            TextView textView2 = (TextView) findViewById(R.id.textView);
            textView2.setText(rusArray[792]);
            i = 792;
            j = 792;
        }
        if (item.getItemId() == R.id.item3) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2424]);
            i = 2424;
            j = 2424;
        }
        if (item.getItemId() == R.id.item4) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2539]);
            i = 2539;
            j = 2539;
        }
        if (item.getItemId() == R.id.item5) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2566]);
            i = 2566;
            j = 2566;
        }
        if (item.getItemId() == R.id.item6) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2914]);
            i = 2914;
            j = 2914;
        }
        if (item.getItemId() == R.id.item7) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2938]);
            i = 2938;
            j = 2938;
        }
        if (item.getItemId() == R.id.item8) {
            TextView textView3 = (TextView) findViewById(R.id.textView);
            textView3.setText(rusArray[2954]);
            i = 2954;
            j = 2954;
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clic", i);
        outState.putInt("clic2", j);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        i = savedInstanceState.getInt("clic");
        j = savedInstanceState.getInt("clic2");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
