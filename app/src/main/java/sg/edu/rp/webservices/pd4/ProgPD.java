package sg.edu.rp.webservices.pd4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProgPD extends AppCompatActivity {
    private ListView lvProg;
    private ArrayList<Projects> alProg;
    private ArrayAdapter aaProg;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog_pd);

        Log.e("", "debug:: oncr8 done");

        lvProg = (ListView) findViewById(R.id.lvProgramming);
        alProg = new ArrayList<Projects>();
        aaProg = new ProjectAdapter(this, R.layout.row, alProg);
        lvProg.setAdapter(aaProg);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("projects");
        Log.e("", "debug:: oncr8 done 3");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Projects projects = dataSnapshot.getValue(Projects.class);
                if (projects != null) {
                    projects.setId(dataSnapshot.getKey());

                    alProg.add(projects);
                    aaProg.notifyDataSetChanged();
                }

            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Log.e("", "debug:: oncr8 done 5");

                String selectedId = dataSnapshot.getKey();
                Projects projects = dataSnapshot.getValue(Projects.class);
                if (projects != null) {
                    for (int i = 0; i < alProg.size(); i++) {
                        if (alProg.get(i).getId().equals(selectedId)) {
                            projects.setId(selectedId);
                            alProg.set(i, projects);
                        }
                    }
                    aaProg.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lvProg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //do something with this
            }
        });


    }
}