//package com.champis.domain;
//
//import jakarta.persistence.*;
//
//import java.sql.Timestamp;
//import java.time.Instant;
//
//@Table(name = "tb_champisbox", indexes = {
//        @Index(name = "fk_user", columnList = "fk_user")
//})
//@Entity
//@NamedQueries({
//    @NamedQuery(name = "ChampisBox.findAll" , query = "SELECT c.id as id," +
//            " c.boxName as boxName, " +
//            "c.temp as temp, c.minTemp as minTemp, " +
//            "c.humidity as humidity, " +
//            "c.minHume as minHume, " +
//            "c.lastUpdate as lastUpdate" +
//            " FROM ChampisBox c WHERE c.fkUser = :idUser")
//})
//public class ChampisBox {
//
//
//    @Id
//    @Column(name = "id_box", nullable = false, length = 10)
//    private String id;
//
//    @Column(name = "box_name", length = 30)
//    private String boxName;
//
//    @Column(name = "temp")
//    private Double temp;
//
//    @Column(name = "min_temp")
//    private Double minTemp;
//
//    @Column(name = "humidity")
//    private Integer humidity;
//
//    @Column(name = "min_hume")
//    private Integer minHume;
//
//    @Column(name = "last_update")
//    private Timestamp lastUpdate;
//
//    @ManyToOne
//    @JoinColumn(name = "fk_user")
//    private User fkUser;
//
//
//    public ChampisBox() {
//    }
//
//    public ChampisBox(String id, Double minTemp) {
//        this.id = id;
//        this.minTemp = minTemp;
//    }
//
//    public ChampisBox(String id, Integer minHume) {
//        this.id = id;
//        this.minHume = minHume;
//    }
//
//    public ChampisBox(String id, String boxName) {
//        this.id = id;
//        this.boxName = boxName;
//    }
//
//    public ChampisBox(String id, Double temp, Integer humidity) {
//        this.id = id;
//        this.temp = temp;
//        this.humidity = humidity;
//        this.lastUpdate = lastUpdate;
//    }
//
//    public ChampisBox(String id, String boxName, Double temp, Double minTemp, Integer humidity, Integer minHume, Timestamp lastUpdate, User fkUser) {
//        this.id = id;
//        this.boxName = boxName;
//        this.temp = temp;
//        this.minTemp = minTemp;
//        this.humidity = humidity;
//        this.minHume = minHume;
//        this.lastUpdate = lastUpdate;
//        this.fkUser = fkUser;
//    }
//
//    public User getFkUser() {
//        return fkUser;
//    }
//
//    public void setFkUser(User fkUser) {
//        this.fkUser = fkUser;
//    }
//
//    public Timestamp getLastUpdate() {
//        return lastUpdate;
//    }
//
//    public void setLastUpdate(Timestamp lastUpdate) {
//        this.lastUpdate = lastUpdate;
//    }
//
//    public Integer getMinHume() {
//        return minHume;
//    }
//
//    public void setMinHume(Integer minHume) {
//        this.minHume = minHume;
//    }
//
//    public Integer getHumidity() {
//        return humidity;
//    }
//
//    public void setHumidity(Integer humidity) {
//        this.humidity = humidity;
//    }
//
//    public Double getMinTemp() {
//        return minTemp;
//    }
//
//    public void setMinTemp(Double minTemp) {
//        this.minTemp = minTemp;
//    }
//
//    public Double getTemp() {
//        return temp;
//    }
//
//    public void setTemp(Double temp) {
//        this.temp = temp;
//    }
//
//    public String getBoxName() {
//        return boxName;
//    }
//
//    public void setBoxName(String boxName) {
//        this.boxName = boxName;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//}