package top.lucas9.blog.entity;

import java.io.Serializable;

public class ResultEntity<T> implements Serializable{

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    public static final String NO_MESSAGE = "NO_MESSAGE";
    public static final String NO_DATA = "NO_DATA";

    private String result;
    private String message;
    private T data;

    public static ResultEntity<String> success() {
        return new ResultEntity<String>(SUCCESS, NO_MESSAGE, NO_DATA);
    }

    public static ResultEntity<String> success(String message) {
        return new ResultEntity<String>(SUCCESS, message, NO_DATA);
    }

    public static<E> ResultEntity<E> success(String message, E data) {
        return new ResultEntity<E>(SUCCESS, message, data);
    }

    public static<E> ResultEntity<E> success(E data) {
        return new ResultEntity<E>(SUCCESS, NO_MESSAGE, data);
    }


    public static ResultEntity<String> failed() {
        return new ResultEntity<String>(FAILED, NO_MESSAGE, NO_DATA);
    }

    public static ResultEntity<String> failed(String message) {
        return new ResultEntity<String>(FAILED, message, NO_DATA);
    }

    public static<E> ResultEntity<E> failed(String message, E data) {
        return new ResultEntity<E>(FAILED, message, data);
    }

    public static<E> ResultEntity<E> failed(E data) {
        return new ResultEntity<E>(FAILED, NO_MESSAGE, data);
    }



    public ResultEntity() {

    }

    public ResultEntity(String result, String message, T data) {
        super();
        this.result = result;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
