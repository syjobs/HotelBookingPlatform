package com.yang.hrms.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunyang
 * @date 2019/12/3
 * 查询结果的分页
 */
public class PageQueryResult<T> implements Serializable{
    private int currentPage;
    private int pageSize;
    private int totalRecords;
    private int totalPages;
    private List<T> queryResultList;

    public PageQueryResult() {
    }

    public PageQueryResult(int currentPage, int pageSize, int totalRecords, int totalPages, List<T> queryResultList) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
        this.queryResultList = queryResultList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getQueryResultList() {
        return queryResultList;
    }

    public void setQueryResultList(List<T> queryResultList) {
        this.queryResultList = queryResultList;
    }
}
