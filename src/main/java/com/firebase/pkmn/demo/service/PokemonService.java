package com.firebase.pkmn.demo.service;


import com.firebase.pkmn.demo.entity.Pokemon;
import com.firebase.pkmn.demo.firebase.FirebaseInitialization;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PokemonService {
    public static final String COL_NAME = "pokemon";

    @Autowired
    FirebaseInitialization db;

    public Pokemon getPokemon(String name) throws ExecutionException, InterruptedException {
        DocumentReference documentReference = db.getFirebase().collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        if(document.exists()) {
            Pokemon pokemon = document.toObject(Pokemon.class);
            return pokemon;
        } else {
            return null;
        }
    }

    public List<Pokemon> getAllPokemon() throws InterruptedException, ExecutionException {
        List<Pokemon> charList = new ArrayList<Pokemon>();
        CollectionReference character = db.getFirebase().collection(COL_NAME);
        ApiFuture<QuerySnapshot> querySnapshot = character.get();
        for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
            charList.add(doc.toObject(Pokemon.class));
        }
        return charList;
    }

}
