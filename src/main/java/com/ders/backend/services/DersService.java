package com.ders.backend.services;

import java.util.Map;

public interface DersService {
    Map<String, Double> searchResume(String searchWords);

    String indexFiles(String path);
}
