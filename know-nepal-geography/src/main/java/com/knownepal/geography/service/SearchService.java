package com.knownepal.geography.service;

import com.knownepal.geography.dto.response.SearchResponse;

public interface SearchService {

    SearchResponse search(String query);
}
