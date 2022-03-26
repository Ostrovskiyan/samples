package com.aostrovskyi.samples.patterns.bridge;

public class VectorRenderer implements Renderer {

    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}
