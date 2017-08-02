package sg.edu.rp.webservices.pd4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private ArrayAdapter<Projects> aaProg;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog_pd);

        lvProg = (ListView) findViewById(R.id.lvProgramming);
        alProg = new ArrayList<Projects>();
        aaProg = new ArrayAdapter<Projects>(this, android.R.layout.simple_list_item_1, alProg);
        lvProg.setAdapter(aaProg);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("projects");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Projects projects = dataSnapshot.getValue(Projects.class);
                if (projects != null){
                    projects.setId(dataSnapshot.getKey());
                    aaProg.notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
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

    }
}
