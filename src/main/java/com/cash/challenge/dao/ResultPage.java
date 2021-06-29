package com.cash.challenge.dao;

import java.util.List;

public class ResultPage<T> {
    private List<T> items;
    private PageOptions paging;
    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PageOptions getPaging() {
        return paging;
    }

    public void setPaging(PageOptions page) {
        this.paging = page;
    }

}
