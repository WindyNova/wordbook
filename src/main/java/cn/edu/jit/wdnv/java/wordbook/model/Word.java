package cn.edu.jit.wdnv.java.wordbook.model;

import lombok.Data;

/**
 * Table: word_table
 */
@Data
public class Word {
    /**
     * Column: word
     * Type: VARCHAR(50)
     */
    private String word;

    /**
     * Column: meaning
     * Type: VARCHAR(200)
     */
    private String meaning;
}