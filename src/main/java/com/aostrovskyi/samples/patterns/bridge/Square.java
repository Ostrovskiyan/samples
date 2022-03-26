package com.aostrovskyi.samples.patterns.bridge;

class Square extends Shape {

    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName() {
        return "Square";
    }
}
