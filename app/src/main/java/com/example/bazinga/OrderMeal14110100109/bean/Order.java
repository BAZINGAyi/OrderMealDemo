package com.example.bazinga.OrderMeal14110100109.bean;

/**
 * Created by bazinga on 2017/4/10.
 */

public class Order {

    /**
     * order_id : 1
     * user_id : 1
     * food_id : 1
     * username : lnn
     * foodname : 酸菜鱼
     * num : 1
     * sum : 23
     * suggesttime : null
     * ordertime : 2016-04-09 00:00:00.0
     * shopname : 满口香川菜2
     * shopaddress : 东软食堂三期
     * price : 23
     * content : null
     * comment_time : null
     */

    private int order_id;
    private int user_id;
    private int food_id;
    private String username;
    private String foodname;
    private int num;
    private int sum;
    private Object suggesttime;
    private String ordertime;
    private String shopname;
    private String shopaddress;
    private int price;
    private Object content;
    private Object comment_time;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Object getSuggesttime() {
        return suggesttime;
    }

    public void setSuggesttime(Object suggesttime) {
        this.suggesttime = suggesttime;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopaddress() {
        return shopaddress;
    }

    public void setShopaddress(String shopaddress) {
        this.shopaddress = shopaddress;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Object getComment_time() {
        return comment_time;
    }

    public void setComment_time(Object comment_time) {
        this.comment_time = comment_time;
    }
}
