package com.example.model.viber;

public class FileMessageModel extends BasicMessageModel {
    public static final String TYPE="file";
    protected String media;
    protected String file_name;
    protected long size;

    public FileMessageModel(String receiver, String type, String media, String file_name, long size) {
        super(receiver, type);
        this.media = media;
        this.file_name = file_name;
        this.size = size;
    }

    @Override
    public String getText() {
        return media;
    }

    @Override
    public void setText(String media) {
        this.media = media;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
