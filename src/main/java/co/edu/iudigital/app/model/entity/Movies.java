package co.edu.iudigital.app.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movies implements Serializable{
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "movie_id")
 private int id;
 private String name;
 private String descripcion;
 private String image;
 @Column(name = "create_at")
 private LocalDateTime createAt;
 private String actors;
 @Column(name = "release_date")
 private LocalDateTime release;
 @ManyToOne
 @JoinColumn(name = "gender_id")
 private Genders genderId;
 private int rating;

 /*getters and setters*/

 public int getId() {
	return id;
 }

 public void setId(int id) {
	this.id = id;
 }

 public String getName() {
	return name;
 }

 public void setName(String name) {
	this.name = name;
 }

 public String getDescripcion() {
	return descripcion;
 }

 public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
 }

 public String getImage() {
	return image;
 }

 public void setImage(String image) {
	this.image = image;
 }

 public LocalDateTime getCreateAt() {
	return createAt;
 }

 public void setCreateAt(LocalDateTime createAt) {
	this.createAt = createAt;
 }

 public String getActors() {
	return actors;
 }

 public void setActors(String actors) {
	this.actors = actors;
 }

 public LocalDateTime getRelease() {
	return release;
 }

 public void setRelease(LocalDateTime release) {
	this.release = release;
 }

 public Genders getGenderId() {
	return genderId;
 }

 public void setGenderId(Genders genderId) {
	this.genderId = genderId;
 }

 public int getRating() {
	return rating;
 }

 public void setRating(int rating) {
	this.rating = rating;
 }
 
 /* Constructor */

 public Movies(int id, String name, String descripcion, String image, LocalDateTime createAt, String actors,
		LocalDateTime release, Genders genderId, int rating) {
	super();
	this.id = id;
	this.name = name;
	this.descripcion = descripcion;
	this.image = image;
	this.createAt = createAt;
	this.actors = actors;
	this.release = release;
	this.genderId = genderId;
	this.rating = rating;
 }
 public Movies() {
	
 }
      
}
