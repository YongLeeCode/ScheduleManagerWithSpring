package com.schedulemanager.pagination;

import lombok.Getter;

/**
 * @author : yong
 * @packageName : com.schedulemanager.pagination
 * @fileName : Paginaton
 * @date : 3/23/25
 * @description :
 */
public class Pagination {
    private long totalCount;
    private long pageCount;

    @Getter
    private long offset;
    @Getter
    private long limit;

    private boolean prevPage;
    private boolean nextPage;


}
