package quizSolutions.java.uploadingToS3BucketViaJava;

import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.nio.file.Paths;

public class S3UploadExample {

    public static void main(String[] args) {
        // Define the region and create an S3 client
        Region region = Region.US_EAST_1; // Choose your region
        S3Client s3 = S3Client.builder()
                .region(region)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        String bucketName = "your-bucket-name";
        String keyName = "your-file-key"; // The object key (filename in the bucket)
        String filePath = "path/to/your/file.txt"; // Local path to the file

        try {
            // Create a PutObjectRequest
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build();

            // Upload the file
            PutObjectResponse response = s3.putObject(putObjectRequest, Paths.get(filePath));
            System.out.println("File uploaded successfully. ETag: " + response.eTag());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the S3 client
            s3.close();
        }
    }
}

