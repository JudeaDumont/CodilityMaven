import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;

import java.nio.file.Paths;

public class S3UploadUtility {

    private static final Region DEFAULT_REGION = Region.US_EAST_1; // Default region, can be customized

    public static void uploadFile(String bucketName, String keyName, String filePath) {
        // Create an S3 client
        S3Client s3 = S3Client.builder()
                .region(DEFAULT_REGION)
                .credentialsProvider(ProfileCredentialsProvider.create())
                .build();

        try {
            // Create a PutObjectRequest
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(keyName)
                    .build();

            // Upload the file
            PutObjectResponse response = s3.putObject(putObjectRequest, RequestBody.fromFile(Paths.get(filePath)));
            System.out.println("File uploaded successfully. ETag: " + response.eTag());
        } catch (S3Exception e) {
            System.err.println("Error occurred while uploading the file to S3: " + e.awsErrorDetails().errorMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the S3 client
            s3.close();
        }
    }

    public static void main(String[] args) {
        // Example usage
        String bucketName = "your-bucket-name";
        String keyName = "your-file-key";
        String filePath = "path/to/your/file.txt";

        uploadFile(bucketName, keyName, filePath);
    }
}