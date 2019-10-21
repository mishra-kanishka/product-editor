package com.kanishka.productbackendboot.domain;

import javax.persistence.*;

@Entity
@Table(name = "Detail")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String key;
    private String value;
    @OneToOne (fetch = FetchType.LAZY)
    private Product product;

    public Detail() {

    }

    public Detail(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
