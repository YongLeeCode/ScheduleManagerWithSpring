package com.schedulemanager.pagination;

import lombok.Getter;

/**
 * @author : yong
 * @packageName : com.schedulemanager.pagination
 * @fileName : Paginaton
 * @date : 3/23/25
 * @description :
 */
@Getter
public class Pagination {
    private final int offset;
    private final int limit;

    public Pagination(int quantityPerPage, int pageNumber) {
        this.limit = quantityPerPage;
        this.offset = (quantityPerPage * pageNumber) - quantityPerPage;
    }
}
