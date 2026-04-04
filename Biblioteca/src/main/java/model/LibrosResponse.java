package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LibrosResponse {
    @SerializedName("data")
    @Expose
    private List<Libro> data = new ArrayList<>();

    public LibrosResponse() {
    }

    public LibrosResponse(List<Libro> data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "LibrosResponse{data="+data+'}';
    }
    public List<Libro> getData() {
        return data;
    }

    public void setData(List<Libro> data) {
        this.data = data;
    }
}
