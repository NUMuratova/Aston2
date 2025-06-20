package org.example;

import java.util.Arrays;

public class Main4 {
        public static void main(String[] args) {
            Animal dogBobik = new Dog("Бобик");
            Animal catBarsik = new Cat("Барсик");

            dogBobik.run(300);
            catBarsik.run(100);
            dogBobik.swim(8);
            catBarsik.swim(5);

            System.out.println("\nВсего создано животных: " + Animal.getAnimalCount());
            System.out.println("Собак: " + Dog.getDogCount());
            System.out.println("Котов: " + Cat.getCatCount() + "\n");

            Bowl bowl = new Bowl();
            bowl.addFood(10);

            Cat[] cats = {new Cat("Том"), new Cat("Джери"), new Cat("Гарфилд")};

            Arrays.stream(cats).forEach(cat -> cat.tryEating(bowl));

            Arrays.stream(cats).forEach(cat -> System.out.printf("%s %s\n",
                    cat.getName(),
                    cat.isSatiated() ? "сыт" : "голоден"));
        }
    }

    abstract class Animal {
        private static int count = 0;
        private final String name;
        private final int maxRunDistance;
        private final int maxSwimDistance;

        Animal(String name, int maxRunDistance, int maxSwimDistance) {
            this.name = name;
            this.maxRunDistance = maxRunDistance;
            this.maxSwimDistance = maxSwimDistance;
            count++;
        }

        public void run(int distance) {
            if (distance > maxRunDistance) {
                System.out.println(name + " не способен пробежать столько (" + distance + " м.)");
            } else {
                System.out.println(name + " пробежал " + distance + " метров.");
            }
        }

        public void swim(int distance) {
            if (maxSwimDistance == 0 || distance > maxSwimDistance) {
                System.out.println(name + " не умеет плавать или не способен проплыть столько (" + distance + " м.)");
            } else {
                System.out.println(name + " проплыл " + distance + " метров.");
            }
        }

        public static int getAnimalCount() {
            return count;
        }

        public String getName() {
            return name;
        }
    }

    class Dog extends Animal {
        private static int dogsCreated = 0;

        Dog(String name) {
            super(name, 500, 10);          // Ограничение: 500 метров бегом, 10 метров плаванием
            dogsCreated++;
        }

        public static int getDogCount() {
            return dogsCreated;
        }
    }

    class Cat extends Animal implements Eater {
        private static int catsCreated = 0;
        private boolean satiated = false;
        private final int appetite = 7;

        Cat(String name) {
            super(name, 200, 0);           // Ограничение: 200 метров бегом, не умеют плавать
            catsCreated++;
        }

        @Override
        public void tryEating(Bowl bowl) {
            if (!isSatiated()) {
                if (bowl.takeFood(appetite)) {
                    satiated = true;
                    System.out.println(getName() + " съел из миски и стал сытым.");
                } else {
                    System.out.println(getName() + " остался голодным! Недостаточно еды в миске.");
                }
            }
        }

        public boolean isSatiated() {
            return satiated;
        }

        public static int getCatCount() {
            return catsCreated;
        }

    }

    interface Eater {
        void tryEating(Bowl bowl);
    }

    class Bowl {
        private int foodLevel = 0;

        public void addFood(int amount) {
            foodLevel += amount;
        }

        public boolean takeFood(int amount) {
            if (foodLevel >= amount) {
                foodLevel -= amount;
                return true;
            }
            return false;
        }

        public int getFoodLevel() {
            return foodLevel;
        }
    }
