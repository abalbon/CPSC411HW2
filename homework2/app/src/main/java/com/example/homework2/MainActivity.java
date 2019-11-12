package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.homework2.model.CourseEnrollment;
import com.example.homework2.model.StudentDB;
import com.example.homework2.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.student_list);

        root = findViewById(R.id.student_list);

        ArrayList<Student> studentList = StudentDB.getInstance().getStudentList();
        for(int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);

            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);

            ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName());
            ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName());
            root.addView(row_view);
        }
    }

}
