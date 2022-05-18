package com.example.e_commerce.ResponseModelClass;

public class fetch_response_model {
    String id,catname,image,sdec,status;

    public fetch_response_model() {
    }

    public fetch_response_model(String id, String catname, String image, String sdec, String status) {
        this.id = id;
        this.catname = catname;
        this.image = image;
        this.sdec = sdec;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSdec() {
        return sdec;
    }

    public void setSdec(String sdec) {
        this.sdec = sdec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


