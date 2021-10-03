package com.rgsystem.emails;

import java.io.File;

public class EmailBody {
    private String subject;
    private File data;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public File getData() {
        return data;
    }

    public void setData(File data) {
        this.data = data;
    }
}
