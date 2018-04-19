package pl.marek.model;

import java.util.List;

public class SuccessfulResponse {
    private int code = 0;
    private List<Node> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Node> getData() {
        return data;
    }

    public void setData(List<Node> data) {
        this.data = data;
    }
}
