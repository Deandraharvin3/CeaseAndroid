package com.example.android;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class User {


    private Boolean success;

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//    CollectionReference users = db.collection("modules");
//    DocumentReference users = db.document("modules/"+user.getUid());

    DocumentReference completed = db.collection("modules").document(user.getUid());

   public User(){
   }

   public Task<DocumentSnapshot> getCompleted(String mod, String less) {

       return completed.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
           @Override
           public void onSuccess(DocumentSnapshot documentSnapshot) {

               Map<String, Object> complete = documentSnapshot.getData();
               for (Map.Entry<String, Object> entry : complete.entrySet()) {
                   if (entry.getKey().equals(mod)) {
                       Map<String, Object> lesson = (Map<String, Object>) entry.getValue();
                       for (Map.Entry<String, Object> e : lesson.entrySet()) {
                           if (e.getKey().equals(less)) {
                               Map<String, Object> fNameMap = (Map<String, Object>) e.getValue();

                           }
                       }
                   }
               }
//                System.out.println("Mod 1: "+ mod1 + "\nCompleted: "+complete);
           }
       });
   }
    
}
