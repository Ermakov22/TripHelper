package com.example.triphelper.mvp.core;

public enum FragmentByName {
    FIRST_START_FRAGMENT("FIRST_START_FRAGMENT"),
    SECOND_START_FRAGMENT("SECOND_START_FRAGMENT"),
    THIRD_START_FRAGMENT("THIRD_START_FRAGMENT"),
    LIST_OF_PLACES_FRAGMENT("LIST_OF_PLACES_FRAGMENT"),
    LONG_DESCRIPTION_FRAGMENT("LONG_DESCRIPTION_FRAGMENT");

    private final String name;

    FragmentByName(String fragmentName) {
        name = fragmentName;
    }

    public boolean equalsName(String compareName) {
        return name.equals(compareName);
    }

    public String toString() {
        return this.name;
    }
}
