package com.example.homework2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.homework2.adapter.SummaryListAdapter;
import com.example.homework2.model.Student;
import com.example.homework2.model.StudentDB;

import java.util.ArrayList;

public class SummaryLVActivity extends AppCompatActivity {

    protected ListView mSummaryView;
    protected SummaryListAdapter ad;
    protected Menu summaryMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_list_lv);

        mSummaryView = findViewById(R.id.student_list_id);
        ad = new SummaryListAdapter();
        mSummaryView.setAdapter(ad);

    }

    @Override
    protected void onStart() {
        ad.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.summary_screen_menu, menu);
        menu.findItem(R.id.action_add).setVisible(true);
        menu.findItem(R.id.action_submit).setVisible(false);
        summaryMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setContentView(R.layout.student_add);

        if (item.getItemId() == R.id.action_add) {
            EditText editView = findViewById(R.id.add_fname_id);
            editView.setEnabled(true);
            editView.findViewById(R.id.add_lname_id);
            editView.setEnabled(true);

            item.setVisible(false);
            summaryMenu.findItem(R.id.action_submit).setVisible(true);
        } else if (item.getItemId() == R.id.action_submit) {

            ArrayList<Student> newList = new ArrayList<Student>();

            newList = StudentDB.getInstance().getStudentList();

            setContentView(R.layout.student_list_lv);
            mSummaryView = findViewById(R.id.student_list_id);
            ad = new SummaryListAdapter();
            mSummaryView.setAdapter(ad);
            item.setVisible(false);
            summaryMenu.findItem(R.id.action_add).setVisible(true);

            String first = ((EditText)findViewById(R.id.add_fname_id)).getText().toString();
            String last = ((EditText)findViewById(R.id.add_lname_id)).getText().toString();
            String cwid = ((EditText)findViewById(R.id.add_cwid_id)).getText().toString();
            Student studentObj = new Student(first, last, Integer.parseInt(cwid));

            newList.add(studentObj);;
            ad.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }
}
