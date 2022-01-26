package com.example.communication.provider;

import cn.ucloud.ufile.UfileClient;
import cn.ucloud.ufile.api.bucket.BucketType;
import cn.ucloud.ufile.api.object.ObjectConfig;
import cn.ucloud.ufile.api.object.PutStreamApi;
import cn.ucloud.ufile.auth.*;
import cn.ucloud.ufile.auth.sign.UfileSignatureException;
import cn.ucloud.ufile.bean.BucketResponse;
import cn.ucloud.ufile.bean.PutObjectResultBean;
import cn.ucloud.ufile.exception.UfileClientException;
import cn.ucloud.ufile.exception.UfileFileException;
import cn.ucloud.ufile.exception.UfileParamException;
import cn.ucloud.ufile.exception.UfileServerException;
import cn.ucloud.ufile.http.OnProgressListener;
import cn.ucloud.ufile.util.MimeTypeUtil;
import com.example.communication.dto.UploadResDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.UUID;

@Component
public class UcloudProvider {

    @Value("${ucloud.publicKey}")
    private  String publicKey;

    @Value("${ucloud.privateKey}")
    private String privateKey;

    @Value("${ucloud.region}")
    private String region;

    @Value("${ucloud.proxySuffix}")
    private String proxySuffix;

    @Value("${ucloud.bucketName}")
    private String bucketName;

    @Value("${ucloud.expiresDuration}")
    private Integer expiresDuration;

    @ResponseBody
    public UploadResDto uploadFile(InputStream fileInputStream, String fileName) throws UfileFileException, FileNotFoundException {
        // 对象相关API的授权器
        ObjectAuthorization OBJECT_AUTHORIZER = new UfileObjectLocalAuthorization(
                publicKey, privateKey);
        ObjectConfig config = new ObjectConfig(region, proxySuffix);

        String mimeType = MimeTypeUtil.getMimeType(fileName);
        String s1 = split(fileName);
        String s = UUID.randomUUID().toString();
        // 上传
        try {
            PutObjectResultBean response = UfileClient.object(OBJECT_AUTHORIZER, config)
                    .putObject(fileInputStream, fileInputStream.available(), mimeType)
                    .nameAs(s+s1)
                    .toBucket(bucketName)
                    .setOnProgressListener(new OnProgressListener() {
                        @Override
                        public void onProgress(long bytesWritten, long contentLength) {

                        }
                    })
                    .execute();
        } catch (UfileClientException e) {
            e.printStackTrace();
        } catch (UfileServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取Url
        String url = "";
        try {
            url = UfileClient.object(OBJECT_AUTHORIZER, config)
                    .getDownloadUrlFromPrivateBucket(s+s1, bucketName, expiresDuration)
                    .createUrl();
        } catch (UfileParamException e) {
            e.printStackTrace();
        } catch (UfileAuthorizationException e) {
            e.printStackTrace();
        } catch (UfileSignatureException e) {
            e.printStackTrace();
        } catch (UfileClientException e) {
            e.printStackTrace();
        }
        UploadResDto uploadResDto = new UploadResDto();
        uploadResDto.setUrl(url);
        uploadResDto.setSuccess(1);
        uploadResDto.setMessage("上传成功");
        return uploadResDto;
    }

    private String split(String fileName) {
        if (fileName == null || fileName == "" || !fileName.contains("."))
            return "";

        int lastDot = fileName.lastIndexOf(".");
        if (lastDot > (fileName.length() - 2))
            fileName = "";
        else
            fileName = fileName.substring(lastDot + 1);
        return fileName;
    }

}
