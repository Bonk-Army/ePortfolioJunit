package example1;

import exception.UndefinedException;

public class Calculator {
    private Integer x;
    private Integer y;

    public Calculator() {
    }

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int add() throws UndefinedException {
        if (this.x == null || this.y == null) {
            throw new UndefinedException();
        }
        return this.x + this.y;
    }

    public int add(int x, int y) {
        return x + y;
    }
}
