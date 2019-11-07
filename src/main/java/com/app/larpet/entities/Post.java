package com.app.larpet.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Post{

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String titulo;

    @Column
    private int id_user = 1;

    @Column
    private String animal;

    @Column
    private String cidade_animal;

    @Column
    private String tipo_post;
    
    @Column
    private String info;

    @Column
    private String photos_path = "/photos/j.png";

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getCidade_animal() {
        return cidade_animal;
    }

    public void setCidade_animal(String cidade_animal) {
        this.cidade_animal = cidade_animal;
    }

    public String getTipo_post() {
        return tipo_post;
    }

    public void setTipo_post(String tipo_post) {
        this.tipo_post = tipo_post;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhotos_path() {
        return photos_path;
    }

    public void setPhotos_path(String photos_path) {
        this.photos_path = photos_path;
    }
}