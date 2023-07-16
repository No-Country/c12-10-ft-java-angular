package com.example.demo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "images")
public class Images {
    /*
     * {
     * "user_id": "98765",
     * "image1": "98765-image1.jpg",
     * "image2": "98765-image2.jpg",
     * "image3": "98765-image3.jpg",
     * "image4": "98765-image4.jpg",
     * "image5": "98765-image5.jpg",
     * "image6": "98765-image6.jpg",
     * "image7": "98765-image7.jpg",
     * "image8": "98765-image8.jpg",
     * "image9": "98765-image9.jpg",
     * "image10": "98765-image10.jpg"
     * }
     */
    String id;
    String user_id;
    String image1;
    String image2;
    String image3;
    String image4;
    String image5;
    String image6;
    String image7;
    String image8;
    String image9;
    String image10;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImage1() {
        return this.image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return this.image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return this.image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return this.image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return this.image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImage6() {
        return this.image6;
    }

    public void setImage6(String image6) {
        this.image6 = image6;
    }

    public String getImage7() {
        return this.image7;
    }

    public void setImage7(String image7) {
        this.image7 = image7;
    }

    public String getImage8() {
        return this.image8;
    }

    public void setImage8(String image8) {
        this.image8 = image8;
    }

    public String getImage9() {
        return this.image9;
    }

    public void setImage9(String image9) {
        this.image9 = image9;
    }

    public String getImage10() {
        return this.image10;
    }

    public void setImage10(String image10) {
        this.image10 = image10;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", user_id='" + getUser_id() + "'" +
                ", image1='" + getImage1() + "'" +
                ", image2='" + getImage2() + "'" +
                ", image3='" + getImage3() + "'" +
                ", image4='" + getImage4() + "'" +
                ", image5='" + getImage5() + "'" +
                ", image6='" + getImage6() + "'" +
                ", image7='" + getImage7() + "'" +
                ", image8='" + getImage8() + "'" +
                ", image9='" + getImage9() + "'" +
                ", image10='" + getImage10() + "'" +
                "}";
    }

}
