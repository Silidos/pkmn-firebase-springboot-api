This repo is a simple example of a Spring boot REST API service communicating with a Firebase firestore instance. My firebase firestore database has pokemon information in it.
To be able to test this locally and connect to a firebase instance you need to do a few things:
1. Initialize a firebase project and generate a private key JSON.
2. Get the file path of that private key and enter it on line 23 of FirebaseInitialization.java
3. In your firestore database, make sure you have the collection name "pokemon" and with documents that have fields of the Pokemon class in the entity package.

You can change the collection name and object fields to whatever fits your need!