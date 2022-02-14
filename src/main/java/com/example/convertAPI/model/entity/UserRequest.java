package com.example.convertAPI.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "requests")
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private long id;

    @Lob
    @Column(name = "initial_file", columnDefinition="BLOB", nullable = false)
    private byte[] initialFile;

    @Lob
    @Column(name = "final_file", columnDefinition="BLOB", nullable = false)
    private byte[] finalFile;

    @Column(name = "initial_file_format", nullable = false)
    private String initialFileFormat;

    @Column(name = "final_file_format", nullable = false)
    private String finalFileFormat;

    @Column(name = "user_time", columnDefinition="DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date userTime;

    @Column(name = "serverTime", columnDefinition="DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date serverTime;

    public UserRequest(byte[] initialFile, byte[] finalFile, String initialFileFormat, String finalFileFormat, Date userTime, Date serverTime) {
        this.initialFile = initialFile;
        this.finalFile = finalFile;
        this.initialFileFormat = initialFileFormat;
        this.finalFileFormat = finalFileFormat;
        this.userTime = userTime;
        this.serverTime = serverTime;
    }

    public UserRequest() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getInitialFile() {
        return initialFile;
    }

    public void setInitialFile(byte[] initialFile) {
        this.initialFile = initialFile;
    }

    public byte[] getFinalFile() {
        return finalFile;
    }

    public void setFinalFile(byte[] finalFile) {
        this.finalFile = finalFile;
    }

    public String getInitialFileFormat() {
        return initialFileFormat;
    }

    public void setInitialFileFormat(String initialFileFormat) {
        this.initialFileFormat = initialFileFormat;
    }

    public String getFinalFileFormat() {
        return finalFileFormat;
    }

    public void setFinalFileFormat(String finalFileFormat) {
        this.finalFileFormat = finalFileFormat;
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }
}
