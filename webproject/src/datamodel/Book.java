package datamodel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8
 CREATE TABLE book (
  id INT NOT NULL AUTO_INCREMENT,    
  title VARCHAR(30) NOT NULL,   
  author VARCHAR(30),
  genre VARCHAR(30),
  mood VARCHAR(30) CHECK (mood='Sad' OR mood='Happy' OR mood='Motivated' OR mood='Curious'),
  priority INT(3) CHECK (priority >=1 AND priority <= 3),
  PRIMARY KEY (id));
 */
@Entity
@Table(name = "book")
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Integer id;

   @Column(name = "title")
   private String title;

   @Column(name = "author")
   private String author;
   
   @Column(name = "genre")
   private String genre;
   
   @Column(name = "mood")
   private String mood;

   @Column(name = "priority")
   private Integer priority;
   public Book() {
   }

   public Book(Integer id, String title, String author, String genre, String mood, Integer priority) {
	      this.id = id;
	      this.title = title;
	      this.author = author;
	      this.genre = genre;
	      this.mood = mood;
	      this.priority = priority;
	   }
   
   public Book(String title, String author, String genre, String mood, Integer priority) {
	      this.title = title;
	      this.author = author;
	      this.genre = genre;
	      this.mood = mood;
	      this.priority = priority;
	   }
   
   public Book(Integer id, String title, Integer priority) {
      this.id = id;
      this.title = title;
      this.priority = priority;
   }

   public Book(String title, int priority) {
      this.title = title;
      this.priority = priority;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor (String author) {
      this.author = author;
   }
   
   public String getGenre() {
	      return genre;
	}

	public void setGenre (String genre) {
	      this.genre = genre;
	}
	
	public String getMood() {
	      return mood;
	}

	public void setMood (String mood) {
	      this.mood = mood;
	}

   public Integer getPriority() {
	      return priority;
	}

   public void setPriority(Integer priority) {
	      this.priority = priority;
	}
   @Override
   public String toString() {
      return "Book: " + this.id + ", " + this.title + ", " + this.author + ", " + this.genre + ", " + this.mood + ", " + this.priority;
   }
}