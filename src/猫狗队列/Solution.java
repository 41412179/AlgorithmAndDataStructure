package 猫狗队列;

//可以查看pet的类型，初始化的时候设置宠物的类型

class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {
    Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    Cat() {
        super("cat");
    }
}

class PetQueue {
    public void add(Pet pet) {

    }

}

public class Solution {

    public static void main(String[] args) {

    }

}
