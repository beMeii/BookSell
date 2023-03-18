package com.prm.group6.config;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@Configuration
public class FirebaseConfig {
    final String filePath = "src/main/java/com/prm/group6/config/serviceAccountKey.json";

//    @Bean
//    GoogleCredentials googleCredentials() {
//        if (firebaseProperties.getServiceAccount() != null) {
//            try (InputStream is = firebaseProperties.getServiceAccount().getInputStream()) {
//                return GoogleCredentials.fromStream(is);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        else {
//            // Use standard credentials chain. Useful when running inside GKE
//            return GoogleCredentials.getApplicationDefault();
//        }
//    }

    @Bean
    public FirebaseApp firebaseApp() throws IOException {

        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new FileInputStream(filePath)))
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        for (FirebaseApp app : firebaseApps) {
            if (app.getName().equals(FirebaseApp.DEFAULT_APP_NAME)) {
                firebaseApp = app;
                break;
            }
        }
        if (firebaseApp == null) {
            firebaseApp = FirebaseApp.initializeApp(options);
        }
        return firebaseApp;


//        FileInputStream serviceAccount =
//                new FileInputStream("path/to/serviceAccountKey.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//
//
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(credentials)
//                .build();
//
//        return FirebaseApp.initializeApp(options);
    }

    @Bean
    FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp) {
        return FirebaseMessaging.getInstance(firebaseApp);
    }

//    public String uploadFile(File file, String fileName) throws IOException {
//        BlobId blobId = BlobId.of("hire-a-shelf.appspot.com", fileName);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
//        Credentials credentials = GoogleCredentials.fromStream(new FileInputStream(filePath));
//        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//        storage.create(blobInfo, Files.readAllBytes(file.toPath()));
//        return String.format("https://firebasestorage.googleapis.com/v0/b/hire-a-shelf.appspot.com/o/%s?alt=media", URLEncoder.encode(fileName, StandardCharsets.UTF_8));
//    }

}
