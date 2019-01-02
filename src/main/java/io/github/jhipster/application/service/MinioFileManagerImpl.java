package io.github.jhipster.application.service;

import io.github.jhipster.application.service.exceptions.FileManagerException;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinioFileManagerImpl implements FileManager {

    private final Logger log = LoggerFactory.getLogger(MinioFileManagerImpl.class);

    //@Value("${solutions.autorun.academy.minio.endpoint}")
    String minioEndpoint="https://play.minio.io:9000";
   // @Value("${solutions.autorun.academy.minio.accessKey}")
    String minioAccessKey="Q3AM3UQ867SPQQA43P2F";
   // @Value("${solutions.autorun.academy.minio.secretKey}")
    String minioSecretKey="zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG";
  //  @Value("${solutions.autorun.academy.minio.bucket}")
    String minioBucket="invoicesbucket";




    @Override
    public String addFile(MultipartFile file, String fileName) {
        try {
            MinioClient minioClient = new MinioClient(minioEndpoint, minioAccessKey,
                    minioSecretKey);
            boolean found = minioClient.bucketExists(minioBucket);
            if (found) {
                log.trace(minioBucket + " already exists");
            } else {
                minioClient.makeBucket(minioBucket);
                log.trace(minioBucket + " is created successfully");
            }

            byte [] byteArr=file.getBytes();
            InputStream bais = new ByteArrayInputStream(byteArr);
            minioClient.putObject(minioBucket, fileName, bais, bais.available(), "application/octet-stream");
            bais.close();
           log.trace(fileName + " is uploaded successfully");
            return fileName + " is uploaded successfully";
        } catch (
                MinioException e) {
            throw new FileManagerException(e.getMessage());
        }

        catch (
                IOException e) {
            throw new FileManagerException(e.getMessage());
        }

        catch (
                NoSuchAlgorithmException e) {
            throw new FileManagerException(e.getMessage());
        }
        catch (
                InvalidKeyException e) {
            throw new FileManagerException(e.getMessage());
        }

        catch (
                XmlPullParserException e) {
            throw new FileManagerException(e.getMessage());
        }
    }

    @Override
    public InputStream getFile(String fileName){
        try {
            MinioClient minioClient = new MinioClient(minioEndpoint, minioAccessKey,
                    minioSecretKey);

            minioClient.statObject(minioBucket, fileName);


           return minioClient.getObject(minioBucket, fileName);



        } catch (MinioException e) {
            throw new FileManagerException(e.getMessage());
        }

        catch (
                IOException e) {
            throw new FileManagerException(e.getMessage());
        }

        catch (
                NoSuchAlgorithmException e) {
            throw new FileManagerException(e.getMessage());
        }
        catch (
                InvalidKeyException e) {
            throw new FileManagerException(e.getMessage());
        }

        catch (
                XmlPullParserException e) {
            throw new FileManagerException(e.getMessage());
        }
    }
}
