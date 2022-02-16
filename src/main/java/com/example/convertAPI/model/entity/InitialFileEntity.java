package com.example.convertAPI.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "initial_files")
public class InitialFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private long id;

    @Lob
    @Column(name = "file", columnDefinition = "BLOB", nullable = false)
    private byte[] file;

    @Column(name = "file_format", nullable = false)
    private String fileFormat;

    @Column(name = "serverTime", columnDefinition = "DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date serverTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "final_file_id", referencedColumnName = "id")
    private FinalFileEntity finalFile;

    public InitialFileEntity(byte[] file, String fileFormat, Date serverTime, FinalFileEntity finalFileEntity) {
        this.file = file;
        this.fileFormat = fileFormat;
        this.serverTime = serverTime;
        this.finalFile = finalFileEntity;
    }

    public InitialFileEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] initialFile) {
        this.file = initialFile;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public FinalFileEntity getFinalFile() {
        return finalFile;
    }

    public void setFinalFile(FinalFileEntity finalFile) {
        this.finalFile = finalFile;
    }
}
