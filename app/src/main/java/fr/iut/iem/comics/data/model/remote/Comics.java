package fr.iut.iem.comics.data.model.remote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by louis on 10/12/2017.
 */

public class Comics {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("diamondCode")
    @Expose
    private String diamondCode;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("pageCount")
    @Expose
    private int pageCount;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("creators")
    @Expose
    private List<Creator> creators = null;

    public Comics(int id, String title, String description, String diamondCode, String date, double price, int pageCount, String image, List<Creator> creators) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.diamondCode = diamondCode;
        this.date = date;
        this.price = price;
        this.pageCount = pageCount;
        this.image = image;
        this.creators = creators;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }
}
