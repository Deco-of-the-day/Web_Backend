package com.dotd.api.core.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileUploadResponse {

    private String fileName;
    private String fileDownloadUrl;
    private String fileType;
    private long size;

    public FileUploadResponse(String fileName, String fileDownloadUrl, String fileType, long size){
        this.fileName = fileName;
        this.fileDownloadUrl = fileDownloadUrl;
        this.fileType = fileType;
        this.size = size;
    }

}
