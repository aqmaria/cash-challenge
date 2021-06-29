package com.cash.challenge.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PageOptions {
    private Integer size = 10;
    private Integer number = 1;
    private Integer offset = 0;
    private Long total = 0L;

    @JsonIgnore
    public int getMaxResults() {
        return this.size;
    }
    @JsonIgnore
    public int getFirstResult() {
        int offset = this.offset != null ? this.offset : 0;
        int number = this.number != null ? this.number : 1;
        return offset + (number - 1) * size;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString(){
        return "PageOptions[size:"+size.toString()+
                "number:"+number.toString()+
                "total:"+total.toString()+"]";
    }
}
