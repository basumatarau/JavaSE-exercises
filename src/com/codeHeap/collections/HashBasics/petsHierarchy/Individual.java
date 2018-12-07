package com.codeHeap.collections.HashBasics.petsHierarchy;

public class Individual implements Comparable<Individual> {

    private static long counter = 0;
    private final long id = ++counter;
    private String name;

    Individual() {
    }

    Individual(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = result * 37 + name.hashCode();
        }
        result = result * 37 + (int) id;
        return result;
    }

    @Override
    public int compareTo(Individual individual) {

        String first = getClass().getSimpleName();
        String argFirst = individual.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && individual.name != null) {
            int secondCompare = name.compareTo(individual.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }

        return (individual.id < id? -1 : (id == individual.id ? 0 : 1));
    }
}
