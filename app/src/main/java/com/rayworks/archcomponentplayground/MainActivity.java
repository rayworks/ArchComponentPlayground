package com.rayworks.archcomponentplayground;

import androidx.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rayworks.archcomponentplayground.viewmodel.ScoreViewModel;

import static com.rayworks.archcomponentplayground.Utils.getFormatScoreInfo;

public class MainActivity extends TrackableActivity {

    private ScoreViewModel viewModel;
    private TextView textView;
    private TextView tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tag = findViewById(R.id.textView);

        String instantMsg = ">>> Instance : " + this;
        System.out.println(instantMsg);
        Toast.makeText(this, instantMsg, Toast.LENGTH_SHORT).show();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initViewModel();

        textView = findViewById(R.id.txt);
        Button button = findViewById(R.id.btn_adder);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.isRandomEven()) {
                    viewModel.scoreTeamB += 1;
                } else {
                    viewModel.scoreTeamA += 1;
                }

                showScore();
            }
        });

        showScore();
    }

    private void initViewModel() {
        ScoreViewModel.ScoreFactory factory = new ScoreViewModel.ScoreFactory(
                this.getApplicationContext());

        viewModel = ViewModelProviders.of(this, factory).get(ScoreViewModel.class);

        showViewModelInfo();
    }

    private void showViewModelInfo() {
        String vmStr = ">>> Current view model : " + viewModel;
        System.out.println(vmStr);

        tag.setTextColor(Color.BLUE);
        tag.setText(vmStr);
    }

    private void showScore() {
        textView.setText(getFormatScoreInfo(viewModel.scoreTeamA, viewModel.scoreTeamB));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
