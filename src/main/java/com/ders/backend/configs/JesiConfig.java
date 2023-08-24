package com.ders.backend.configs;

import org.redmark.jesi.Jesi;
import org.redmark.jesi.JesiBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JesiConfig {
    private final Jesi jesi;
    public JesiConfig()
    {jesi = null; }

    public JesiConfig(String folderPath) {
        jesi = new JesiBuilder().buildIndex(folderPath);
    }

    public Map<String, Double> searchJesi(String searchTerm)
    {
        return jesi.search(searchTerm);
    }
}