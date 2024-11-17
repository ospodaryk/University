package com.botscrew.university.entity;

public enum Degree {
    ASSISTANT("Assistant"),
    ASSOCIATE_PROFESSOR("Associate professor"),
    PROFESSOR("Professor");

    private final String degreeName;

    Degree(String degreeName) {
        this.degreeName = degreeName;
    }

    @Override
    public String toString() {
        return degreeName;
    }
}
