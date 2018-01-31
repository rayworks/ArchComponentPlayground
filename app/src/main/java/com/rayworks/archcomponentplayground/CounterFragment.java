package com.rayworks.archcomponentplayground;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class CounterFragment extends Fragment {

    private TextView textView;
    private TextView tag;
    private Button button;

    private Record record;

    public CounterFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_main, container, false);

        textView = view.findViewById(R.id.txt);
        tag = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.btn_adder);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (record == null) {
                    record = new Record();
                }

                if (Utils.isRandomEven())
                    record.scoreTeamB += 1;
                else
                    record.scoreTeamA += 1;

                showRecordInfo();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showRecordInfo();

        tag.setText(this.toString());
    }

    private void showRecordInfo() {
        if (record != null) {
            textView.setText(Utils.getFormatScoreInfo(record.scoreTeamA, record.scoreTeamB));
        }
    }

    // The retained data
    private class Record {
        public int scoreTeamA = 0;
        public int scoreTeamB = 0;
    }
}
